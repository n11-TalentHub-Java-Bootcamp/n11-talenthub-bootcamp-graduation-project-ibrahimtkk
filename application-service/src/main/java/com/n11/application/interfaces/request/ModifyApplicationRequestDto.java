package com.n11.application.interfaces.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModifyApplicationRequestDto {

    private String tckn;
    private String birthdate;
    private Integer income;
    private String phone;
    private String assurance;
}
