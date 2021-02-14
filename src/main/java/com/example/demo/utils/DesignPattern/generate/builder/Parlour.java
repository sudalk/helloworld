package com.example.demo.utils.DesignPattern.generate.builder;

/**
 * @Author: likang
 * @Date: 2021/2/13 13:08
 */
public class Parlour {

    private String wall;    //墙
    private String TV;    //电视
    private String sofa;    //沙发

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getTV() {
        return TV;
    }

    public void setTV(String TV) {
        this.TV = TV;
    }

    public String getSofa() {
        return sofa;
    }

    public void setSofa(String sofa) {
        this.sofa = sofa;
    }


    public static void main(String[] args) {
        Decorator decorator = new Decorator();
        Parlour build = decorator.setSofa("1").setTV("2").build();
        System.out.println(build.getSofa()+build.getTV()+build.getWall());
    }
}

class Decorator {
    protected Parlour product = new Parlour();

    private String wall;    //墙
    private String TV;    //电视
    private String sofa;    //沙发

    public String getWall() {
        return wall;
    }

    public Decorator setWall(String wall) {
        this.wall = wall;
        return this;
    }

    public String getTV() {
        return TV;
    }

    public Decorator setTV(String TV) {
        this.TV = TV;
        return this;
    }

    public String getSofa() {
        return sofa;
    }

    public Decorator setSofa(String sofa) {
        this.sofa = sofa;
        return this;
    }

    public Parlour build(){
        product.setSofa(this.getSofa());
        product.setTV(this.getTV());
        product.setWall(this.getWall());
        return product;
    }
}
