package com.n11.application.interfaces.request;

import com.n11.application.domain.InitiateType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ApplicationRequestDto {

    private String TCKN;
    private String name;
    private String surname;
    private Integer income;
    private String phone;
    private String birthdate;
    private String assurance;
}
