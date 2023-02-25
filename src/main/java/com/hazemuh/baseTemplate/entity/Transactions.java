package com.hazemuh.baseTemplate.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;


@Setter
@Getter
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transactions", schema = "project")
public class Transactions implements Serializable {

//    id int4 NOT NULL,
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "transaction_id", nullable = false)
    private UUID transactionId;

//    user_id int4 NULL,
    @Column(name = "users_id", nullable = true)
    private UUID usersId;

//    amount numeric NULL,
    @Column(name = "amount", nullable = true)
    private Long amount;

//    transaction_type varchar NULL,
    @Column(name = "transaction_type", nullable = true)
    private String transactionType;

//    description varchar NULL,
    @Column(name = "description", nullable = true)
    private String description;

//    created_at timestamp NULL,
    @Column(name = "created_at", nullable = true)
    private Date createdAt;

//    updated_at timestamp NULL
    @Column(name = "updated_at", nullable = true)
    private Date updatedAt;

}
