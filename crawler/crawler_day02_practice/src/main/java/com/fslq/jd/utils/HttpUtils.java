package com.fslq.jd.utils;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.*;
import java.util.UUID;

//封装HttpClient
@Component
public class HttpUtils {
    private PoolingHttpClientConnectionManager connectionManager;//连接池

    public HttpUtils() {
        //创建连接池管理器
        this.connectionManager=new PoolingHttpClientConnectionManager(  );
        //配置连接池
        //设置最大连接数
        this.connectionManager.setMaxTotal( 100 );
        //设置每个主机的最大连接数
        this.connectionManager.setDefaultMaxPerRoute( 10 );
    }

    //使用地址下载页面
    public String doGetHtml(String url){
        //获取Http对象
        CloseableHttpClient httpClient=HttpClients.custom().setConnectionManager( connectionManager ).build();
        //创建get请求
        HttpGet httpGet=new HttpGet( url );
        //设置请求信息
        httpGet.setConfig( this.getConfig() );
        CloseableHttpResponse response=null;
        //解析响应，返回数据
        try{
            //使用HttpClient发送请求，获取响应
            response=httpClient.execute( httpGet );
            //解析响应。返回结果
            if(response.getStatusLine().getStatusCode()==200){
                //判断响应体Entity是否为空，如果不为空则使用EntityUtils
                if(response.getEntity()!=null){
                    String content=EntityUtils.toString( response.getEntity(),"utf8" );
                    return content;
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        finally {
            if(response!=null){
                try{
                    response.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        return null;//返回空
    }
    /**
     * 下载图片
     * @param url
     * @return
     */
    public String doGetImage(String url)  {
        //获取Http对象
        CloseableHttpClient httpClient=HttpClients.custom().setConnectionManager( connectionManager ).build();
        //创建get请求
        HttpGet httpGet=new HttpGet( url );
        //设置请求信息
        httpGet.setConfig( this.getConfig() );
        CloseableHttpResponse response=null;
        //解析响应，返回数据
        try{
            //使用HttpClient发送请求，获取响应
            response=httpClient.execute( httpGet );
            //解析响应。返回结果
            if(response.getStatusLine().getStatusCode()==200){
                //判断响应体Entity是否为空，如果不为空则使用EntityUtils
                if(response.getEntity()!=null){
                    //下载图片
                    //获取图片后缀
                    String extName=url.substring( url.lastIndexOf( "." ) );
                    //创建图片名，重命名
                    String picName=UUID.randomUUID().toString()+extName;
                    //返回图片名称
                    //声明OutPutStream:文件保存路径
                    OutputStream fileOutputStream=new FileOutputStream( new File( "D:\\WorkSpace\\Idea\\crawler\\crawler_day02_practice\\src\\main\\resources\\images\\"+picName ) );
                    response.getEntity().writeTo(fileOutputStream  );
                    //返回图片
                    return picName;
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        finally {
            if(response!=null){
                try{
                    response.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        return null;//返回空
    }
    private RequestConfig getConfig() {
        RequestConfig config=RequestConfig.custom().setConnectTimeout( 1000 )
                .setConnectionRequestTimeout( 500 )
                .setSocketTimeout( 10000 )
                .build();
        return config;
    }
}
