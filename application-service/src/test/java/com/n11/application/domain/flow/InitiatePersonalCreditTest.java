//package com.n11.application.domain.flow;
//
//import com.n11.application.application.validation.ValidationResult;
//import com.n11.application.domain.InitiateType;
//import com.n11.application.interfaces.ErrorCode;
//import com.n11.application.interfaces.request.ApplicationRequestDto;
//import com.n11.application.interfaces.response.ApplicationResponseDto;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.assertThat;
//import static org.mockito.Mockito.doThrow;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class InitiatePersonalCreditTest {
//
//    @Test
//    public void validateShouldReturnTCKNNotValidErrorWhenGivenTCKNIsNull() {
//
//        inal ApplicationRequestDto request = new ApplicationRequestDto();
//
//        when(initiateStrategyProvider.provide(InitiateType.PERSONALCREDIT)).thenReturn(initiateStrategy);
//        doThrow(new RuntimeException()).doNothing().when(initiateStrategy).initiate(applicationBox);
//
//        ApplicationResponseDto applicationResponseDto = defaultApplicationService.initiate(request);
//        assert(applicationResponseDto != null);
//    }
//
//
//}
