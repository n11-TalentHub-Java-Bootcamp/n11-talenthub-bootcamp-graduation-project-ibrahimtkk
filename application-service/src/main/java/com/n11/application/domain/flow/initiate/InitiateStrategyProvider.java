package com.n11.application.domain.flow.initiate;

import com.n11.application.domain.CreditType;
import org.springframework.stereotype.Service;

@Service
public interface InitiateStrategyProvider {

    InitiateStrategy provide(CreditType creditType);
}
