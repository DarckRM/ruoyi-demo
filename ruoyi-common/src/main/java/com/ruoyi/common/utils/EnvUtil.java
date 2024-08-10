package com.ruoyi.common.utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author akarin
 * @version 1.0
 * @description TODO))
 * @date 2024/8/8 5:36
 */
@Data
@Component
public class EnvUtil {
    public static String BASE_URL;

    @Value("${baseUrl}")
    private String baseUrl;

    @PostConstruct
    public void setBASE_URL() {
        BASE_URL = this.baseUrl;
    }
}
