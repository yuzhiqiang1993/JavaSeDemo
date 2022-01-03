package yzq.annotation;


import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @description: 测试自定义注解
 * @date : 2022/1/2
 * @time : 18:14
 */
@MyAnnotation(name = "在类上的注解")
public class TestAnnotation {

    @MyAnnotation(name = "在变量上的注解", description = "描述")
    public String name = "";

    @MyAnnotation(name = "在方法上的注解")
    public void test() {

    }
}



@Target({ElementType.TYPE})
@Retention()
@interface Test_Annotation{



}

