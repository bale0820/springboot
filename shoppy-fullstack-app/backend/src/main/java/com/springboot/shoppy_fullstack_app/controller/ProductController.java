package com.springboot.shoppy_fullstack_app.controller;


import com.springboot.shoppy_fullstack_app.dto.Product;
import com.springboot.shoppy_fullstack_app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService =  productService;
    }


    @GetMapping("/all")
    public List<Product> all() {
        System.out.println("controller!!!!");
        return productService.findAll(); //리스트 타입은 제이슨으로 변환후 전달
        
    }

    @PostMapping("/pid")
    public Product pid(@RequestBody Product product ) {
        System.out.println("controller!!!!");
        return productService.findByPid(product.getPid()); //리스트 타입은 제이슨으로 변환후 전달
    }
}
