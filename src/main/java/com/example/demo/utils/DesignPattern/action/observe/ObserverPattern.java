package com.example.demo.utils.DesignPattern.action.observe;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: likang
 * @Date: 2021/2/14 20:30
 */
public class ObserverPattern {
    /*
    没有指定目的一群

    降低了目标与观察者之间的耦合关系，两者之间是抽象耦合关系。符合依赖倒置原则。
目标与观察者之间建立了一套触发机制。

   目标与观察者之间的依赖关系并没有完全解除，而且有可能出现循环引用。
当观察者对象很多时，异步通知的发布会花费很多时间，影响程序的效率。

     */
    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        Observer obs1 = new ConcreteObserver1();
        Observer obs2 = new ConcreteObserver2();
        subject.add(obs1);
        subject.add(obs2);
        subject.notifyObserver();
    }
}
//抽象目标
abstract class Subject {
    protected List<Observer> observers = new ArrayList<Observer>();
    //增加观察者方法
    public void add(Observer observer) {
        observers.add(observer);
    }
    //删除观察者方法
    public void remove(Observer observer) {
        observers.remove(observer);
    }
    public abstract void notifyObserver(); //通知观察者方法
}
//具体目标
class ConcreteSubject extends Subject {
    public void notifyObserver() {
        System.out.println("具体目标发生改变...");
        System.out.println("--------------");
        for (Object obs : observers) {
            ((Observer) obs).response();
        }
    }
}
//抽象观察者
interface Observer {
    void response(); //反应
}
//具体观察者1
class ConcreteObserver1 implements Observer {
    public void response() {
        System.out.println("具体观察者1作出反应！");
    }
}
//具体观察者1
class ConcreteObserver2 implements Observer {
    public void response() {
        System.out.println("具体观察者2作出反应！");
    }
}
