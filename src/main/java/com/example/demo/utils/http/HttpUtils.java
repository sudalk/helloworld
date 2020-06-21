package com.example.demo.utils.http;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author: likang
 * @Date: 2020/6/14 9:44
 */
public class HttpUtils {

    //java access http
    public static void doGet(String httpurl){
        HttpURLConnection connection = null;
        InputStream is = null;
        //创建远程连接
        try {
            URL url = new URL(httpurl);
            connection = (HttpURLConnection) url.openConnection();
            // 设置连接方式：get
            connection.setRequestMethod("GET");
            // 设置连接主机服务器的超时时间：15000毫秒
            connection.setConnectTimeout(15000);
            // 设置读取远程返回的数据时间：60000毫秒
            connection.setReadTimeout(60000);
            // 发送请求
            connection.connect();

            if(connection.getResponseCode() == 200){
                //获取输入流
                is = connection.getInputStream();
                BufferedInputStream bis = new BufferedInputStream(is);
                byte[] data = new byte[1024];
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                int count = 0;
                while((count = bis.read(data))!=-1){
                    bos.write(data, 0, count);
                }
                byte[] strByte = bos.toByteArray();
                String responseString = new String(strByte, 0, strByte.length, "utf-8");
                bos.close();
                bis.close();
                System.out.println("responseString:"+responseString);
            }else{
                System.out.println(url+"连接失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void doPost(String httpUrl, String param) {
        HttpURLConnection connection = null;
        InputStream is = null;
        OutputStream os = null;
        //创建远程连接
        try {
            URL url = new URL(httpUrl);

            // 通过远程url连接对象打开连接
            connection = (HttpURLConnection) url.openConnection();
            // 设置连接请求方式
            connection.setRequestMethod("POST");
            // 设置连接主机服务器超时时间：15000毫秒
            connection.setConnectTimeout(15000);
            // 设置读取主机服务器返回数据超时时间：60000毫秒
            connection.setReadTimeout(60000);

            // 默认值为：false，当向远程服务器传送数据/写数据时，需要设置为true
            connection.setDoOutput(true);
            // 默认值为：true，当前向远程服务读取数据时，设置为true，该参数可有可无
            connection.setDoInput(true);

            // 设置传入参数的格式:请求参数应该是 name1=value1&name2=value2 的形式。
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            // 通过连接对象获取一个输出流
            os = connection.getOutputStream();
            // 通过输出流对象将参数写出去/传输出去,它是通过字节数组写出的
            os.write(param.getBytes());
            if(connection.getResponseCode() == 200){
                //获取输入流
                is = connection.getInputStream();
                BufferedInputStream bis = new BufferedInputStream(is);
                byte[] data = new byte[1024];
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                int count = 0;
                while((count = bis.read(data))!=-1){
                    bos.write(data, 0, count);
                }
                byte[] strByte = bos.toByteArray();
                String responseString = new String(strByte, 0, strByte.length, "utf-8");
                bos.close();
                bis.close();
                System.out.println("responseString:"+responseString);
            }else{
                System.out.println(url+"连接失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(is != null) {
                    is.close();
                }
                if(os != null){
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        doGet("http://127.0.0.1:8080/hello1");
        doPost("http://127.0.0.1:8080/hello", "username=lk&age=26");
    }

}
