package com.fslqup.day01.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DemoPractice {
    public static void main(String[] args) throws ParseException {
        Scanner scanner;
        System.out.print ("输入生日【yyyy-MM-dd】：");
        System.out.println ("活了"+calculationDate(new Scanner (System.in))+"天");
    }

    private static int calculationDate(Scanner scanner) throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat ("yyyy-MM-dd");
        Date birthDate=simpleDateFormat.parse (scanner.next());//格式转换
        long i = new Date ().getTime () - birthDate.getTime ();//时间差
        return (int) (i/1000/60/60/24);
    }
}
