package com.mfh.yueru.yueru;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledUtils {

    @Scheduled(cron = "00 30 23 * * *")
    public void Test(){
        HTTPUtils.doorLockHttp();
    }

//    @Scheduled(cron="0/5 * *  * * ? ")
//    public void Test1(){
//        System.out.println("aaaaaaaaaaaaaaa");
//    }
}
