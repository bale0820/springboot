package com.springboot.shoppy_fullstack_app.dto;

import lombok.Data;

import java.util.Date;

@Data
public class Support{
    private int sid;
    private String title;
    private String content;
    private String stype;
    private int hits;
    private Date rdate;
}