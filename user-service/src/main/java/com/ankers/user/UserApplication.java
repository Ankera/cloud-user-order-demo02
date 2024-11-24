package com.ankers.user;

import com.ankers.user.vo.DateFormatVO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@MapperScan("com.ankers.user.mapper")
@SpringBootApplication
@EnableConfigurationProperties({DateFormatVO.class})
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
