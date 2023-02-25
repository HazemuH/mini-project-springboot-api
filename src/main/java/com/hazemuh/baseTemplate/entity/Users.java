package com.hazemuh.baseTemplate.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;


@Setter
@Getter
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users", schema = "project")
public class Users implements Serializable {

    //    id int4 NOT NULL,
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "users_id", nullable = true)
    private UUID usersId;

    //	  "name" varchar NULL,
    @Column(name = "name", nullable = true)
    private String name;

    //    email varchar NULL,
    @Column(name = "email", nullable = true)
    private String email;

    //    "password" varchar NULL,
    @Column(name = "password", nullable = true)
    private String password;

    //    created_at timestamp NULL,
    @Column(name = "created_at", nullable = true)
    private Date createdAt;

    //    updated_at timestamp NULL
    @Column(name = "updated_at", nullable = true)
    private Date updatedAt;
}
