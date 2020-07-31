package org.shihe.os;

/**
 * @ClassName WindowsListService
 * @Description TODO
 * @Author admin
 * @Date 2020-07-31 15:08
 * @Version 1.0
 */
public class WindowsListService implements ListService{
    public String showListCmd() {
        return "dir";
    }
}
