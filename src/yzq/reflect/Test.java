package yzq.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {

    public static void main(String[] args) {


        try {
            Class<Dog> aClass = (Class<Dog>) Class.forName("yzq.reflect.Dog");

//            Object o = aClass.getConstructor(null).newInstance(null);

//            System.out.println("o = " + o);


            for (Constructor<?> constructor : aClass.getConstructors()) {
                System.out.println("constructor = " + constructor);
            }


            Dog instance = aClass.getConstructor(String.class).newInstance("小黑");
//
            System.out.println("instance = " + instance);
//

            for (Field declaredField : aClass.getDeclaredFields()) {

                System.out.println("declaredField = " + declaredField);

                System.out.println("declaredField.getName() = " + declaredField.getName());

                Field field = aClass.getDeclaredField(declaredField.getName());

                System.out.println("field = " + field);


            }


//            Field age = aClass.getDeclaredField("age");
//            age.setAccessible(true);
//            age.set(instance,500);
//            System.out.println("instance = " + instance);

            Method[] methods = aClass.getMethods();
            for (Method method : methods) {
                System.out.println("method = " + method);
            }


            Method setName = aClass.getMethod("setName", String.class);

            setName.invoke(instance, "小白");

            System.out.println("instance = " + instance);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
