package yzq.reflect;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DogAnnotation(name = "小黑",age = 3,color = "灰色")
public class Dog {

    private String name = "";

    private int age = 0;

//
//    public Dog() {
//    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Dog(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    /*测试泛型*/
    private Map<Integer, String> testGeneric(List<Boolean> list) {

        return new HashMap<>();

    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
