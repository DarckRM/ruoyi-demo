package com.ruoyi.greatzc.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author akarin
 * @version 1.0
 * @description TODO))
 * @date 2024/8/7 22:52
 */
@Data
public class About implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String title;
    private String subTitle;
    private String content;
    private String address;
    private String majorEmail;
    private String subEmail;
    private String tel;
    private String keywords;

}
