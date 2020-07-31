package org.shihe;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ClassName SchedulingService
 * @Description TODO
 * @Author admin
 * @Date 2020-07-31 14:27
 * @Version 1.0
 */
@Service
public class SchedulingService {

    @Scheduled(fixedDelay = 5000)
    public void fixDelayMethod(){
        System.out.println("fixDelay方式计划任务"+new Date());
    }

    @Scheduled(fixedRate = 5000)
    public void fixRateMethod(){
        System.out.println("fixRate方式计划任务"+new Date());
    }

    @Scheduled(cron = "0/5 * * * * ? ")
    public void cronMethod(){
        System.out.println("cron方式计划任务"+new Date());
    }
}
