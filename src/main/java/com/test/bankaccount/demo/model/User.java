package com.test.bankaccount.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class User implements Serializable{

    private static final long serialVersionUID = 0x45A6DA99BBBDA8A8L;

    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    private String userName;

    public Long getUserId() {
        return id;
    }

    public void setUserId(Long userId) {
        this.id = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
