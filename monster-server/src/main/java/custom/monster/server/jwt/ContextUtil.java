package custom.monster.server.jwt;


import custom.monster.entity.system.User;

public class ContextUtil {
    private static ThreadLocal<User> local = new ThreadLocal<>();

    public static void setCurrentUser(User user) {
        local.set(user);
    }

    public static User getCurrentUser() {
        return local.get();
    }
}
