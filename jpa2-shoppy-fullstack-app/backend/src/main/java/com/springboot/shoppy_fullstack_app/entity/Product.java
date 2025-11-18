package com.springboot.shoppy_fullstack_app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="product")
@Getter @Setter
public class Product {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;
    private String name;
    private long price;
    private String info;
    private double rate;
    private String image;

    @Column(columnDefinition = "JSON")
    private String imgList;
}
