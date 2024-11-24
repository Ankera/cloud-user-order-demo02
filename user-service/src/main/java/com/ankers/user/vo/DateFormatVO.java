package com.ankers.user.vo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "pattern")
@Data
public class DateFormatVO {

    private String format;
}
