package com.n11.application.domain.flow.initiate;

import com.n11.application.domain.ApplicationBox;
import com.n11.application.domain.flow.Handler;
import com.n11.application.domain.flow.HandlerFactory;
import com.n11.application.domain.flow.HandlerType;
import com.n11.application.infrastructure.acl.entity.Application;
import com.n11.application.infrastructure.acl.repository.ApplicationRepository;
import com.n11.application.interfaces.request.ApplicationRequestDto;
import com.n11.application.interfaces.request.DeleteApplicationRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InitiatePersonalCredit implements InitiateStrategy{

    @Autowired
    private HandlerFactory handlerFactory;

    @Autowired
    private ApplicationRepository applicationRepository;

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

    @Override
    public void modify(ApplicationBox applicationBox) {
        log.info("Modify Personal Credit");

        final Handler modifyApplicationHandler = handlerFactory.create(HandlerType.APPLICATION_MODIFY);

        modifyApplicationHandler.handle(applicationBox);
    }

    @Override
    public void delete(ApplicationBox applicationBox) {
        log.info("Modify Personal Credit");

        final Handler deleteApplicationHandler = handlerFactory.create(HandlerType.APPLICATION_DELETE);

        deleteApplicationHandler.handle(applicationBox);
    }

    @Override
    public void query(ApplicationBox applicationBox) {
        log.info("Modify Personal Credit");

        final Handler queryApplicationHandler = handlerFactory.create(HandlerType.APPLICATION_QUERY);

        queryApplicationHandler.handle(applicationBox);
    }
}
