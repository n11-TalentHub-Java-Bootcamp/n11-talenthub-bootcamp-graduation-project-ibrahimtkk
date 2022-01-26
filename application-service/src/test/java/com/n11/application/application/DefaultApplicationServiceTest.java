package com.n11.application.application;

import com.n11.application.domain.ApplicationBox;
import com.n11.application.domain.CreditType;
import com.n11.application.domain.flow.initiate.InitiateStrategy;
import com.n11.application.domain.flow.initiate.InitiateStrategyProvider;
import com.n11.application.interfaces.request.ApplicationRequestDto;
import com.n11.application.interfaces.response.ApplicationResponseDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DefaultApplicationServiceTest {

    InitiateStrategyProvider initiateStrategyProvider = mock(InitiateStrategyProvider.class);
    DefaultApplicationService defaultApplicationService = new DefaultApplicationService(initiateStrategyProvider);
    InitiateStrategy initiateStrategy = mock(InitiateStrategy.class);

    ApplicationBox applicationBox = null;


    @Test
    public void shouldReturnTrue() {

        final ApplicationRequestDto request = new ApplicationRequestDto();
        request.setTckn("11223334455");
        request.setBirthdate("2022-11-21");
        request.setName("ibrahim");
        request.setSurname("ibrahimke");

        when(initiateStrategyProvider.provide(CreditType.PERSONALCREDIT)).thenReturn(initiateStrategy);
        doThrow(new RuntimeException()).doNothing().when(initiateStrategy).initiate(applicationBox);

        ApplicationResponseDto applicationResponseDto = defaultApplicationService.initiate(request);
        assert(applicationResponseDto != null);

    }
}
