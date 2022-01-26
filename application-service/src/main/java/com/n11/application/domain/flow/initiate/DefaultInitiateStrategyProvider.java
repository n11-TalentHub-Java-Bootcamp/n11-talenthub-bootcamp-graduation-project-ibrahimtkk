package com.n11.application.domain.flow.initiate;


import com.n11.application.domain.InitiateType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class DefaultInitiateStrategyProvider implements InitiateStrategyProvider {

    @Autowired
    private InitiatePersonalCredit initiatePersonalCredit;

    @Autowired
    private InitiateCommercialCredit initiateCommercialCredit;

    @Override
    public InitiateStrategy provide(InitiateType initiateType) {
        switch (initiateType) {
            case PERSONALCREDIT:
                return initiatePersonalCredit;
            case COMMERCIALCREDIT:
                return initiateCommercialCredit;
            default:
                throw new IllegalArgumentException();
        }
    }
}
