package com.fslqup.day06.Buffer;

import java.io.*;

/*
* void newline()写入一个行分割符
* void readline()读一行
* */
public class WriterAndReader {
    public static void main(String[] args) {
        String path="C:\\Users\\22966\\Pictures\\e.txt";
        String[] content={"   静夜思","    李白","床前明月光","疑是地上霜","举头望明月","低头思故乡"};
        input(path,content);
        output(path);
    }

    private static void output(String path) {
        try(
                BufferedReader br=new BufferedReader(new FileReader(path));
        ){
          for (int i=0;i<6;i++)
              System.out.println(br.readLine());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    private static void input(String path,String[] content) {
        try(
                BufferedWriter bw=new BufferedWriter(new FileWriter(path));
        ){
            for (int i=0; i < content.length; i++) {
                bw.write(content[i]);
                bw.newLine();//分行
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
