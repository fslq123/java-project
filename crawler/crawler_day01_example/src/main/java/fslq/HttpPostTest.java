package fslq;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*post请求*/
public class HttpPostTest {
    //@Test//https://www.tsinghua.edu.cn
    public void testPost() throws IOException {
        //1.打开浏览器
        CloseableHttpClient httpClient=HttpClients.createDefault();
        //2.输入网址
        HttpPost httpPost=new HttpPost( "https://www.tsinghua.edu.cn" );
        //3.发送请求
        CloseableHttpResponse response=httpClient.execute( httpPost );
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

    //带表单的Post请求
    @Test//https://gkcx.eol.cn/choose/school/code?province=北京
    public void testPostKey() throws Exception {
        //1.打开浏览器
        CloseableHttpClient httpClient=HttpClients.createDefault();
        //2.输入网址带参数
        HttpPost httpPost=new HttpPost( "http://gkcx.eol.cn/choose/school/code" );
        //声明list集合封装url地址表单
        List<NameValuePair> param=new ArrayList<>(  );
        param.add( new BasicNameValuePair( "provice","北京" ) );
        //创建表单实例对象
        UrlEncodedFormEntity formEntity=new UrlEncodedFormEntity(param,"utf8");
        //设置表单的对象到Post请求中
        httpPost.setEntity( formEntity );
        //3.发送请求
        CloseableHttpResponse response=null;
        try{
            response=httpClient.execute( httpPost );
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
