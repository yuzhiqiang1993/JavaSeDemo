package yzq.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {

    public static void main(String[] args) {


        try {
            /*获取类的方式*/
            Class<Dog> dogClass = (Class<Dog>) Class.forName("yzq.reflect.Dog");
//            final Class<? extends Dog> aClass1 = new Dog("").getClass();
//            final Class<Dog> dogClass = Dog.class;


            /*包名*/
            System.out.println("dogClass.getName() = " + dogClass.getName());

            /*类名*/
            System.out.println("dogClass.getSimpleName() = " + dogClass.getSimpleName());


//            Object o = dogClass.getConstructor(null).newInstance(null);

//            System.out.println("o = " + o);


            /*构造器*/
            for (Constructor<?> constructor : dogClass.getConstructors()) {
                System.out.println("constructor = " + constructor);
            }
            /*通过构造器创建对象*/
            Dog instance = dogClass.getConstructor(String.class).newInstance("小黑");
//
            System.out.println("instance = " + instance);
//
            /*类的属性*/
            for (Field declaredField : dogClass.getDeclaredFields()) {

                System.out.println("declaredField = " + declaredField);

                System.out.println("declaredField.getName() = " + declaredField.getName());

                Field field = dogClass.getDeclaredField(declaredField.getName());

                System.out.println("field = " + field);


            }


//            Field age = dogClass.getDeclaredField("age");
//            age.setAccessible(true);
//            age.set(instance,500);
//            System.out.println("instance = " + instance);

            /*类的方法*/
            Method[] methods = dogClass.getMethods();
            for (Method method : methods) {
                System.out.println("method = " + method);
            }
            /*执行某个方法*/
            Method setName = dogClass.getMethod("setName", String.class);
            setName.invoke(instance, "小白");

            System.out.println("instance = " + instance);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}


