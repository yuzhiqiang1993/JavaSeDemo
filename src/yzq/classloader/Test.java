package yzq.classloader;

public class Test {
    public static void main(String[] args) {

        /*系统类加载器 AppClassLoader*/
        final ClassLoader systemClassLoader= ClassLoader.getSystemClassLoader();
        System.out.println("systemClassLoader = " + systemClassLoader);

        /*系统类加载器的父类 扩展类加载器ExtClassLoader  */
        final ClassLoader classLoaderParent = systemClassLoader.getParent();
        System.out.println("classLoaderParent = " + classLoaderParent);

        /*跟加载器  BootstrapClassloader*/
        final ClassLoader classLoaderParentParent = classLoaderParent.getParent();
        System.out.println("classLoaderParentParent = " + classLoaderParentParent);
    }
}
