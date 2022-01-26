package com.n11.application.application;

import com.n11.application.domain.ApplicationBox;
import com.n11.application.domain.CreditType;
import com.n11.application.domain.UserInfo;
import com.n11.application.domain.flow.initiate.InitiateStrategy;
import com.n11.application.domain.flow.initiate.InitiateStrategyProvider;
import com.n11.application.domain.service.ApplicationAppService;
import com.n11.application.infrastructure.mapper.ApplicationMapper;
import com.n11.application.interfaces.request.ApplicationRequestDto;
import com.n11.application.interfaces.request.DeleteApplicationRequestDto;
import com.n11.application.interfaces.request.ModifyApplicationRequestDto;
import com.n11.application.interfaces.response.ApplicationResponseDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class DefaultApplicationService implements ApplicationAppService {

    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private InitiateStrategyProvider initiateStrategyProvider;

    @Override
    public ApplicationResponseDto initiate(ApplicationRequestDto applicationRequestDto) {

        ApplicationBox applicationBox = new ApplicationBox();
        applicationBox.prepareApplicationBox();
        applicationBox.getUserInfo().createNewUser(applicationRequestDto);

        final InitiateStrategy initiateStrategy = initiateStrategyProvider.provide(applicationBox.getCreditType());
        initiateStrategy.initiate(applicationBox);

        final ApplicationResponseDto applicationResponseDto = new ApplicationResponseDto();
        buildInitiateApplicationResponse(applicationBox, applicationResponseDto);

        return applicationResponseDto;
    }

    @Override
    public ApplicationResponseDto modify(ModifyApplicationRequestDto applicationRequestDto) {
        ApplicationMapper applicationMapper = new ApplicationMapper();
        ApplicationBox applicationBox = applicationMapper.toApplicationBoxFromRequest(applicationRequestDto);

        final InitiateStrategy modifyStrategy = initiateStrategyProvider.provide(applicationBox.getCreditType());
        modifyStrategy.modify(applicationBox);

        final ApplicationResponseDto applicationResponseDto = new ApplicationResponseDto();
        buildInitiateApplicationResponse(applicationBox, applicationResponseDto);

        return applicationResponseDto;
    }

    @Override
    public ApplicationResponseDto delete(DeleteApplicationRequestDto applicationRequestDto) {
        ApplicationMapper applicationMapper = new ApplicationMapper();
        ApplicationBox applicationBox = applicationMapper.toApplicationBoxFromDeleteRequest(applicationRequestDto);

        final InitiateStrategy modifyStrategy = initiateStrategyProvider.provide(applicationBox.getCreditType());
        modifyStrategy.delete(applicationBox);

        final ApplicationResponseDto applicationResponseDto = new ApplicationResponseDto();
        buildInitiateApplicationResponse(applicationBox, applicationResponseDto);

        return applicationResponseDto;
    }

    @Override
    public ApplicationResponseDto query(String tckn, String birthdate) {
        ApplicationBox applicationBox = new ApplicationBox();
        UserInfo userInfo = null;
        try {
            userInfo = new UserInfo();
            userInfo.setTCKN(tckn);
            userInfo.setBirthdate(dateFormat.parse(birthdate));
        } catch (ParseException e) {
            // TODO: will add return
            log.debug("Error occured when building UserInfo");
        }
        applicationBox.setUserInfo(userInfo);
        applicationBox.setCreditType(CreditType.PERSONALCREDIT);

        final InitiateStrategy modifyStrategy = initiateStrategyProvider.provide(applicationBox.getCreditType());
        modifyStrategy.query(applicationBox);

        final ApplicationResponseDto applicationResponseDto = new ApplicationResponseDto();
        buildInitiateApplicationResponse(applicationBox, applicationResponseDto);

        return applicationResponseDto;
    }


    private void buildInitiateApplicationResponse(ApplicationBox applicationBox, ApplicationResponseDto applicationResponseDto) {
        applicationResponseDto.setKkbScore(applicationBox.getKkbScore());
        applicationResponseDto.setResult(applicationBox.getResult());
        applicationResponseDto.setLimit(applicationBox.getLimit());
    }

    private void buildQueryApplicationResponse(ApplicationBox applicationBox, ApplicationResponseDto applicationResponseDto) {
        applicationResponseDto.setKkbScore(applicationBox.getKkbScore());
        applicationResponseDto.setResult(applicationBox.getResult());
        applicationResponseDto.setLimit(applicationBox.getLimit());
    }
}
