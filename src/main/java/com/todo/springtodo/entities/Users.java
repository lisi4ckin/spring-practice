package com.todo.springtodo.entities;

import com.sun.istack.NotNull;
import lombok.Data;
import org.apache.commons.codec.digest.DigestUtils;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String login;
    @NotNull
    private String hashPassword;

    @OneToOne(cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST
    }, fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    public void setHashPassword(String hashPassword) {
        this.hashPassword = DigestUtils.md5Hex(hashPassword);
    }
}
