package com.n11.application.domain.flow.initiate;

import com.n11.application.domain.ApplicationBox;
import com.n11.application.domain.flow.Handler;
import com.n11.application.domain.flow.HandlerFactory;
import com.n11.application.domain.flow.HandlerType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InitiateCommercialCredit implements InitiateStrategy{
    @Autowired
    private HandlerFactory handlerFactory;

    @Override
    public void initiate(ApplicationBox applicationBox) {

    }

    @Override
    public void modify(ApplicationBox applicationBox) {

    }

    @Override
    public void delete(ApplicationBox applicationBox) {

    }

    @Override
    public void query(ApplicationBox applicationBox) {

    }
}
