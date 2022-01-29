package com.n11.application.domain;

import com.n11.application.interfaces.request.ApplicationRequestDto;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Setter
@Getter
@Slf4j
public class UserInfo {

    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private String TCKN;
    private String name;
    private String surname;
    private Double income;
    private String phone;
    private Date birthdate;
    private Double assurance;


    public void createNewUser(ApplicationRequestDto applicationRequestDto) {
        this.TCKN = applicationRequestDto.getTckn();
        this.name = applicationRequestDto.getName();
        this.surname = applicationRequestDto.getSurname();
        this.income = applicationRequestDto.getIncome();
        this.phone = applicationRequestDto.getPhone();
        this.assurance = applicationRequestDto.getAssurance();
        try {
            this.birthdate = dateFormat.parse(applicationRequestDto.getBirthdate());
        } catch (ParseException e) {
            log.error("??? BIRTHDATE PARSE EXCEPTION ???");
        }
    }
}
