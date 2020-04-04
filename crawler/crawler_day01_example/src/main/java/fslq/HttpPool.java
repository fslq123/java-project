package fslq;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

/*连接池操作*/
public class HttpPool {

    @Test
    public void testPool(){
        //创建连接池管理器
        PoolingHttpClientConnectionManager connectionManager=new PoolingHttpClientConnectionManager();
        //设置连接数
        connectionManager.setMaxTotal( 100 );
        //设置每个主机的最大连接数
        connectionManager.setDefaultMaxPerRoute( 10 );
        //使用连接池管理器
        doGet(connectionManager);
        doGet(connectionManager);

    }

    private void doGet(PoolingHttpClientConnectionManager connectionManager) {
        //1.打开浏览器
        CloseableHttpClient httpClient=HttpClients.custom().setConnectionManager( connectionManager ).build();
        //2.输入网址
        HttpGet httpGet=new HttpGet( "https://www.tsinghua.edu.cn" );
        //3.发送请求
        CloseableHttpResponse response=null;
        try{
            response=httpClient.execute( httpGet );
        }catch(IOException e){
            e.printStackTrace();
        }
        //4.解析响应，获取数据
        //判断状态码是否为200
        if(response.getStatusLine().getStatusCode()==200){
            HttpEntity httpEntity=response.getEntity();
            String content=null;
            try{
                content=EntityUtils.toString( httpEntity,"utf8" );
            }catch(IOException e){
                e.printStackTrace();
            }
            System.out.println("长度："+ content.length() );
        }
        //5.关闭Response
        try{
            response.close();
            //httpClient.close();不能手动管理
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
