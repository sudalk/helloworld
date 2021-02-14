package com.example.demo.utils.DesignPattern.action.chain;

/**
 * @Author: likang
 * @Date: 2021/2/14 18:23
 */
public class ChainOfResponsibilityPattern {

    /*
    只有处理类：handler ，类似组合模式。
一个事件需要经过多个对象处理是很常见的场景。例如，采购审批流程、请假流程等
为了避免请求发送者与多个请求处理者耦合在一起


降低了对象之间的耦合度
增强了系统的可扩展性
责任链简化了对象之间的连接

不能保证每个请求一定被处理
对比较长的职责链
职责链建立的合理性要靠客户端来保证，增加了客户端的复杂性

handler注入client， 从头开始调用即可

怎么串联起来呢？
在初始化的时候，启动类直接串联


     */



    public static void main(String[] args) {
        //组装责任链
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        handler1.setNext(handler2);
        //提交请求
        handler1.handleRequest("two");
    }
}
//抽象处理者角色
abstract class Handler {
    private Handler next;
    public void setNext(Handler next) {
        this.next = next;
    }
    public Handler getNext() {
        return next;
    }
    //处理请求的方法
    public abstract void handleRequest(String request);
}
//具体处理者角色1
class ConcreteHandler1 extends Handler {
    public void handleRequest(String request) {
        if (request.equals("one")) {
            System.out.println("具体处理者1负责处理该请求！");
        } else {
            if (getNext() != null) {
                getNext().handleRequest(request);
            } else {
                System.out.println("没有人处理该请求！");
            }
        }
    }
}
//具体处理者角色2
class ConcreteHandler2 extends Handler {
    public void handleRequest(String request) {
        if (request.equals("two")) {
            System.out.println("具体处理者2负责处理该请求！");
        } else {
            if (getNext() != null) {
                getNext().handleRequest(request);
            } else {
                System.out.println("没有人处理该请求！");
            }
        }
    }
}
