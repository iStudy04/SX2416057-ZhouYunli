package com.example.softwaretesting;

import com.example.softwaretesting.entry.IpInfo;
import com.example.softwaretesting.entry.WeatherInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;


public class GaodeTests {

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testIp() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();

        // 测试nuaa.edu.cn的IP地址218.94.136.180
        String url1 = "https://restapi.amap.com/v3/ip?key=8740dd420bb02a3921d506032f906ca6&ip=218.94.136.180";


        IpInfo ipInfo1 = restTemplate.getForObject(url1, IpInfo.class);
        Assertions.assertNotNull(ipInfo1);
        Assertions.assertEquals("1",ipInfo1.getStatus());
        Assertions.assertEquals("OK",ipInfo1.getInfo());
        Assertions.assertEquals("江苏省",ipInfo1.getProvince());
        Assertions.assertEquals("南京市",ipInfo1.getCity());
        System.out.println(ipInfo1);

        // 测试baidu.com的IP地址39.156.66.10
        String url2 = "https://restapi.amap.com/v3/ip?key=8740dd420bb02a3921d506032f906ca6&ip=39.156.66.10";

        IpInfo ipInfo2 = restTemplate.getForObject(url2, IpInfo.class);
        Assertions.assertNotNull(ipInfo2);
        Assertions.assertEquals("1",ipInfo2.getStatus());
        Assertions.assertEquals("OK",ipInfo2.getInfo());
        Assertions.assertEquals("北京市",ipInfo2.getProvince());
        Assertions.assertEquals("北京市",ipInfo2.getCity());
        System.out.println(ipInfo2);
        System.out.println("高德Web服务API: IP 定位接口测试成功，测试人：SX2316078 韩逸轩");
    }

    @Test
    public void testWeather() {
        RestTemplate restTemplate = new RestTemplate();

        // 查看南京天气情况（南京的adcode为320100）
        String url = "https://restapi.amap.com/v3/weather/weatherInfo?key=8740dd420bb02a3921d506032f906ca6&city=320100";

        WeatherInfo weatherInfo = restTemplate.getForObject(url, WeatherInfo.class);
        Assertions.assertNotNull(weatherInfo);
        Assertions.assertEquals("1",weatherInfo.getStatus());
        Assertions.assertEquals("OK",weatherInfo.getInfo());
        Assertions.assertEquals("江苏",weatherInfo.getLives().get(0).getProvince());
        Assertions.assertEquals("南京市",weatherInfo.getLives().get(0).getCity());
        System.out.println(weatherInfo);
        System.out.println("高德Web服务API: 天气查询接口测试成功，测试人：SX2316078 韩逸轩");
    }
}
