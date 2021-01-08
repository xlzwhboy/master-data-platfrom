package custom.monster.server;

import custom.monster.core.exception.ErrorCodes;
import custom.monster.core.exception.MonsterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 1.构造我们的comtroller返回值,使其与前端的d2admin框架所需要的数据格式一致
 * 2.实现controller层异常捕获
 */
@ControllerAdvice
public class BaseController {
    //我们返回前端的数据是带1.当前时间 2..响应码 3.数据 4.错误描述/成功描述
    protected SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     *  实现拦截Controller所抛出的异常
     * @param e :异常
     * @param response :前端相应
     * @return
     */
    @ExceptionHandler
    @ResponseBody
    public Map<String,Object> exceptionHandle(Exception e, HttpServletResponse response){
        //1.检测异常是否为我们自己定义的MasterException,如果是那就是主动抛出的异常
        if (MonsterException.class.isAssignableFrom(e.getClass())){
            MonsterException ma = (MonsterException)e;
            return getResultMap(ma.getErrorCode(),ma.getErrorMessage(),null);

        }else{ //否则就是运行时异常
            return getError(ErrorCodes.SYSTEM_EXCEPTION,e.getMessage());
        }
    }

    protected Map<String,Object> getResultMap(Integer code,Object data,Map<String,Object> extraMap){
        String currentTime = sdf.format(new Date());
        HashMap<String,Object> result = new HashMap<String, Object>();

        result.put("currentTime", currentTime);
        if (code == null || code.equals(ErrorCodes.SYSTEM_SUCCESS)){
            result.put("code", code);
            result.put("data", data);
        }else{
            result.put("code", code);
            result.put("msg", data);
        }

        if (extraMap != null && !extraMap.isEmpty()){
            result.putAll(extraMap);
        }
        return result;

    }

    protected Map<String,Object> getError(Integer code,String errMsg){
        return getResultMap(code,errMsg,null);

    }

    protected Map<String, Object> getResult(Object o) {
        return getResultMap(null, o, null);
    }



}
