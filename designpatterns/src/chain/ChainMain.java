package chain;

import proxy.HelloWorld;
import proxy.HelloWorldImpl;

public class ChainMain {

    public static void main(String[] args) {
        HelloWorld proxy1 = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(), "chain.Interceptor1");
        HelloWorld proxy2 = (HelloWorld) InterceptorJdkProxy.bind(proxy1, "chain.Interceptor2");
        HelloWorld proxy3 = (HelloWorld) InterceptorJdkProxy.bind(proxy2, "chain.Interceptor3");

       // proxy3.sayHelloWorld();
       int i=1;
       i = i++;
       System.out.println(i);

    }
}