package spring.autowired;

/**
 * @author oulei
 */
public class UserController {

    @MyAutoWiredAnnotation
    private UserServiceImpl userService;

    public UserService getUserService() {
        return userService;
    }
}
