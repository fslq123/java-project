package com.fslq.dao;

import com.fslq.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/*
* 开启二级缓存
* */
@CacheNamespace(blocking=true)
public interface UserDao {
    /*
    * 查询所有
    * @return
    * */

    @Select("select * from user;")//注意在<mappers>中不应该存在xml
    @Results(id="useeMap",value={
            @Result(id=true,column="id",property="id"),
            @Result(column="birthday",property="birthday"),
            @Result(column="username",property="username"),
            @Result(column="sex",property="sex"),
            @Result(column="address",property="address"),
            @Result(property="accountList",column="id",many=@Many(
                    select="com.fslq.dao.AccountDao.findAccountByUid",fetchType=FetchType.LAZY//延迟加载
            ))
    })
    List<User> findAll();

    @Select("select * from user where id=#{uid};")
    User findById(int uid);
    /*
    * 插入
    * */
    @Insert("insert into user(username,birthday,sex,address)values(#{username},#{birthday},#{sex},#{address});")
    void insertUser(User user);

    /*
    * 删除
    * */
    @Delete("delete from user where username=#{username};")
    void deleteUser(String username);

    /*
    * 修改
    * */
    @Update("update user set username=#{username},birthday=#{birthday},sex=#{sex},address=#{address} where id=#{id};")
    void updateUser(User user);
}
