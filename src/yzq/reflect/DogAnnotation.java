package yzq.reflect;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*测试用的注解*/

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DogAnnotation {

    String name();

    int age();

    String color();

}
