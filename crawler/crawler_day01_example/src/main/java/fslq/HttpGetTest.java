package fslq;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

/*HttpGet测试*/
public class HttpGetTest {
   // @Test//https://www.tsinghua.edu.cn
    public void testGet() throws IOException {
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
        //5.关闭Response
        response.close();
        httpClient.close();
    }
    @Test//https://gkcx.eol.cn/choose/school/code?province=北京
    public void testGetKey() throws Exception {
        //1.打开浏览器
        CloseableHttpClient httpClient=HttpClients.createDefault();
        //2.输入网址带参数
        //创建URIBuilder
        URIBuilder uriBuilder=new URIBuilder( "http://gkcx.eol.cn/choose/school/code" );
        //设置参数
        uriBuilder.setParameter( "province" ,"北京").setParameter( "province","安徽" );
        HttpGet httpGet=new HttpGet( uriBuilder.build() );
        System.out.println(httpGet);
        //3.发送请求
        CloseableHttpResponse response=null;
        try{
            response=httpClient.execute( httpGet );
        //4.解析响应，获取数据
        //判断状态码是否为200
        if(response.getStatusLine().getStatusCode()==200){
            HttpEntity httpEntity=response.getEntity();
            String content=EntityUtils.toString( httpEntity,"utf8" );
            System.out.println( content );
        }
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            //5.关闭Response
            response.close();
            httpClient.close();
        }
    }
}
