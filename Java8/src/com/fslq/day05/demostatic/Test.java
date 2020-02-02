package com.fslq.day05.demostatic;

import java.util.ArrayList;
/*static不能访问非static
* 静态方法中不能使用this
* 静态方法可以通过类名称直接调用
* */
public class Test {
    public static void main(String[] args) {
        Student one=new Student("黄蓉");
        one.setRoom("101教室");//<--> Student.setRoom("101教室");
        Student two=new Student("郭靖");
        ArrayList<Student> studentArrayList=new ArrayList<>();
        studentArrayList.add(one);
        studentArrayList.add(two);

        for (Student stu:studentArrayList
             ) {
            System.out.println("学号："+stu.getId()+" 姓名："+stu.getName()+" 教室："+stu.getRoom());
        }

    }
}
