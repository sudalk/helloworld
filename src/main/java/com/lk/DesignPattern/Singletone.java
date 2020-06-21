package com.lk.DesignPattern;

//单例模式的核心是构造方法的私有化（即在入口处限制了对象的实例化）
public class Singletone {
    public static void main(String[] args) {
        LanHan.getInstance();
        Ehan.getInstance();
        DoubleCheck.getInstance();
    }

    private Singletone(){}

    private static class SingletoneClass {
        private static final Singletone s = new Singletone();
    }
    public static Singletone getInstance(){
        return SingletoneClass.s;
    }
}

//懒汉模式
/**
 * 线程安全与线程不安全多一个关键字
 * synchronized
 */
class LanHan{
    //设计成全局模式
    private static LanHan singleton;
    private LanHan(){}
    //获取对象实例的公共入口类方法
    public static LanHan getInstance(){
        if(singleton == null) {
            singleton = new LanHan();
        }
        System.out.println("懒汉");
        return singleton;
    }
}

//饿汉模式
/**
 *默认线程安全，因为在类加载 准备阶段（编译阶段）就生成了，不引起线程安全的问题，但是容易造成空间的浪费
 */
class Ehan{
    private static Ehan singleton = new Ehan();
    private Ehan(){}
    public static Ehan getInstance(){
        System.out.println("饿狼安");
        return singleton;
    }
}

//经典的双重校验
/**
 *
 */
class   DoubleCheck {
    //所有线程即可显现
    private volatile static DoubleCheck singleton;

    private DoubleCheck() {
    }

    //这边还牵扯到一个类似spring初始化的问题
    public static DoubleCheck getInstance() {
        if (singleton == null) {
            synchronized (DoubleCheck.class) {
                if (singleton == null) {
                    singleton = new DoubleCheck();
                    System.out.println("屌丝");
                }
            }
        }
        return singleton;
    }
}

