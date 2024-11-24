package com.ankers.user.web;

import com.ankers.user.pojo.User;
import com.ankers.user.service.UserService;
import com.ankers.user.vo.DateFormatVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
//@RefreshScope
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        return userService.queryById(id);
    }

//    @Value("${pattern.format}")
//    private String pattern;

    @Autowired
    private DateFormatVO dateFormatVO;

    @GetMapping("/testData")
    public String getDateNow() {
        System.out.println("====new request" + dateFormatVO.getFormat());
        return LocalDate.now().format(DateTimeFormatter.ofPattern(dateFormatVO.getFormat()));
    }
}
