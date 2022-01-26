package com.n11.application.interfaces;

public enum ErrorCode {

    TCKNISNOTVALID("AS1000"),
    BIRTHDATEISNOTVALID("AS1001"),
    NAMEISNOTVALID("AS1002"),
    SURNAMEISNOTVALID("AS1003"),
    PHONEISNOTVALID("AS1004");

    private String code;

    ErrorCode(String code) {
        this.code = code;
    }

    public String code() {
        return this.code;
    }
}
