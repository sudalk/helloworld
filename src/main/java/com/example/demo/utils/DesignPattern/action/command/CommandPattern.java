package com.example.demo.utils.DesignPattern.action.command;

/**
 * @Author: likang
 * @Date: 2021/2/14 17:53
 */
public class CommandPattern {

    /*
    命令模式：
    定义：将一个请求封装为一个对象，使发出请求的责任和执行请求的责任分割开。
    优点：
           通过引入中间件（抽象接口）降低系统的耦合度
           方便实现 Undo 和 Redo 操作
           可以在现有命令的基础上，增加额外功能。比如日志记录，结合装饰器模式会更加灵活
    可能产生大量具体的命令类

    思路：
        receiver 注入到 command
        command 接口类注入到 Invoke 里面（Invoke不需动，可以增加command）
        command 注入到 client （或则我这边维护一个枚举类），调用 invoke ,传入对应的指定的 command 类

    应用场景：
        点菜软件

     */
    public static void main(String[] args) {
        Command cmd = new ConcreteCommand();
        Invoker ir = new Invoker(cmd);
        System.out.println("客户访问调用者的call()方法...");
        ir.call();
    }
}
//调用者
class Invoker {
    private Command command;
    public Invoker(Command command) {
        this.command = command;
    }
    public void setCommand(Command command) {
        this.command = command;
    }
    public void call() {
        System.out.println("调用者执行命令command...");
        command.execute();
    }
}
//抽象命令
interface Command {
    public abstract void execute();
}
//具体命令
class ConcreteCommand implements Command {
    private Receiver receiver;
    ConcreteCommand() {
        receiver = new Receiver();
    }
    public void execute() {
        receiver.action();
    }
}
//接收者
class Receiver {
    public void action() {
        System.out.println("接收者的action()方法被调用...");
    }
}
