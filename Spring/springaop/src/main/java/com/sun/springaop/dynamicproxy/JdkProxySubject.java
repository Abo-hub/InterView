package com.sun.springaop.dynamicproxy;

import com.sun.springaop.pattern.RealSubject;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @program: springaop
 * @author: SunBo
 * @create: 2019-06-26 11:05
 **/

public class JdkProxySubject implements InvocationHandler  {

    private RealSubject realSubject;

    public JdkProxySubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result = null;
        try {
            method.invoke(realSubject,args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("after");
        }
        return result;
    }
}
