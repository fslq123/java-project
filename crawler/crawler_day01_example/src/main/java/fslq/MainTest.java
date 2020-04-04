package fslq;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

//抓取网站首页
public class MainTest {
    public static void main(String[] args) throws IOException {
        //1.打开浏览器
        CloseableHttpClient httpClient=HttpClients.createDefault();
        //2.输入网址
        HttpGet httpGet=new HttpGet( "https://www.tsinghua.edu.cn" );
        //3.发送请求
        CloseableHttpResponse response=httpClient.execute( httpGet );
        //4.解析响应，获取数据
        //判断状态码是否为200
        if(response.getStatusLine().getStatusCode()==200){
            HttpEntity httpEntity=response.getEntity();
            String content=EntityUtils.toString( httpEntity,"utf8" );
            System.out.println( content );
        }
    }
}
