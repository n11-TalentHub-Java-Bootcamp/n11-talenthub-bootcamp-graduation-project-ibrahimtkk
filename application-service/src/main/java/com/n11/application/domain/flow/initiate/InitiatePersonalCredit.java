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
public class InitiatePersonalCredit implements InitiateStrategy{

    @Autowired
    private HandlerFactory handlerFactory;

    @Override
    public void initiate(ApplicationBox applicationBox) {
        log.info("Initiate Personal Credit");

        final Handler calculateKkbHandler = handlerFactory.create(HandlerType.KKB_CALCULATE);
        final Handler decideHandler = handlerFactory.create(HandlerType.DECIDE);
        final Handler saveApplicationHandler = handlerFactory.create(HandlerType.APPLICATION_SAVE);

        calculateKkbHandler.setSuccessor(decideHandler);
        decideHandler.setSuccessor(saveApplicationHandler);

        calculateKkbHandler.handle(applicationBox);

    }
}
