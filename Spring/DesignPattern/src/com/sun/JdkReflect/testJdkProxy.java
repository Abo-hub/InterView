package com.sun.JdkReflect;

/**
 * @program: DesignPattern
 * @author: SunBo
 * @create: 2019-06-27 11:36
 **/

public class testJdkProxy {

    public static void main(String[] args) {
        JdkProxyExample jdk = new JdkProxyExample();
        //绑定关系，因为挂在接口HelloWorld下，所以声明代理对象helloWorld proxy
        HelloWorld proxy = (HelloWorld) jdk.bind(new HelloWorldImpl());
        proxy.sayHello();
    }


}
