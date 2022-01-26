package com.n11.application.domain.flow;

import com.n11.application.domain.flow.initiate.DecideCreditHandler;
import com.n11.application.domain.flow.initiate.SaveApplicationHandler;
import com.n11.application.domain.flow.initiate.kkbCalculateHandler;
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

    public Handler create(HandlerType handlerType) {
        switch (handlerType) {
            case APPLICATION_SAVE:
                return saveApplicationHandler;
            case KKB_CALCULATE:
                return kkbCalculateHandler;
            case DECIDE:
                return decideCreditHandler;

            default:
                throw new IllegalArgumentException("Invalid handler type: " + handlerType.toString());
        }
    }
}