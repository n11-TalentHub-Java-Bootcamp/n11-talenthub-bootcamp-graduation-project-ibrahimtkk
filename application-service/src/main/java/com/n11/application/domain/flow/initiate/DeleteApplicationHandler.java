package com.n11.application.domain.flow.initiate;

import com.n11.application.domain.ApplicationBox;
import com.n11.application.domain.flow.Handler;
import com.n11.application.infrastructure.acl.entity.Application;
import com.n11.application.infrastructure.acl.repository.ApplicationRepository;
import com.n11.application.interfaces.ApiError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class DeleteApplicationHandler implements Handler {

    @Autowired
    ApplicationRepository applicationRepository;

    private Handler successor;

    @Override
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    @Override
    public ResponseEntity<ApiError> handle(ApplicationBox applicationBox) {

        log.info("Application deletion started..");

        final List<Application> applicationList = applicationRepository.findByTCKNAndBirthdate(applicationBox.getUserInfo().getTCKN(), applicationBox.getUserInfo().getBirthdate());
        if (applicationList == null) {
            log.debug("Could not found that application");
            return null;
        }

        applicationRepository.deleteAll(applicationList);

        if (this.successor != null) this.successor.handle(applicationBox);
        return null;
    }
}
