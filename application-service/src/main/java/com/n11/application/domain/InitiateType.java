package com.n11.application.domain;

import java.util.Arrays;

public enum InitiateType {

    NONE(0), PERSONALCREDIT(1), COMMERCIALCREDIT(2);

    private Integer code;

    InitiateType(Integer code) {
        this.code = code;
    }

    public static InitiateType of(Integer code) {
        return Arrays.stream(InitiateType.values()).filter(initiateType -> initiateType.getCode().equals(code)).findFirst().orElse(NONE);
    }

    public Integer getCode() {
        return code;
    }
}
