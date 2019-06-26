[toc]     


# 1.1 面向切面编程
## AOP 是什么
1. 是一种编程范式，不是编程语言
2. 解决特定问题，不能解决所有问题
3. 是OOP的补充，不是替代
## 使用AOP的好处
1. 集中处理某一关注点/横切逻辑
2. 可以很方便的添加/删除关注点
3. 侵入性少，增强代码可读性及可维护性
## AOP的应用场景
1. 权限控制
2. 缓存控制
3. 事务控制
4. 审计控制
5. 性能监控
6. 分布式追踪
7. 异常处理

# 2.1 Spring AOP使用详解
1. xml配置
2. 注解方式(推荐)

## 主要注解
AspectJ注解
- @Aspect
- @Pointcut
- @Advice

# 切面表达式
expression
- designators(指示器)
    - execution()
    - ....
- wildcards(通配符)
    - "*" ： 匹配任意数量的字符
    - ".." ：一般用于匹配任意数的子包或参数
    - "+" ：匹配指定类及其子类
- operators(运算符)
    - &&
    - ||
    - !

designators
- 匹配方法
    - execution()*
- 匹配注解
    - @target()
    - @args()
    - @within()
    - @annotation()
- 匹配包/类型
    - within()
- 匹配对象
    - this()
    - bean()
    - target()
- 匹配参数
    - args()

### 匹配包/类型 

```java
//匹配ProductService类里所有的方法
@Poincut("within(com.sun.service.ProductService)")
public void matchType(){}

//匹配com.sun包以及子包下所有类的方法
@Poincut("within(com.sun..*)")
public void matchPackage(){}

```

### 匹配对象

```java
//匹配AOP对象的目标对象为指定类型的方法
@Poincut("this(com.sun.DemoDao)")
public void thisDemo(){}

//匹配实现IDao接口的目标对象(而不是aop代理后的对象)的方法
@Poincut("target(com.sun.IDao)")
public void targetDemo(){}

//匹配所有以Service结尾的bean里头的方法
@Poincut("bean(*Service)")
public void beanDemo(){}
```

### 匹配参数
```java
//匹配任何以find开头而且只有一个Long参数的方法
@Poincut("execution(**..find*(Long))")
public void argsDemo1(){}

//匹配任何只有一个Long参数的方法
@Poincut("args(Long)")
public void argsDemo2(){}

//匹配任何以find开头的而且第一个参数为Long型的方法  
@Poincut("execution(**..find*(Long,..))")
public void argsDemo3(){}

//匹配第一参数为Long型的方法
@Poincuut("args(Long,..)")
public void argsDemo4(){}

``` 

### 匹配注解
```java
//匹配方法标注有AdminOnly的注解的方法
@Poincut("@annotation(com.sun.demo.security.AdminOnly)")
public void annoDemo(){}

//匹配标注有Beta的类底下的方法，需要的annotation的RetentionPolicy级别为CLASS
@Poincut("@within(com.google.common.annotations.Beta)")
public void annoTargetDemo(){}

//匹配传入的参数类标注有Repository的类地下的方法，要求的annotation的RetentionPolicy级别为RUNTIME
@Poincut("target(org.springframework.sterotype.Repository)")
public void annoTargetDemo(){}

//匹配传入的参数类标注有Repository注解的方法
@Poincut("args(org.springframework.stereotype.Repository)")
public void annoArgsDemo(){}
```

### execution表达式
#### 格式
```java
execution(
    modifier-pattern?
    ret-type-pattern
    declearin-type-pattern?
    name-pattern(param-pattern)
    throws-pattern?
)
```
"?" 表示可以省略

## 5种Advice注解
1. @Before,前置通知
2. @After(finally),后置通知，方法执行完之后
3. @AfterReturning,返回通知，成功执行之后
4. @AfterThrowing，异常通知，抛出异常之后
5. @Around，环绕通知

### Advice中的参数及结果绑定
```java
@Before(value="annoTargeVsWithinDemo() && within(com.sun..*) && args(userId)")
public void void beforeWithArgs(JoinPoint joinPoint,Long userId){
    System.out.println("before,args:"+userId);
}

@AfterReturning(value="annoTargetVsWithinDemo()&&within(com.sun..*)",returniing = "returnValue")
public void getReulst(Object return Value){
    if(returnValue != null){
        System.out.println("after return ,result:"+returnValue);
    }
}

```

# Spring Aop 实现原理
## 概述
### 织入的时机
1. 编译期(AspectJ)
2. 类加载时(AspectJ 5+)
3. 运行时(Spring AOP)

### 运行时织入
- 实现方式
- 从静态代理到动态代理
- 基于接口代理与基于继承代理

### 代理模式



## 设计

### 代理模式

### 责任链模式

## 实现

### JDK实现

### Cglib实现
