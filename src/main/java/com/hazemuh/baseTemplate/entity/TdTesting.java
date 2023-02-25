package com.hazemuh.baseTemplate.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
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
@Table(name = "td_testing", schema = "public")
public class TdTesting implements Serializable {

    //    id_dokumen uuid NOT NULL,
    @Id
    @Column(name = "nama", nullable = true)
    private String nama;

    //    id_header uuid NULL,
    @Column(name = "umur", nullable = true)
    private String umur;


}
