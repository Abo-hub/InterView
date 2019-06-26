package com.sun.springaop.pattern;

/**
 * 真实对象
 */
public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("real subject execute request");
    }
}
