package com.n11.application.domain;

import java.util.Arrays;

public enum CreditType {

    NONE(0), PERSONALCREDIT(1), COMMERCIALCREDIT(2);

    private Integer code;

    CreditType(Integer code) {
        this.code = code;
    }

    public static CreditType of(Integer code) {
        return Arrays.stream(CreditType.values()).filter(initiateType -> initiateType.getCode().equals(code)).findFirst().orElse(NONE);
    }

    public Integer getCode() {
        return code;
    }
}
