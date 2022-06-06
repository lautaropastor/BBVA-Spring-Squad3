package com.alkemy.disney.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table (name = "users")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class MyUsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(unique = true)
    private String username;
    @Column
    private String password;

    public MyUsersEntity (String username, String password) {
        this.username = username;
        this.password = password;
    }
}
