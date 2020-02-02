package com.fslqup.day06.Buffer;

import java.io.*;

public class IOBuffer {
    public static void main(String[] args) {
        String copy="C:\\Users\\22966\\Pictures\\a.jpg";
        String copy_to="C:\\Users\\22966\\Pictures\\b.jpg";
        output(copy_to,input(copy));//注意值传递
    }

    private static void output(String copy_to,byte[] buffer) {
        try(
                FileOutputStream fos=new FileOutputStream(copy_to);
                BufferedOutputStream bos=new BufferedOutputStream(fos);
        ){
            bos.write(buffer);
            bos.close();
            fos.close();
            System.out.println("Outputed");
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    private static byte[] input(String copy) {
        try(
                FileInputStream fis=new FileInputStream(copy);
                BufferedInputStream bis=new BufferedInputStream(fis);
        ){
            byte[] buffer=bis.readAllBytes();
            bis.close();
            fis.close();
            System.out.println("Inputed");
            return buffer;
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        return null;
    }
}
