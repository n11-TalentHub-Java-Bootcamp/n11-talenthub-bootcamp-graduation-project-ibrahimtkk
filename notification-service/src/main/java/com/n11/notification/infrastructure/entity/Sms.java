package com.n11.notification.infrastructure.entity;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "SMS", schema = "FINANS")
@SequenceGenerator(name = "sms_seq", sequenceName = "sms_id", schema = "FINANS", allocationSize = 1)
public class Sms {

    @Id
    @Column(name = "RECORD_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sms_seq")
    @Expose
    private Integer recordId;

    @Column(name = "PHONE_NUMBER")
    @Expose
    private String phoneNumber;

    @Column(name = "MESSAGE_BODY")
    @Expose
    private String text;

    @Column(name = "INSERT_DATE")
    private LocalDateTime insertDate;

    @Column(name = "TCKN")
    private String citizenId;

    @Column(name = "TALEP_NO")
    private String applicationId;
}
