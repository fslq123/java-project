package com.fslqup.day07.Net.upload;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args) throws IOException {
        //1.创建Socket
        Socket socket=new Socket("127.0.0.1",8880);
        if(socket.isConnected()){
            //2.创建网络字节输出流
            OutputStream os=socket.getOutputStream();
            //3.创建输入流,写入数据
            String fileName="a.jpg";
            FileInputStream fileInputStream=new FileInputStream("C:\\Users\\22966\\Pictures\\" + fileName);
            byte[] bytes=fileInputStream.readAllBytes();//必须以字节数组存储
            os.write(bytes);
            System.out.println("上传中...");
            fileInputStream.close();
            os.close();
        }else{
            System.out.println("未连接");
        }
        socket.close();
    }
}
