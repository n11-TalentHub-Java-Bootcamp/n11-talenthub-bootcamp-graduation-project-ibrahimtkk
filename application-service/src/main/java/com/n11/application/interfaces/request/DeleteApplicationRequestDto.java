package com.n11.application.interfaces.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteApplicationRequestDto {

    private String tckn;
    private String birthdate;
}
