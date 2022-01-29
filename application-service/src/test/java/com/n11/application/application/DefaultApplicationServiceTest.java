//package com.n11.application.application;
//
//import com.n11.application.domain.ApplicationBox;
//import com.n11.application.domain.CreditType;
//import com.n11.application.domain.flow.HandlerFactory;
//import com.n11.application.domain.flow.initiate.DefaultInitiateStrategyProvider;
//import com.n11.application.domain.flow.initiate.InitiatePersonalCredit;
//import com.n11.application.domain.flow.initiate.InitiateStrategy;
//import com.n11.application.domain.flow.initiate.InitiateStrategyProvider;
//import com.n11.application.interfaces.request.ApplicationRequestDto;
//import com.n11.application.interfaces.response.ApplicationResponseDto;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
////import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.Spy;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import static org.mockito.Mockito.*;
//
//@RunWith(MockitoJUnitRunner.class)
//public class DefaultApplicationServiceTest {
//
//    @Mock
//    InitiateStrategyProvider initiateStrategyProvider;
//
//    @Mock
//    DefaultInitiateStrategyProvider defaultInitiateStrategyProvider;
//
//    @Spy
//    InitiateStrategy initiateStrategy;
//
//    @Spy
//    InitiatePersonalCredit initiatePersonalCredit;
//
//    @Mock
//    DefaultApplicationService defaultApplicationService;
//
//    ApplicationRequestDto applicationRequestDto;
//
//    @Mock
//    HandlerFactory handlerFactory;
//
//    @Mock
//    ApplicationBox applicationBox;
//
//    @Before
//    public void setUp() {
//        applicationRequestDto = new ApplicationRequestDto();
//        applicationRequestDto.setTckn("12345678901");
//        applicationRequestDto.setName("ibrahim");
//        applicationRequestDto.setSurname("ibrahimmm");
//        applicationRequestDto.setBirthdate("01/01/1990");
//        applicationRequestDto.setAssurance(1000.0);
//        applicationRequestDto.setIncome(100000.0);
//        applicationRequestDto.setPhone("5555555555");
//    }
//
//    @Test
//    public void ApplicationResponseDtoShouldNotReturnNullWhenInitiate() {
//
//        final ApplicationRequestDto request = new ApplicationRequestDto();
//        final ApplicationResponseDto applicationResponseDto = new ApplicationResponseDto();
//
//        DefaultApplicationService applicationAppService = new DefaultApplicationService();
//        DefaultApplicationService applicationAppServiceSpy = Mockito.spy(applicationAppService);
//
//        request.setTckn("11223334455");
//        request.setBirthdate("2022-11-21");
//        request.setName("ibrahim");
//        request.setSurname("ibrahimke");
//
//        when(initiateStrategyProvider.provide(CreditType.PERSONALCREDIT)).thenReturn(initiatePersonalCredit);
//        doNothing().when(initiatePersonalCredit).initiate(applicationBox);
//        doNothing().when(applicationAppServiceSpy).buildInitiateApplicationResponse(applicationBox, applicationResponseDto);
//
//        assert(applicationResponseDto != null);
//    }
//
//
//}
