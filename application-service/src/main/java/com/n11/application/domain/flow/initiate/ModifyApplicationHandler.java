package com.n11.application.domain.flow.initiate;

import com.n11.application.domain.ApplicationBox;
import com.n11.application.domain.flow.Handler;
import com.n11.application.infrastructure.acl.entity.Application;
import com.n11.application.infrastructure.acl.repository.ApplicationRepository;
import com.n11.application.interfaces.ApiError;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ModifyApplicationHandler implements Handler {

    @Autowired
    ApplicationRepository applicationRepository;

    private Handler successor;

    @Override
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    @Override
    public ResponseEntity<ApiError> handle(ApplicationBox applicationBox) {

        log.info("Application creation started..");

        final List<Application> applicationList = applicationRepository.findByTCKNAndBirthdate(applicationBox.getUserInfo().getTCKN(), applicationBox.getUserInfo().getBirthdate());
        if (applicationList == null) {
            log.debug("Could not found that application");
            return null;
        }

        final Application application = applicationList.get(applicationList.size() -1);

        applicationBox.setKkbScore(application.getKkbScore());
        applicationBox.setLimit(application.getLimit());
        applicationBox.setResult(application.getResult());

        if (applicationBox.getUserInfo().getIncome() != null) {
            application.setIncome(applicationBox.getUserInfo().getIncome());
        }
        if (applicationBox.getUserInfo().getAssurance() != null) {
            application.setAssurance(applicationBox.getUserInfo().getAssurance());
        }
        if (!StringUtils.isBlank(applicationBox.getUserInfo().getPhone())) {
            application.setPhone(applicationBox.getUserInfo().getPhone());
        }
        applicationRepository.save(application);

        if (this.successor != null) this.successor.handle(applicationBox);
        return null;
    }
}
