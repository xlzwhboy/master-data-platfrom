package custom.monster.server.jwt;


import custom.monster.core.exception.ErrorCodes;
import custom.monster.core.exception.MonsterException;
import custom.monster.entity.system.SystemPrivilege;
import custom.monster.entity.system.User;
import custom.monster.server.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class AuthInterceptor implements HandlerInterceptor {
    @Autowired
    SystemService systemService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse,
                             Object object) throws Exception {
        //从http header中获取token
        String token = httpServletRequest.getHeader("token");

        //判断是否loginrequired注解

        if (!(object instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        User user = null;
        if (method.isAnnotationPresent(LoginRequired.class)) {
            //解析token 验证jwt
            LoginRequired annotation = method.getAnnotation(LoginRequired.class);
            if (annotation.required()) {

                if (token == null) {
                    throw new MonsterException("login first", ErrorCodes.SYSTEM_EXCEPTION);
                }

                String userId = JwtManager.parseJwt(token).get("id").toString();

                user = systemService.findUserById(Long.parseLong(userId));
                if (user == null) {
                    throw new MonsterException("user not exists", ErrorCodes.ERROR_USER_NOT_EXISTS);
                }

                Boolean verify = JwtManager.isVerify(token, user.getPwd());
                if (!verify) {
                    throw new MonsterException("password error", ErrorCodes.ERROR_PASSWORD);
                }

                ContextUtil.setCurrentUser(user);

                //校验权限

                if (method.isAnnotationPresent(PrivilegeCheck.class)) {
                    PrivilegeCheck privilegeCheck = method.getAnnotation(PrivilegeCheck.class);
                    SystemPrivilege systemPrivilege = systemService.findSystemPrivilege(user.getTeam(), privilegeCheck.privilegeType());
                    if (systemPrivilege == null) {
                        throw new MonsterException("permission denied", ErrorCodes.ERROR_PERMISSION);
                    }
                }

                return true;
            }
        }
        return true;

    }

}
