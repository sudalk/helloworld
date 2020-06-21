package com.lk.leecode.code;

/**
 * @Author: likang
 * @Date: 2020/4/6 21:40
 */
public class Leecode54 {

    /*
    '.' 匹配任意单个字符
    '*' 匹配零个或多个前面的那一个元素
    思路：
    如果存在并且，规则下一个*
        如果当前直接匹配或任意字符.
            略过，进行下下个规则匹配
            继续匹配下个字符
            匹配结束，继续匹配下个字符和下下个规则
        否则
            略过当前，进行下下个规则
    否则
        如果当前直接匹配或任意字符.
            进行下一个字符和规则的匹配
     */
    private int sl;
    private int pl;
    private boolean matched = false;

    public boolean isMatch(String s, String p) {
        if(s==null || p==null) return false;
        sl = s.length();
        pl = p.length();
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        rmatch(0,0,ss,pp);
        return matched;
    }

    private void rmatch(int si, int pi, char[] ss, char[] pp){
        //如果为true 直接退出
        if(matched) return;
        if(pl == pi){
            if(si == sl)
                matched = true;
            return;
        }

        if((pi+1)<pl && pp[pi+1] == '*'){//模式的第2个是*,分两种情况：第一个能/不能匹配上
            if((si<sl&&pp[pi] == ss[si]) || (si<sl&&pp[pi] == '.')){
                rmatch(si,pi+2,ss,pp);//略过 a * 直接匹配0个
                rmatch(si+1,pi,ss,pp);//匹配下一个
                rmatch(si+1,pi+2,ss,pp);//匹配结束
            }else{
                //略过 a * 直接匹配0个
                rmatch(si,pi+2,ss,pp);
            }
        }else{//模式的第二个不是*，匹配上就下一个，匹配不上就结束
            if((si<sl&&pp[pi] == ss[si]) || (si<sl&&pp[pi] == '.')){
                rmatch(si+1,pi+1,ss,pp);
            }
        }
    }
}
