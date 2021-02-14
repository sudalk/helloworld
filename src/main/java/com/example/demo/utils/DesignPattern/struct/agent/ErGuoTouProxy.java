package com.example.demo.utils.DesignPattern.struct.agent;

/**
 * @Author: likang
 * @Date: 2021/2/13 13:52
 */
public class ErGuoTouProxy  implements ErGuoTou{

    private ErGuoTou erGuoTou;

    public ErGuoTouProxy() {
    }

    public ErGuoTouProxy(ErGuoTou erGuoTou) {
        this.erGuoTou = erGuoTou;
    }

    @Override
    public void show() {
        System.out.println("北京代理商");
        erGuoTou.show();
    }

    public ErGuoTouProxy getHonXingProxy(){
        ErGuoTouProxy erGuoTouProxy = new ErGuoTouProxy(new HongxingErGuoTou());
        return erGuoTouProxy;
    }

    public ErGuoTouProxy getNiuProxy(){
        ErGuoTouProxy erGuoTouProxy = new ErGuoTouProxy(new NiuErGuoTou());
        return erGuoTouProxy;
    }

    public static void main(String[] args) {
            new ErGuoTouProxy().getHonXingProxy().show();
            new ErGuoTouProxy().getNiuProxy().show();
    }
}
