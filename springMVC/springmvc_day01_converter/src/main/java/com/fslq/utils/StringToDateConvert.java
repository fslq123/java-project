package com.fslq.utils;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
* 字符串转换成日期
* */
public class StringToDateConvert implements Converter<String,Date>{
    //日期转换方法
    public Date convert(String str){
        if(!str.isEmpty()){
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat( "yyyy-MM-dd" );
            try{
                return simpleDateFormat.parse( str );
            }catch(ParseException e){
                e.printStackTrace();
            }
        }
        return null;
    }
}
