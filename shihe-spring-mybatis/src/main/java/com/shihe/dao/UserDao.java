package com.shihe.dao;

import com.alibaba.fastjson.JSONObject;
import com.shihe.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserDao {
    // 获取所有user
    List<User> selectUser();
    // 根据id获取user
    User selectUserById(int id);
    // 注解
    List<User> selectUserByNP(@Param("username") String name,@Param("pwd") String password);
    // map传参
    List<User> selectUserByNP2(Map map);
    // 匿名传参
    List<User> selectUserByNP3(String name,String password);
    // javabean传参
    List<User> selectUserByNP4(User user);
    // JSON传递
    List<User> selectUserByNP5(JSONObject jsonObject);
    // 传递集合类型参数
    List<User> selectUserByList(List list);

    List<User> selectUserByList1(String[] list);
    // 添加user
    int addUser(User user);

    int updateUser(User user);
}
