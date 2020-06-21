package com.lk.leecode.code.test;

public class TestByte {


    public static void main(String[] args) {

        Byte b = new Byte((byte) 1);
        byte bb = 1;
        System.out.println(b == bb);
        System.out.println(b == 1);
        System.out.println(bb == 1);
        System.out.println(b.equals(1));
    }
}
