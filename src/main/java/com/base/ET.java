package com.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: likang
 * @Date: 2020/4/23 13:14
 */
public class ET implements Comparable<ET>{
    private int num;
    private String data;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ET(int num, String data) {
        this.num = num;
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ET)) return false;

        ET et = (ET) o;

        if (getNum() != et.getNum()) return false;
        return getData() != null ? getData().equals(et.getData()) : et.getData() == null;
    }

    @Override
    public int hashCode() {
        int result = getNum();
        result = 31 * result + (getData() != null ? getData().hashCode() : 0);
        return result;
    }


    public static void main(String[] args) {
        ET et = new ET(13,"12");
        ET et1 = new ET(11,"11");
        List<ET> list = new ArrayList<>();
        list.add(et);
        list.add(et1);
        Collections.sort(list, new Comparator<ET>() {
            @Override
            public int compare(ET o1, ET o2) {
                return o2.num-o1.num;
            }
        });
        list.forEach(c-> System.out.println(c.num));


    }


    @Override
    public int compareTo(ET o) {
        return this.num - o.num;
    }


}
