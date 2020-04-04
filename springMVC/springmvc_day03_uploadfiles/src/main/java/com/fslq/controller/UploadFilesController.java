package com.fslq.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/*
* 文件上传控制器
* */
@Controller
@RequestMapping("upload")
public class UploadFilesController {
    /*
    * 传统方式上传
    * */
    @RequestMapping("tranditionalFile")
    public String tranditionalFile(HttpServletRequest request){
        //使用fileupload组件完成文件上传
        //1.上传位置
        String path=request.getSession().getServletContext().getRealPath( "/uploads/" );
        //2.判断路径是否存在
        File file=new File( path );
        if(!file.exists()){
            //创建该文件夹
            file.mkdir();
        }
        //3.获取上传文件项
        DiskFileItemFactory fileItemFactory=new DiskFileItemFactory(  );
        ServletFileUpload upload=new ServletFileUpload( fileItemFactory );
        //4.解析request对象
        try{
            //5.上传
            List<FileItem> items=upload.parseRequest( request );
            items.stream().filter( item->!item.isFormField() ).forEach( item->{
                //6.上传非普通表单项（文件）
                //7.获取上传文件名称
                String filename=item.getName();
                //8.完成上传文件
                try{
                    //重命名
                    String uid=UUID.randomUUID().toString().replace( "-","" );
                    filename=uid+"+"+filename;
                    item.write( new File( path,filename ) );
                }catch(Exception e){
                    e.printStackTrace();
                }
                //9.删除临时文件
                item.delete();
            } );
        }catch(FileUploadException e){
            e.printStackTrace();
            return "error";
        }
        return "success";
    }
    /*
     * SpringMVC方式上传
     * */
    @RequestMapping("mvcFile")
    public String mvcFile(HttpServletRequest request,MultipartFile upload){//与前端命名一致
        //使用fileupload组件完成文件上传
        //1.上传位置
        String path=request.getSession().getServletContext().getRealPath( "/upload/" );
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
        try{
            upload.transferTo(new File (path,filename));
        }catch(IOException e){
            e.printStackTrace();
            return "error";
        }
        return "success";
    }
}
