package com.n11.application.domain.service.kkb;

import com.n11.application.interfaces.request.ApplicationRequestDto;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class KKBService {

    public Integer generateKKBScore(ApplicationRequestDto applicationRequestDto) {
        Random random = new Random();
        int minScore = 200;
        int maxScore = 1800;
        return random.nextInt(maxScore-minScore) + minScore;
    }
}
