package com.ewy.wms2light;

import com.ewy.wms2light.entity.User;
import com.ewy.wms2light.mapper.UserMapper;
import com.ewy.wms2light.utils.MD5Util;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class Wms2lightApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
    }

    @Test
    public void getPassword(){
        String aa = "testappkeytestformatjsonmethodpick.order.status.updatesidwms_ltsign_methodmd5timestamp2021-11-1816:28:30{\"pick_no\":\"FJ2104080001\",\"status\":40}test";
        String bb = "testappkeytestformatjsonmethodpick.order.status.updatesidwms_ltsign_methodmd5timestamp2021-11-1816:28:30{\"pick_no\":\"FJ2104080001\",\"status\":40}test";
        String cc = "testappkeytestformatjsonmethodpick.order.status.updatesidwms_ltsign_methodmd5timestamp2021-11-18 16:34:30{\"pick_no\":\"FJ2104080001\",\"status\": 40}test";
        String s1 = MD5Util.stringToMD5(aa);
        String s = MD5Util.stringToMD5(bb);
        String s22 = MD5Util.stringToMD5(cc);
        System.out.println(s);
        System.out.println(s1);
        System.out.println(s22);

    }

    @Test
    public void userMapperTest(){
        User user = userMapper.findById(1);
        System.out.println(user);
    }

    @Test
    public void restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("get users");
        ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:8080/user/userlist",String.class);
        System.out.println(entity.getBody());
    }
}
