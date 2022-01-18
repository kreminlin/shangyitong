package com.atguigu.shangyitong.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class IpUtils {

    public String getCityNameByTaoBaoAPI(String ip) {
        String url = "http://ip.taobao.com/service/getIpInfo.php?ip=" + ip;
        String cityName = "";
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        try {
            HttpResponse response = client.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                String strResult = EntityUtils.toString(response.getEntity());
                try {
                    JSONObject jsonResult = JSON.parseObject(strResult);
                    System.out.println(JSON.toJSONString(jsonResult, true));
                    JSONObject dataJson = jsonResult.getJSONObject("data");
                    cityName = dataJson.getString("city");
                    System.out.println(JSON.toJSONString(jsonResult, true));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cityName;
    }

    public static String getCityNameBySinaAPI(String ip) {
        String url = "http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=json&ip="
                + ip;
        String cityName = "";
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        try {
            HttpResponse response = client.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                String strResult = EntityUtils.toString(response.getEntity());
                try {
                    JSONObject jsonResult = JSON.parseObject(strResult);
                    cityName = jsonResult.getString("city");
                    System.out.println(JSON.toJSONString(jsonResult, true));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cityName;
    }

    public static String getCityNameByAiWenAPI(String key,String ip) {
        String url = "https://api.ipplus360.com/ip/geo/v1/city/?coordsys=WGS84&ip="
                + ip+"&key=" + key;
        String cityName = "";
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        try {
            HttpResponse response = client.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                String strResult = EntityUtils.toString(response.getEntity());
                try {
                    JSONObject jsonResult = JSON.parseObject(strResult);
                    cityName = jsonResult.getString("city");
                    System.out.println(JSON.toJSONString(jsonResult, true));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cityName;
    }

}
