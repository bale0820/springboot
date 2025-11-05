package com.springboot.shoppy_fullstack_app.dto;

import com.springboot.shoppy_fullstack_app.entity.Member;
import lombok.Data;

@Data
public class MemberDto {
    private String id;
    private String pwd;
    private String name;
    private String phone;
    private String email;

    public MemberDto() {};

    // ✅ JPA에서 new MemberDto(m.id, m.pwd) 를 쓸 때 필요한 생성자
    public MemberDto(String id, String pwd) {
        this.id = id;
        this.pwd = pwd;
    }

    public MemberDto(Member entity) {
        this.id = entity.getId();
        this.pwd = entity.getPwd();
        this.name = entity.getName();
        this.phone = entity.getPhone();
        this.email = entity.getEmail();
    }

}
