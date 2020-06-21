package com.example.demo.utils.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.StandardHttpRequestRetryHandler;
import org.apache.http.util.EntityUtils;

/**
 * @Author: likang
 * @Date: 2020/6/14 9:54
 */
public class ApacheHttpClient {

    private static HttpClient httpClient;

    static{
        httpClient = HttpClients.custom()
                .setRetryHandler(new StandardHttpRequestRetryHandler())
                .build();
    }

    public static void doGet(String url){
        HttpGet httpGet = new HttpGet(url);
        // 执行get请求得到返回对象
        try {
            HttpResponse response = httpClient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();

            if(statusCode == HttpStatus.SC_OK){
                HttpEntity entity = response.getEntity();
//                System.out.println(EntityUtils.toString(entity));
                System.out.println(EntityUtils.toString(entity));
                if (entity!=null){
                    System.out.println("12133");
                }else{
                    System.out.println("null");
                }

            }else{
                System.out.println(statusCode+" error");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void doPost(String url){
        try {
            URIBuilder builder = new URIBuilder(url);

//            Map<String, String> map = new HashMap<>();
//            map.put("username","likang");
//            map.put("age","18");
//            map.forEach(builder::setParameter);
            HttpResponse response = httpClient.execute(new HttpPost(builder.build()));
            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode == HttpStatus.SC_OK){
                HttpEntity entity = response.getEntity();
//                System.out.println(EntityUtils.toString(entity));
                System.out.println(EntityUtils.toString(entity));
                if (entity!=null){
                    System.out.println("12133");
                }else{
                    System.out.println("null");
                }

            }else{
                System.out.println(statusCode+" error");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //doGet("http://127.0.0.1:8080/hello1");
//        doPost("http://127.0.0.1:8080/hello");
        doPost("http://127.0.0.1:8080/hello?username=lk&age=26");

    }

}
