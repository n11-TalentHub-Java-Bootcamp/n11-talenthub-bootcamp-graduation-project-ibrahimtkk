package com.n11.user.infrastructure.entity;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "KULLANICI_BILGILERI", schema = "FINANS")
public class User {

    @Id
    @Column(name = "TCKN")
    private String TCKN;

    @Column(name = "ISIM")
    private String name;

    @Column(name = "SOYISIM")
    private String surname;



}
