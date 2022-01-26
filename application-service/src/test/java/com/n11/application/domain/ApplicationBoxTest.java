package com.n11.application.domain;

import com.n11.application.application.validation.ValidationResult;
import com.n11.application.interfaces.ErrorCode;
import com.n11.application.interfaces.request.ApplicationRequestDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationBoxTest {

    private ApplicationBox applicationBox = new ApplicationBox();

    @Test
    public void shouldReturnInitiateTypeIsPersonal() {

        applicationBox.prepareApplicationBox();
        assertThat(applicationBox.getInitiateType(), is(InitiateType.PERSONALCREDIT));
    }

    @Test
    public void shouldReturnUserInfoDoesNotNull() {

        applicationBox.prepareApplicationBox();
        assertTrue(applicationBox.getUserInfo() != null);
    }
}
