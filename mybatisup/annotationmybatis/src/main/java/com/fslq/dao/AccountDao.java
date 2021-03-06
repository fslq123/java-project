package com.fslq.dao;

import com.fslq.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountDao {
    @Select("select * from account;")
    @Results(id="accountMap",value={
            @Result(id=true,column="id",property="id"),
            @Result(column="uid",property="uid"),
            @Result(column="money",property="money"),
            @Result(property="user",column="uid",one=@One(
                    select="com.fslq.dao.UserDao.findById",fetchType=FetchType.EAGER//立即加载
            ))
    })
    List<Account> findAll();
    /*
    * 根据用户id查找账户*/
    @Select("select * from account where uid=#{uid};")
    List<Account> findAccountByUid(Integer uid);

}
