package com.lk.leecode.code;

import java.util.Stack;

/**
 * 有效的括号
 */
public class Leecode19 {

    /**
     * 利用栈
     */
    public boolean isValid(String s) {
        Stack<Character> stack  = new Stack<>();
        if(s.length()==0){
            return true;
        }
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(' || c== '['|| c=='{'){
                stack.push(c);
            }else{
                if(stack.empty()) return false;
                Character pop = stack.pop();
                if(c==')'){
                    if(pop!='('){
                        return false;
                    }
                }
                if(c==']'){
                    if(pop!='['){
                        return false;
                    }
                }
                if(c=='}'){
                    if(pop!='{'){
                        return false;
                    }
                }
            }
        }
        if(stack.empty()){
            return true;
        }else{
            return false;
        }
    }
}
