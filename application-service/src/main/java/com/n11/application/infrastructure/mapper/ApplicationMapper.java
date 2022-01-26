package com.n11.application.infrastructure.mapper;

import com.n11.application.domain.ApplicationBox;
import com.n11.application.infrastructure.acl.entity.Application;

public class ApplicationMapper {

    public Application toApplicationEntityFromUserInfos(ApplicationBox applicationBox) {
        final Application application = new Application();
        application.setTCKN(applicationBox.getUserInfo().getTCKN());
        application.setIncome(applicationBox.getUserInfo().getIncome());
        application.setAssurance(applicationBox.getUserInfo().getAssurance());
        application.setBirthdate(applicationBox.getUserInfo().getBirthdate());
        application.setName(applicationBox.getUserInfo().getName());
        application.setSurname(applicationBox.getUserInfo().getSurname());
        application.setPhone(applicationBox.getUserInfo().getPhone());
        application.setKkbScore(applicationBox.getKkbScore());
        application.setResult(applicationBox.getResult());
        application.setLimit(applicationBox.getLimit());
        return application;
    }

}
