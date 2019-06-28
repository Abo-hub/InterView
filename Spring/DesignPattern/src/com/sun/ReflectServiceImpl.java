package com.sun;

/**
 * @program: DesignPattern
 * @author: SunBo
 * @create: 2019-06-26 21:36
 **/

public class ReflectServiceImpl {

    public void sayHello(String name) {
        System.err.println("hello:" + name);
    }

    /**
     * 生成一个对象，然后将其返回
     *
     * @return
     */
    public ReflectServiceImpl getInstance() {
        /*
        给类加载器注册了一个ReflectServiceImpl的全限定名，然后通过newInstance方法
        初始化了一个类对象
         */
        ReflectServiceImpl object = null;
        try {
            object = (ReflectServiceImpl) Class.forName("com.sun" +
                    ".ReflectServiceImpl").newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return object;
    }

}
