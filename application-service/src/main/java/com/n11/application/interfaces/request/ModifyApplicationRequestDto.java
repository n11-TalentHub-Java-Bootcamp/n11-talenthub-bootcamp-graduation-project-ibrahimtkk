package com.n11.application.interfaces.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModifyApplicationRequestDto {

    private String tckn;
    private String birthdate;
    private Double income;
    private String phone;
    private Double assurance;
}
