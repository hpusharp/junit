package com.kaishengit.uitils;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by shibo on 2016/12/6.
 */
public class HttpUtil {

    public static String sendHttpGetWithString(String url) {
        //获取一个客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //请求方式
        HttpGet httpGet = new HttpGet(url);

        try {
            //发送请求,并获取返回的响应
            HttpResponse response = httpClient.execute(httpGet);
            InputStream inputStream = null;

            if (response.getStatusLine().getStatusCode() == 200) {
                //把响应的值放入输入流中
                inputStream = response.getEntity().getContent();
                String result = IOUtils.toString(inputStream,"UTF-8");
                httpClient.close();
                return  result;

            }else  {
                throw new RuntimeException("请求"+url + "异常"+response.getStatusLine().getStatusCode() );
            }

        }catch (IOException ex) {
            throw  new RuntimeException("请求"+ url + "异常",ex);
        }

    }
}
