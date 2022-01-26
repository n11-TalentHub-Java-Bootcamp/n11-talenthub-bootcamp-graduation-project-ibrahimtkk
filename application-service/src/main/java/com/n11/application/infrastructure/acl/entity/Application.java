package com.n11.application.infrastructure.acl.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "BASVURU_BILGILERI", schema = "PUBLIC")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "BASVURU_NUMARASI")
    private Long applicationId;

    @Column(name = "TCKN")
    private String TCKN;

    @Column(name = "ISIM")
    private String name;

    @Column(name = "SOYISIM")
    private String surname;

    @Column(name = "GELIR")
    private Integer income;

    @Column(name = "TELEFON")
    private String phone;

    @Column(name = "DOGUM_TARIHI")
    private Date birthdate;

    @Column(name = "TEMINAT")
    private String Assurance;

    @Column(name = "KKB_SKORU")
    private Integer kkbScore;

    @Column(name = "SONUC")
    private String result;

    @Column(name = "KREDI_LIMIT")
    private Integer limit;

}
