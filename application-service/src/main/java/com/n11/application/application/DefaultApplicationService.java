package com.n11.application.application;

import com.n11.application.domain.ApplicationBox;
import com.n11.application.domain.InitiateType;
import com.n11.application.domain.flow.initiate.InitiateStrategy;
import com.n11.application.domain.flow.initiate.InitiateStrategyProvider;
import com.n11.application.domain.service.ApplicationAppService;
import com.n11.application.interfaces.request.ApplicationRequestDto;
import com.n11.application.interfaces.response.ApplicationResponseDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class DefaultApplicationService implements ApplicationAppService {

    @Autowired
    private InitiateStrategyProvider initiateStrategyProvider;

    @Override
    public ApplicationResponseDto initiate(ApplicationRequestDto applicationRequestDto) {

        ApplicationBox applicationBox = new ApplicationBox();
        applicationBox.prepareApplicationBox();
        applicationBox.getUserInfo().createNewUser(applicationRequestDto);

        final InitiateStrategy initiateStrategy = initiateStrategyProvider.provide(applicationBox.getInitiateType());
        initiateStrategy.initiate(applicationBox);

        final ApplicationResponseDto applicationResponseDto = new ApplicationResponseDto();
        buildInitiateApplicationResponse(applicationBox, applicationResponseDto);

        return applicationResponseDto;
    }




    private void buildInitiateApplicationResponse(ApplicationBox applicationBox, ApplicationResponseDto applicationResponseDto) {
        applicationResponseDto.setKkbScore(applicationBox.getKkbScore());
        applicationResponseDto.setResult(applicationBox.getResult());
        applicationResponseDto.setLimit(applicationBox.getLimit());
    }
}
