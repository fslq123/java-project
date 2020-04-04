package fslq;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

/*请求参数*/
public class HttpRequestConfing {
    @Test
    public void requestTime() throws URISyntaxException, IOException {
        //1.打开浏览器
        CloseableHttpClient httpClient=HttpClients.createDefault();
        //2.输入网址带参数
        //创建URIBuilder
        URIBuilder uriBuilder=new URIBuilder( "http://gkcx.eol.cn/choose/school/code" );
        //设置请求参数
        RequestConfig config=RequestConfig.custom().setConnectTimeout( 1000 )//创建链接最长时间1000ms
        .setConnectionRequestTimeout( 1000 )//创建获取连接的最长时间
        .setSocketTimeout( 10*1000 )//设置传输最长时间
        .build();

        //设置参数
        uriBuilder.setParameter( "province" ,"北京").setParameter( "province","安徽" );
        HttpGet httpGet=new HttpGet( uriBuilder.build() );
        httpGet.setConfig( config );
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
