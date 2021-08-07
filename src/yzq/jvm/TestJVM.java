package yzq.jvm;

public class TestJVM {
    public static void main(String[] args) {
        String name = "yzq";
        int sum = sum();
        System.out.println("name = " + name);
        System.out.println("sum = " + sum);
    }
    public static int sum() {
        int a = 10;
        int b = 20;
        int sum = a + b;
        return sum;
    }
}
