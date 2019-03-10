package com.mfh.yueru.yueru;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.HttpURLConnection;

@Component
public class Sch {

    @Scheduled(cron = "")
    public void Test(){

    }
}
