package com.n11.application.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Setter
@Getter
@Slf4j
public class ApplicationBox {

    private UserInfo userInfo;
    private CreditType creditType;

    // bunun asagisini servis kendi üretiyor
    private String result;
    private Integer kkbScore;
    private Integer limit;

    public ApplicationBox prepareApplicationBox() {
        this.userInfo = new UserInfo();
        // ileride ticari kredilerin gelme ihtimaline karşı eklenmiştir(oyle bir durumdan initiateType request olarak alinacaktir)
        this.setCreditType(CreditType.PERSONALCREDIT);
        return this;
    }


}
