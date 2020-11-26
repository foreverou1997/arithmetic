package spring.autowired;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author oulei
 */
public class MyAutowired {
    public static void main(String[] args) {
        UserController userController = new UserController();
        Class<UserController> userControllerClass = (Class<UserController>) userController.getClass();
        Field[] fields = userControllerClass.getDeclaredFields();
        Arrays.stream(fields).forEach(t->{
           MyAutoWiredAnnotation autoWiredAnnotation =  t.getAnnotation(MyAutoWiredAnnotation.class);
           if (autoWiredAnnotation != null){
               t.setAccessible(true);
               Class filedClass = t.getType();
               try {
                   Object obj = filedClass.newInstance();
                   t.set(userController, obj);
                   System.out.println(userController.getUserService());
               }catch (Exception e){
                   e.printStackTrace();
               }
           }
        });

    }
}
