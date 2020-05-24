package com.design.patten.proxy.dynamic;

/**
 * 代理模式：动态代理
 */
public class Client {
    public static void main(String[] args) {
        //创建目标对象
        ITeacherDao target = new TeacherDao();

        //给目标对象，创建代理对象，可以转成 ITeacherDao
        ITeacherDao proxyInstance = (ITeacherDao) new ProxyFactory(target).getProxyInstance();

        System.out.println("proxyInstance="+proxyInstance.getClass());

        //通过代理对象，调用目标对象的方法
         proxyInstance.teach();
         proxyInstance.sayHello("akon");
    }
}
