package com.springboot.shoppy_fullstack_app.repository;

import com.springboot.shoppy_fullstack_app.dto.Member;

public interface MemberRepository {
    public int save(Member member);
    public Long findId(String id);
    public Long login(String id, String pwd);
}
