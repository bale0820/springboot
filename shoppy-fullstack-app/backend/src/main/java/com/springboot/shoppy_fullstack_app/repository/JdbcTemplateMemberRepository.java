package com.springboot.shoppy_fullstack_app.repository;

import com.springboot.shoppy_fullstack_app.dto.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;


@Repository
public class JdbcTemplateMemberRepository implements MemberRepository {

    private final JdbcTemplate jdbcTemplate;

    //생성자
    @Autowired
    public JdbcTemplateMemberRepository(DataSource datasource) {
        this.jdbcTemplate = new JdbcTemplate(datasource); //커넥션 생성
    }
    @Override
    public int save(Member member) {
        String sql = "insert into member(id, pwd, name, phone, email, mdate) values(?,?,?,?,?,now())"; //prepareStatement
        Object[] param = {member.getId(),
                          member.getPwd(),
                          member.getName(),
                          member.getPhone(),
                          member.getEmail()};
        int rows = jdbcTemplate.update(sql,
                param);
        return rows;
        //return rows;
    }

    @Override
    public Long findId(String id) {
        String sql = "select count(id) from member where id = ?";

        Object[] param = {id};

        Long count = jdbcTemplate.queryForObject(sql, Long.class,  param);
        return count;
    }

    @Override
    public String login(String id) {
        String sql = "select pwd from member where id = ?";
        Object[] param = {id};

        Member member = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Member.class), //RowMapper<T>
                                                    id);
        return member.getPwd();
    }
}
