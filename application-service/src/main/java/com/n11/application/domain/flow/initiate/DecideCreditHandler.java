package com.n11.application.domain.flow.initiate;

import com.n11.application.domain.ApplicationBox;
import com.n11.application.domain.flow.Handler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import static com.n11.application.domain.Constants.*;

@Slf4j
@Service
public class DecideCreditHandler implements Handler {

    private Handler successor;

    @Override
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    @Override
    public void handle(ApplicationBox applicationBox) {

        log.info("Decide credit handler started..");
        if (applicationBox.getKkbScore() < minKKBScore) {
            applicationBox.setResult("Red");
        }
        else if (applicationBox.getKkbScore() > minKKBScore && applicationBox.getKkbScore() < midKKBScore) {
            if (applicationBox.getUserInfo().getIncome() < minUserAmount) {
                applicationBox.setResult("Onay");
                applicationBox.setLimit(10000);
            }
            else if (applicationBox.getUserInfo().getIncome() > minUserAmount && applicationBox.getUserInfo().getIncome() < maxUserAmount) {
                applicationBox.setResult("Onay");
                applicationBox.setLimit(20000);
            }
            else {
                applicationBox.setResult("Onay");
                applicationBox.setLimit(applicationBox.getUserInfo().getIncome() * creditMultiplier / 2);
            }
        }
        else {
            applicationBox.setResult("Onay");
            applicationBox.setLimit(applicationBox.getUserInfo().getIncome() * creditMultiplier);
        }


        if (this.successor != null) this.successor.handle(applicationBox);
    }
}
