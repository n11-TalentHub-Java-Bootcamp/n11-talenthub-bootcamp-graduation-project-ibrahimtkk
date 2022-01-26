package com.n11.application.domain;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
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
        assertThat(applicationBox.getCreditType(), is(CreditType.PERSONALCREDIT));
    }

    @Test
    public void shouldReturnUserInfoDoesNotNull() {

        applicationBox.prepareApplicationBox();
        assertTrue(applicationBox.getUserInfo() != null);
    }
}
