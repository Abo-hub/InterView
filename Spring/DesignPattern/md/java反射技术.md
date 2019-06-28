# Java反射技术
## 简介
Java反射技术应用广泛，他能够配置：类的全限定名、方法和参数，完成对象的初始化，
甚至是反射某些方法。Java反射内容繁多，包括对象构建、反射方法、注解、参数、接口
等。 反射是通过包java.lang.reflect.* 来实现的。
## 通过反射构建对象
这是个构建方法，没有任何参数的类的反射生成。
```java
  
    //生成一个对象，然后将其返回
    //给类加载器注册了一个ReflectServiceImpl的全限定名，然后通过newInstance方法初始化了一个类对象
        ReflectServiceImpl object = null;
        object = (ReflectServiceImpl) Class.forName("com.sun.ReflectServiceImpl").newInstance();
            
```
```java
public class ReflectServiceImpl2 {
    private String name;

    public ReflectServiceImpl2(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.err.println("hello:" + name);
    }
}
```

```java
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
```
先通过forName加载到类的加载器。然后通过getConstructor方法，它的参数可以是多个，这里定义为String.class，意义有且只有一个参数类型为String的构建方法。通过这个方法可以对重名进行排除，此时再用newInstance方法生成对象。

> 反射的优点是只要是配置就可以生成对象，可以接触程序的耦合度，比较灵活。反射的缺点是运行比较慢。但是大部分情况下为了灵活，降低程序耦合度，我们还是会使用反射的，比如Spring IoC 容器。




