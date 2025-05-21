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
    private Integer userNo;

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

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.delYn = YN.N;
    }

    public User(int no, String id, String name, String delYn) {
        this.userNo = no;
        this.id = id;
        this.name = name;
        this.delYn = YN.valueOf(delYn);
    }

    public static User of(String id, String name) {
        return new User(id, name);
    }

    public static User of(int no, String id, String name, String delYn) {
        return new User(no, id, name, delYn);
    }
}
