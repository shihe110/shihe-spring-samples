package com.shihe;

import com.shihe.dao.UserMapper;
import com.shihe.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class HelloTest {
    @Test
    public void selectUser() throws IOException {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.selectUser();
        System.out.println(users+"==");
        List<User> Users = session.selectList("com.shihe.dao.UserMapper.selectUser");
        System.out.println(Users);
    }
}
