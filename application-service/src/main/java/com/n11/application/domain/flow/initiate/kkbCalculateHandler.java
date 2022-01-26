package com.n11.application.domain.flow.initiate;

import com.n11.application.domain.ApplicationBox;
import com.n11.application.domain.flow.Handler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service
public class kkbCalculateHandler implements Handler {

    private Handler successor;

    @Override
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    @Override
    public void handle(ApplicationBox applicationBox) {

        Random random = new Random();
        int minScore = 200;
        int maxScore = 1800;
        Integer kkbScore = random.nextInt(maxScore-minScore) + minScore;
        applicationBox.setKkbScore(kkbScore);

        if (this.successor != null) this.successor.handle(applicationBox);
    }
}
