package com.ankers.order;

import com.ankers.api.UserFeignClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@MapperScan("com.ankers.order.mapper")
@SpringBootApplication
// 开启feign功能支持，自动扫描main启动类的同级或者一切子日录下的feign客户端资源
@EnableFeignClients(basePackages = {"com.ankers.api"})
//@EnableFeignClients(basePackageClasses = UserFeignClient.class)
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}