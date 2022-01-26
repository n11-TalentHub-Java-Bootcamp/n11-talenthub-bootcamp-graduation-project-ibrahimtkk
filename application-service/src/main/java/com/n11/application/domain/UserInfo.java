package com.n11.application.domain;

import com.n11.application.interfaces.request.ApplicationRequestDto;
import lombok.Getter;
import lombok.Setter;
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
    Date date;

    private String TCKN;
    private String name;
    private String surname;
    private Integer income;
    private String phone;
    private Date birthdate;
    private String assurance;


    public void createNewUser(ApplicationRequestDto applicationRequestDto) {
        this.TCKN = applicationRequestDto.getTCKN();
        this.name = applicationRequestDto.getName();
        this.surname = applicationRequestDto.getSurname();
        this.income = applicationRequestDto.getIncome();
        this.phone = applicationRequestDto.getPhone();
        try {
            this.birthdate = dateFormat.parse(applicationRequestDto.getBirthdate());
        } catch (ParseException e) {
            log.error("??? BIRTHDATE PARSE EXCEPTION ???");
        }
    }
}
