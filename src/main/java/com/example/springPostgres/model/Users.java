package com.example.springPostgres.model;


import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name= "utenti")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class Users {
    @Id
    private Long id;

    @Column(name="username", nullable = false)
    private String user;

    @Column(name="password", nullable = false)
    private String pwd;

    @Column(name="token", nullable = false)
    private String token;

}
