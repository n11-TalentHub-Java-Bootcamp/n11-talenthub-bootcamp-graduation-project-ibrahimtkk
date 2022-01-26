package com.n11.application.infrastructure.mapper;

import com.n11.application.domain.ApplicationBox;
import com.n11.application.domain.CreditType;
import com.n11.application.domain.UserInfo;
import com.n11.application.infrastructure.acl.entity.Application;
import com.n11.application.interfaces.request.ApplicationRequestDto;
import com.n11.application.interfaces.request.DeleteApplicationRequestDto;
import com.n11.application.interfaces.request.ModifyApplicationRequestDto;
import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Slf4j
public class ApplicationMapper {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

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

    public ApplicationBox toApplicationBoxFromRequest(ModifyApplicationRequestDto applicationRequestDto){
        final ApplicationBox applicationBox = new ApplicationBox();
        final UserInfo userInfo = new UserInfo();

        userInfo.setTCKN(applicationRequestDto.getTckn());
        try {
            userInfo.setBirthdate(dateFormat.parse(applicationRequestDto.getBirthdate()));
        } catch (ParseException e) {
            log.debug("Birthdate is not acceptable");
        };
        userInfo.setAssurance(applicationRequestDto.getAssurance());
        userInfo.setIncome(applicationRequestDto.getIncome());
        userInfo.setPhone(applicationRequestDto.getPhone());
        applicationBox.setCreditType(CreditType.PERSONALCREDIT);
        applicationBox.setUserInfo(userInfo);
        return applicationBox;
    }

    public ApplicationBox toApplicationBoxFromDeleteRequest(DeleteApplicationRequestDto applicationRequestDto){
        final ApplicationBox applicationBox = new ApplicationBox();
        final UserInfo userInfo = new UserInfo();

        userInfo.setTCKN(applicationRequestDto.getTckn());
        try {
            userInfo.setBirthdate(dateFormat.parse(applicationRequestDto.getBirthdate()));
        } catch (ParseException e) {
            log.debug("Birthdate is not acceptable");
        }
        applicationBox.setCreditType(CreditType.PERSONALCREDIT);
        applicationBox.setUserInfo(userInfo);
        return applicationBox;
    }

}
