package interceptor;

import proxy.HelloWorld;
import proxy.HelloWorldImpl;

public class InterceptorMain {

    public static void main(String[] args) {
        HelloWorld proxy = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(), "interceptor.MyInterceptor");
        proxy.sayHelloWorld();
    }
}

