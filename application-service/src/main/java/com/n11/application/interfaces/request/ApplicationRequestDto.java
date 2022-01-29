package com.n11.application.interfaces.request;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationRequestDto {

    private String tckn;
    private String name;
    private String surname;
    private Double income;
    private String phone;
    private String birthdate;
    private Double assurance;
}
