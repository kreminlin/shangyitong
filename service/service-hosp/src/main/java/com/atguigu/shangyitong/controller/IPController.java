package com.atguigu.shangyitong.controller;

import com.atguigu.shangyitong.utils.IpUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ip")
public class IPController {

    @RequestMapping(value = "/ipadress",method = RequestMethod.GET)
    public String  getProvince(String ip){
        IpUtils ipUtils = new IpUtils();
//        String city = ipUtils.getCityNameByTaoBaoAPI(ip);
        String key = "h60KQe4LLo7Q70ajUecvjh5OorUbeIGRjPxOfqzAQ0tsmPboRfZ1KSk5fSFfnmKz";
//        String cityXinlang = IpUtils.getCityNameBySinaAPI(ip);
        String cityAiWen = IpUtils.getCityNameByAiWenAPI(key,ip);
        return cityAiWen;
    }

}
