package com.lk.jianzhi.offer;

/**
 * @Author: likang
 * @Date: 2020/5/3 18:05
 */
public class Macher {

    private int sl;
    private int pl;
    private boolean matched = false;

    public boolean match(char[] str, char[] pattern){
            if(str == null || pattern == null) return false;
            sl = str.length;
            pl = pattern.length;
            rmatch(0,0, str, pattern);
            return matched;
    }

    private void rmatch(int si, int pi, char[] ss, char[] pp){
        //递归的出口就是已匹配或则规则到头了，字符串也到头了
        if(matched) return;
        if(pl == pi){
            if (sl==si)
                matched = true;
            return;
        }
        //判断正则表达式的下一个是不是*
        if((pi+1)<pl && pp[pi+1] == '*'){
            if((si<sl&&ss[si]==pp[pi]) || (si<sl&&pp[pi]=='.')){
                //可以匹配0个结束，1个结束，匹配1个继续匹配
                rmatch(si,pi+2,ss,pp);
                rmatch(si+1,pi+2,ss,pp);
                rmatch(si+1,pi,ss,pp);
            }else{
                //只能当前匹配0个
                rmatch(si,pi+2,ss,pp);
            }

        }else{//就直接匹配就行了
            if((si<sl&&ss[si]==pp[pi]) || (si<sl&&pp[pi]=='.')){
                rmatch(si+1,pi+1,ss,pp);
            }
        }
    }
}
