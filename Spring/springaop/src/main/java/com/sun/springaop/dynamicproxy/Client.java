package com.sun.springaop.dynamicproxy;


import com.sun.springaop.pattern.RealSubject;
import com.sun.springaop.pattern.Subject;

import java.lang.reflect.Proxy;

/**
 * @program: springaop
 * @author: SunBo
 * @create: 2019-06-26 11:14
 **/

public class Client {

    public static void main(String[] args) {
        Subject subject = (Subject) Proxy.newProxyInstance(Client.class.getClassLoader(),new Class[]{Subject.class},
                new JdkProxySubject(new RealSubject()));
    }
}
