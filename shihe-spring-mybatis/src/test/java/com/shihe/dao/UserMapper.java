package com.shihe.dao;

import com.shihe.MybatisUtils;
import com.shihe.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapper {

    @Test
    public void test(){
        SqlSession session = MybatisUtils.getSession();
        List<User> Users = session.selectList("com.shihe.dao.UserMapper.selectUser");
        System.out.println(Users);
    }
}
