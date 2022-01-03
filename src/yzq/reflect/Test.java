package yzq.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;

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

                /*方法的参数类型*/
                final Type[] genericParameterTypes = method.getGenericParameterTypes();
                System.out.println("genericParameterTypes = " + genericParameterTypes);

            }
            /*执行某个方法*/
            Method setName = dogClass.getMethod("setName", String.class);
            setName.setAccessible(true);//setAccessible 表示获取访问权限，不在做权限检查，可以提升一丢丢的反射效率
            setName.invoke(instance, "小白");

            System.out.println("instance = " + instance);

            System.out.println("==========================================");


            /*获取泛型的信息*/
            final Method testGeneric = dogClass.getDeclaredMethod("testGeneric", List.class);
            testGeneric.setAccessible(true);
            /*获取方法参数信息*/
            final Type[] genericParameterTypes = testGeneric.getGenericParameterTypes();
            Arrays.stream(genericParameterTypes).forEach(type -> {
                System.out.println("type = " + type);
                /*获取参数里的泛型*/
                if (type instanceof ParameterizedType) {
                    /*获取泛型的类型*/
                    for (Type actualTypeArgument : ((ParameterizedType) type).getActualTypeArguments()) {
                        System.out.println("actualTypeArgument = " + actualTypeArgument);
                    }
                }
            });
            /*返回值的泛型*/
            final Type genericReturnType = testGeneric.getGenericReturnType();
            System.out.println("genericReturnType = " + genericReturnType);
            if (genericReturnType instanceof ParameterizedType) {
                for (Type actualTypeArgument : ((ParameterizedType) genericReturnType).getActualTypeArguments()) {
                    System.out.println("actualTypeArgument = " + actualTypeArgument);
                }
            }


            System.out.println("==========================================");
            /*获取注解信息*/
            final Annotation[] declaredAnnotations = dogClass.getDeclaredAnnotations();
            for (Annotation declaredAnnotation : declaredAnnotations) {
                System.out.println("declaredAnnotation = " + declaredAnnotation);
                if (declaredAnnotation instanceof DogAnnotation){
                    System.out.println("((DogAnnotation) declaredAnnotation).name() = " + ((DogAnnotation) declaredAnnotation).name());
                    System.out.println("((DogAnnotation) declaredAnnotation).age() = " + ((DogAnnotation) declaredAnnotation).age());
                    System.out.println("((DogAnnotation) declaredAnnotation).color() = " + ((DogAnnotation) declaredAnnotation).color());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}


