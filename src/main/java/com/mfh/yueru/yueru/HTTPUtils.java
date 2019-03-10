package com.mfh.yueru.yueru;

import com.google.gson.Gson;
import com.google.gson.internal.Primitives;
import okhttp3.*;

import java.io.IOException;

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
            System.out.println(string);
            return new Gson().fromJson(string, LoginEntity.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void doorLockHttp() {
        Request request = new Request.Builder()
                .post(RequestBody.create(MediaType.parse("application/application/x-www-form-urlencoded; charset=utf-8"), ""))
                .addHeader("intebox_sso_tkt","20f8c5243b4dd4bc85239adbe13ea7a5c88555b5c1df45fccc0ba5d342130ad0")
                .url("https://saas.lianyuplus.com/saas20/api/201410011/AptGuest/doorlock/batchAddWithArea" +
                        "?areaId=16774&guestId=116704&locks=%5B%7B%22lockId%22%3A%2202b7b58836dc941cc4ba33d16dab6e3059%22%2C%20%22name%22%3A%221606Z%E9%97%A8%E9%94%81%22%2C%22start%22%3A%222019-03-10%2018%3A57%22%2C%20%22end%22%3A%222019-03-11%2018%3A57%22%7D%5D&operatorId=57643")
                .build();
        OkHttpClient okHttpClient = new OkHttpClient();
        Call call = okHttpClient.newCall(request);
        try {
            Response execute = call.execute();
            String string = execute.body() != null ? execute.body().string() : "";
            System.out.println(string);
//            T t = new Gson().fromJson(string, tClass);
//            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
//        return null;
    }

    public static void main(String[] args) {
        doorLockHttp();
        login();
    }
}
