package org.shihe;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName DemoTest
 * @Description TODO
 * @Author admin
 * @Date 2020-07-31 16:51
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DemoCofig.class)
@ActiveProfiles("pro")
public class DemoTest {

    @Autowired
    private DemoBean demoBean;

    @Test
    public void test(){
        String ex = "pro";
        String name = demoBean.getName();
        Assert.assertEquals(ex,name);
    }
}
