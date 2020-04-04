package com.fslq.dao;

import com.fslq.domain.Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/*持久层接口*/
@Repository//注入容器中
public interface AccountDao {
    //查询所有
    @Select( "select * from account" )
    List<Account> findAll();
    //添加一个
    @Insert( "insert into account(name,money) value(#{name},#{money})" )
    void save(Account account);

}
