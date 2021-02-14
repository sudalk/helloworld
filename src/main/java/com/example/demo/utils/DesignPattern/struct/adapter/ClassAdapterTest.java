package com.example.demo.utils.DesignPattern.struct.adapter;

/**
 * @Author: likang
 * @Date: 2021/2/13 17:37
 */

//目标接口
interface Target
{
    public void request();
}
//适配者接口
class Adaptee
{
    public void specificRequest()
    {
        System.out.println("适配者中的业务代码被调用！");
    }
}
//类适配器类
class ClassAdapter extends Adaptee implements Target
{
    public void request()
    {
        specificRequest();
    }
}

public class ClassAdapterTest {
}
