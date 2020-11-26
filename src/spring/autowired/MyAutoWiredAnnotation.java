package spring.autowired;

import java.lang.annotation.*;

/**
 * @author oulei
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Inherited
public @interface MyAutoWiredAnnotation {
}
