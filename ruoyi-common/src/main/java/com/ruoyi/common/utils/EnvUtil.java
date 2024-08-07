package com.ruoyi.common.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author akarin
 * @version 1.0
 * @description TODO))
 * @date 2024/8/8 5:36
 */
@Component
public class EnvUtil {
    @Value("baseUrl")
    public static String BASE_URL = "http://localhost:8080/";
}
