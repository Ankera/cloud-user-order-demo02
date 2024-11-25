package com.ankers.api;

import com.ankers.pojo.User;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("userservice")
@EnableFeignClients(defaultConfiguration = FeignClient.class)
public interface UserFeignClient {

    @GetMapping("/user/{id}")
    User queryById(@PathVariable("id") Long id);

    /**
     * 多个参数添加  RequestParam
     * @param userName
     * @param age
     * @return
     */
    @GetMapping("/user/testData2")
    String testData2(@RequestParam("userName") String userName, @RequestParam("age") Integer age);
}
