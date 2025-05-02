package com.yalmung.mini.commerce.user.model;

import com.yalmung.mini.commerce.common.codeconst.YN;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Entity(name = "User")
@Table(name = "user")
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_no")
    private Long userNo;

    @Column(name="id")
    private String id;

    @Column(name="name")
    private String name;

    @Column(name="del_yn")
    @Enumerated(EnumType.STRING)
    private YN delYn;

    public User() {
        this.delYn = YN.N;
    }
}
