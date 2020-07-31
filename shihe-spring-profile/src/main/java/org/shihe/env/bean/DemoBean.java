package org.shihe.env.bean;

/**
 * @ClassName DemoBean
 * @Description TODO
 * @Author admin
 * @Date 2020-07-31 8:38
 * @Version 1.0
 */
public class DemoBean {
    private String beanName;

    public DemoBean(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
