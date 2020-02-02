package com.fslqup.day07.Net.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TcpService {
    public static void main(String[] args) throws IOException {
        //1.创建服务器socket
        ServerSocket serverSocket=new ServerSocket(8880);
        //2.一直监听
        while (true){
            Socket socket=serverSocket.accept();//一直阻塞
            new Thread(()->{//多线程
                try{

                    System.out.println("接收中...");
                    //3.获取socket字节流
                    InputStream inputStream=socket.getInputStream();
                    byte[] bytes=inputStream.readAllBytes();//必须以字节数组存储
                    //4.判断存储路径是否存在
                    System.out.println("上传成功！");
                    if(new File("C:\\Users\\22966\\Pictures").exists()){
                        //5.创建本地字节输出流，保存文件
                        FileOutputStream fi=new FileOutputStream("C:\\Users\\22966\\Pictures\\"+new Random().nextInt(8888)+".jpg");
                        fi.write(bytes);
                        fi.close();
                    }
                    inputStream.close();
                    socket.close();
                }catch(IOException e){
                    System.out.println(e.getMessage());
                }
            }).start();

        }
    }
}
