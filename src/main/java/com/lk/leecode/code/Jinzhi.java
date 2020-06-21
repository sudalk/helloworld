package com.lk.leecode.code;

/**
 * @Author: likang
 * @Date: 2020/5/5 12:26
 */
public class Jinzhi {


    //获取二进制
    public String getBinary(int n){
        StringBuffer stringBuffer = new StringBuffer();
        while(n != 0){
            if((n&1)==1){
                stringBuffer.append('1');
            }else{
                stringBuffer.append('0');
            }
            n = n>>1;
        }
        return stringBuffer.reverse().toString();
    }

    //十六进制
    public String get16(int n){
        if(n == 0){
            return "0";
        }
        StringBuffer stringBuffer = new StringBuffer();
        char[] res = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        while(n!=0 && stringBuffer.length()<8){
            // %16
            stringBuffer.append(res[n & 0xf]);
            // /16
            n = n>>4;
        }
        return stringBuffer.reverse().toString();
    }

    public String convertToBase7(int num) {
        String ans = "";
        if (num < 0) {
            num = 0 - num;
            ans += "-";
        };
        StringBuilder sb = new StringBuilder();
        do {
            int mod = num % 7;
            sb.append((char)('0'+mod));
            num = num / 7;
        } while (num > 0);
        ans += sb.reverse().toString();
        return ans;

    }


    public static void main(String[] args) {
        Jinzhi jinzhi = new Jinzhi();
        System.out.println(jinzhi.getBinary(8));
        System.out.println(jinzhi.get16(32));
    }
}
