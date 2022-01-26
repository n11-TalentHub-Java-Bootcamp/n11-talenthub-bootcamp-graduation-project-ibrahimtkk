package com.n11.application.domain.flow.initiate;

import com.n11.application.domain.ApplicationBox;
import com.n11.application.domain.flow.Handler;
import com.n11.application.infrastructure.acl.entity.Application;
import com.n11.application.infrastructure.acl.repository.ApplicationRepository;
import com.n11.application.infrastructure.mapper.ApplicationMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SaveApplicationHandler implements Handler {

    @Autowired
    ApplicationRepository applicationRepository;

    private Handler successor;

    @Override
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    @Override
    public void handle(ApplicationBox applicationBox) {

        log.info("Application creation started..");

        ApplicationMapper applicationMapper = new ApplicationMapper();
        Application application = applicationMapper.toApplicationEntityFromUserInfos(applicationBox);
        applicationRepository.save(application);

        if (this.successor != null) this.successor.handle(applicationBox);
    }
}
