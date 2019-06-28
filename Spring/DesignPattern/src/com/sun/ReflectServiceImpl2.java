package com.sun;

import java.lang.reflect.InvocationTargetException;

/**
 * @program: DesignPattern
 * @author: SunBo
 * @create: 2019-06-26 21:44
 **/

public class ReflectServiceImpl2 {
    private String name;

    public ReflectServiceImpl2(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.err.println("hello:" + name);
    }

    public ReflectServiceImpl2 getInstance() {
        ReflectServiceImpl2 object = null;
        try {
            object =
                    (ReflectServiceImpl2) Class.forName("com.sun" +
                            ".ReflectServiceImpl2").getConstructor(String.class).newInstance("张三");
        } catch (InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return object;
    }
}
