package com.n11.application.domain.flow;

import com.n11.application.domain.flow.initiate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public final class HandlerFactory {

    @Autowired
    SaveApplicationHandler saveApplicationHandler;

    @Autowired
    kkbCalculateHandler kkbCalculateHandler;

    @Autowired
    DecideCreditHandler decideCreditHandler;

    @Autowired
    AssuranceHandler assuranceHandler;

    @Autowired
    ModifyApplicationHandler modifyApplicationHandler;

    @Autowired
    DeleteApplicationHandler deleteApplicationHandler;

    @Autowired
    QueryApplicationHandler queryApplicationHandler;

    public Handler create(HandlerType handlerType) {
        switch (handlerType) {
            case APPLICATION_SAVE:
                return saveApplicationHandler;
            case KKB_CALCULATE:
                return kkbCalculateHandler;
            case DECIDE:
                return decideCreditHandler;
            case APPLICATION_MODIFY:
                return modifyApplicationHandler;
            case APPLICATION_DELETE:
                return deleteApplicationHandler;
            case APPLICATION_QUERY:
                return queryApplicationHandler;
            case ASSURANCE:
                return assuranceHandler;

            default:
                throw new IllegalArgumentException("Invalid handler type: " + handlerType.toString());
        }
    }
}