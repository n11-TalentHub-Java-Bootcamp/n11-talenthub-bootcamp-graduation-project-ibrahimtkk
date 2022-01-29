package com.n11.application.domain.flow.initiate;

import com.n11.application.domain.ApplicationBox;
import com.n11.application.domain.flow.Handler;
import com.n11.application.interfaces.ApiError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.n11.application.domain.Constants.*;

@Slf4j
@Service
public class AssuranceHandler implements Handler {

    private Handler successor;

    @Override
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    @Override
    public ResponseEntity<ApiError> handle(ApplicationBox applicationBox) {

        log.info("Assurance handler started..");
        if (applicationBox.getUserInfo().getAssurance() != null) {
            final Double applicationLimit = applicationBox.getLimit();
            if (applicationBox.getKkbScore() > minKKBScore && applicationBox.getKkbScore() < midKKBScore) {
                if (applicationBox.getUserInfo().getIncome() < minUserAmount) {
                    applicationBox.setLimit(applicationLimit + applicationBox.getUserInfo().getAssurance() * 1.1 );
                } else if (applicationBox.getUserInfo().getIncome() > minUserAmount && applicationBox.getUserInfo().getIncome() < maxUserAmount) {
                    applicationBox.setLimit(applicationLimit + applicationBox.getUserInfo().getAssurance() * 1.2 );
                } else {
                    applicationBox.setLimit(applicationLimit + applicationBox.getUserInfo().getAssurance() * 1.25 );
                }
            }
            else if (applicationBox.getKkbScore() > midKKBScore) {
                applicationBox.setLimit(applicationLimit + applicationBox.getUserInfo().getAssurance() * 1.5 );
            }
        }


        if (this.successor != null) this.successor.handle(applicationBox);
        return null;
    }
}
