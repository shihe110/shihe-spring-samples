package com.shihe;

import com.alibaba.fastjson.JSONObject;
import com.shihe.dao.UserDao;
import com.shihe.dao.UserMapper;
import com.shihe.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = factory.openSession();
        // selectUsers
        /*UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectUser();
        System.out.println(users);*/
        // selectUserById

        UserDao mapper = sqlSession.getMapper(UserDao.class);
        /*User user = mapper.selectUserById(1);
        System.out.println(user);*/

        // selectUserByNP
        /*List<User> users = mapper.selectUserByNP("狂神", "123456");
        System.out.println(users);*/

        // selectUserByNP2
       /* Map map = new HashMap();
        map.put("username","狂神");
        map.put("pwd","123456");
        List<User> users = mapper.selectUserByNP2(map);
        System.out.println(users);*/
       // selectUserByNP3
        /*List<User> users = mapper.selectUserByNP3("狂神", "123456");
        System.out.println(users);*/
        // java bean
        /*User user = new User();
        user.setName("狂神");
        user.setPwd("123456");
        List<User> users = mapper.selectUserByNP4(user);
        System.out.println(users);*/
        // JSON
       /* Map map = new HashMap();
        map.put("username","狂神");
        map.put("pwd","123456");
        JSONObject jsonObject = new JSONObject(map);
        List<User> users = mapper.selectUserByNP5(jsonObject);
        System.out.println(users);*/
       // 传递集合类型参数
        /*List list = new ArrayList();
        list.add("张三");
        list.add("李四");*/


        /*String[] name = {"张三","李四"};
        List<User> users = mapper.selectUserByList1(name);
        System.out.println(users);*/
        Logger logger = Logger.getLogger(Main.class);
        // 添加user
        User user = new User();
        user.setPwd("123456");
        user.setName("王五");
        user.setId(1);
logger.info("gekk");
        int i = mapper.updateUser(user);
        System.out.println(i);
        sqlSession.close();
    }
}
