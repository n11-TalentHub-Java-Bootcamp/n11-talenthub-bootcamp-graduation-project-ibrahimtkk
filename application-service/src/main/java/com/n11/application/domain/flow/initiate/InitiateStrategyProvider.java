package com.n11.application.domain.flow.initiate;

import com.n11.application.domain.InitiateType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface InitiateStrategyProvider {

    InitiateStrategy provide(InitiateType initiateType);
}
