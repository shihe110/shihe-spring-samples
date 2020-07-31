package org.shihe.os;

/**
 * @ClassName LinuxListService
 * @Description TODO
 * @Author admin
 * @Date 2020-07-31 15:09
 * @Version 1.0
 */
public class LinuxListService implements ListService{
    public String showListCmd() {
        return "ls";
    }
}
