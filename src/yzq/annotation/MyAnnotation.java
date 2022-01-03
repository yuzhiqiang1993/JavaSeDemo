package yzq.annotation;

import java.lang.annotation.*;

/*自定义的注解*/
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})//中文是目标的意思。定义注解可以在哪些地方使用，一般都是在类、方法、和变量上使用
@Retention(RetentionPolicy.RUNTIME)//中文是保留的意思，表示注解在哪个阶段内还有效，基本上都是在运行时也有效
@Documented//表示是否将注解生成在javadoc中
@Inherited//子类可以继承父类中的该注解
@interface MyAnnotation {

    /*注解的参数 格式  参数类型 参数名()*/
    String name();

    /*可以给个默认值  如果没有默认值 */
    String description() default "默认值";

}
