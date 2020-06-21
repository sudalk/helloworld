package com.lk.leecode.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 括号生成
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "  ((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 */
public class Leecode29 {


    /**
     * 关键字：回溯  递归
     * 思路：
     *      递归的出口：结果长度为2*n
     *      递归体：
     *              需要按条件进行走势
     *         先放左 再放右
     *         如果左括号<n，可以放左括号
     *         如果右括号<左括号，也可以放右括号
     *         终止条件：
     *             字符串长度=2*n
     *
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        gennerateKH(res, "", 0,0,n);
        return res;
    }

    public void gennerateKH(List<String> res, String cur, int open, int close, int n){
        if(cur.length() == 2*n){
            res.add(cur);
        }
        if(open<n){
            gennerateKH(res, cur+"(", open+1, close, n);
        }
        if(close<open){
            gennerateKH(res, cur+")", open, close+1, n);
        }
    }
}
