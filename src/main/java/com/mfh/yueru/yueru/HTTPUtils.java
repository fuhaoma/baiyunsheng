package com.mfh.yueru.yueru;

import com.google.gson.Gson;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

public class HTTPUtils {
    public static LoginEntity login() {
        Request request = new Request.Builder()
                .post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), ""))
                .url("https://saas.lianyuplus.com/saas20/api/201410011/AptGuest/sysLogin/customer/authenticate" +
                        "?pwd=ma123456&username=15516771992")
                .build();
        OkHttpClient okHttpClient = new OkHttpClient();
        Call call = okHttpClient.newCall(request);
        try {
            Response execute = call.execute();
            String string = execute.body() != null ? execute.body().string() : "";
            System.out.println("login"+string);
            return new Gson().fromJson(string, LoginEntity.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void doorLockHttp() {
        System.out.println("------------------------------------------------------------------------------------------------");
        String s=login().getData().getTicket();
        deleteDoorLockHttp(s);
        String lock= null;
        try {
            String start = DateUtils.getFormatDate( DateUtils.atDayStart(DateUtils.getDateAfterDays(new Date(),1)),DateUtils.DATE_TIME_H_M);
            String end = DateUtils.getFormatDate(DateUtils.atDayStart(DateUtils.getDateAfterDays(new Date(),2)),DateUtils.DATE_TIME_H_M);
            lock = URLEncoder.encode(String.format("[{\"lockId\":\"%s\",\"name\":\"1606Z门锁\",\"start\":\"%s\",\"end\":\"%s\"}]",getDoorLockHttp(s), start, end), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Request request = new Request.Builder()
                .post(RequestBody.create(MediaType.parse("application/application/x-www-form-urlencoded; charset=utf-8"), ""))
                .addHeader("intebox_sso_tkt","5e9df071552e6f86cdc560aeb5d12588645bca94460dbc864f5d5ae9db5b2455")
                .url("https://saas.lianyuplus.com/saas20/api/201410011/AptGuest/doorlock/batchAddWithArea" +
                        "?areaId=16774&guestId=116704&operatorId=57643&locks="+lock)
                .build();
        OkHttpClient okHttpClient = new OkHttpClient();
        Call call = okHttpClient.newCall(request);
        try {
            Response execute = call.execute();
            String string = execute.body() != null ? execute.body().string() : "";
            System.out.println("doorLockHttp"+string);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("------------------------------------------------------------------------------------------------");
    }

    public static void deleteDoorLockHttp(String token) {
        Request request = new Request.Builder()
                .post(RequestBody.create(MediaType.parse("application/application/x-www-form-urlencoded; charset=utf-8"), ""))
                .addHeader("intebox_sso_tkt",token)
                .url("https://saas.lianyuplus.com/saas20/api/201410011/AptGuest/ads/showads/disable?positionId=6&roomId=16774")
                .build();
        OkHttpClient okHttpClient = new OkHttpClient();
        Call call = okHttpClient.newCall(request);
        try {
            Response execute = call.execute();
            String string = execute.body() != null ? execute.body().string() : "";
            System.out.println("deleteDoorLockHttp"+string);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getDoorLockHttp(String token) {
        Request request = new Request.Builder()
                .post(RequestBody.create(MediaType.parse("application/application/x-www-form-urlencoded; charset=utf-8"), ""))
                .addHeader("intebox_sso_tkt",token)
                .url("https://saas.lianyuplus.com/saas20/api/201410011/AptGuest/doorlock/keysandpower?operatorId=57643&areaId=16774")
                .build();
        OkHttpClient okHttpClient = new OkHttpClient();
        Call call = okHttpClient.newCall(request);
        try {
            Response execute = call.execute();
            String string = execute.body() != null ? execute.body().string() : "";
            System.out.println("getDoorLockHttp"+string);
            return new Gson().fromJson(string, Locks.class).getData().getMajorKeys().get(0).getTdId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static void main(String[] args) throws UnsupportedEncodingException {
//        doorLockHttp();
////        login();
//        String start = DateUtils.getFormatDate( DateUtils.atDayStart(DateUtils.getDateAfterDays(new Date(),1)),DateUtils.DATE_TIME_H_M);
//        String end = DateUtils.getFormatDate(DateUtils.atDayStart(DateUtils.getDateAfterDays(new Date(),2)),DateUtils.DATE_TIME_H_M);
//        String lock="[{\"lockId\":\"%s\",\"name\":\"1606Z门锁\",\"start\":\"%s\",\"end\":\"%s\"}]";
//        Locks locks = new Locks();
//        locks.setLockId("02b7b58836dc941cc4ba33d16dab6e3059");
//        locks.setName("1606Z门锁");
//        locks.setStart(DateUtils.formatStringToDate("2019-03-14 12:00",DATE_TIME_H_M));
//        locks.setEnd(DateUtils.formatStringToDate("2019-03-15 12:00",DATE_TIME_H_M));
//        String a= new Gson().toJson(locks);
//        String encode = URLEncoder.encode(a, "UTF-8");
//        String decode = URLDecoder.decode("%5B%7B%22lockId%22%3A%2202b7b58836dc941cc4ba33d16dab6e3059%22%2C%20%22name%22%3A%221606Z%E9%97%A8%E9%94%81%22%2C%22start%22%3A%222019-03-14%2012%3A00%22%2C%20%22end%22%3A%222019-03-15%2012%3A00%22%7D%5D", "UTF-8");
//
//        System.out.println(encode.replaceAll("\\+","%20").equals("%5B%7B%22lockId%22%3A%2202b7b58836dc941cc4ba33d16dab6e3059%22%2C%20%22name%22%3A%221606Z%E9%97%A8%E9%94%81%22%2C%22start%22%3A%222019-03-14%2012%3A00%22%2C%20%22end%22%3A%222019-03-15%2012%3A00%22%7D%5D"));
//    }
}
