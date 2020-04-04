package com.fslq.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;

import java.util.UUID;

/*
* 文件上传控制器
* */
@Controller
@RequestMapping("upload")
public class UploadFilesController {
    /*
    *跨服务器
     * SpringMVC方式上传
     * */
    @RequestMapping("mvcFile")
    public String mvcFile(MultipartFile upload){//与前端命名一致
        //使用fileupload组件完成文件上传
        //1.上传位置
        String path="http://localhost:9090/uploads/" ;
        //2.判断路径是否存在
        File file=new File( path );
        if(!file.exists()){
            //创建该文件夹
            file.mkdir();
        }
        //4.解析request对象
        //6.上传非普通表单项（文件）
        //7.获取上传文件名称
        String filename=upload.getOriginalFilename();
        //8.完成上传文件
        //重命名
        String uid=UUID.randomUUID().toString().replace( "-","" );
        filename=uid+"+"+filename;
        /*实现跨服务器上传*/
        //1.创建客户端对象
        Client client=Client.create();
        //2.与服务器连接
        WebResource webResource=client.resource( path+filename );
        //3.上传文件
        try{
            webResource.put(upload.getBytes());
        }catch(IOException e){
            e.printStackTrace();
            return "error";
        }
        return "success";
    }
}
