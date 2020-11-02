package org.shihe.pojo;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName User
 * @Description TODO
 * @Author admin
 * @Date 2020-10-29 15:20
 * @Version 1.0
 */
public class User {

    private String username;
    private int age;
    private boolean sex;

    public User() {
        System.out.println("无参构造");
    }

    public User(String username, int age) {
        this.username = username;
        this.age = age;
        System.out.println("有参构造");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        System.out.println("set username 执行");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        System.out.println("set age 执行");
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
        System.out.println("set sex 执行");
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
