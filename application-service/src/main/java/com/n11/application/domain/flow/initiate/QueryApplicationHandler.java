package com.n11.application.domain.flow.initiate;

import com.n11.application.domain.ApplicationBox;
import com.n11.application.domain.UserInfo;
import com.n11.application.domain.flow.Handler;
import com.n11.application.infrastructure.acl.entity.Application;
import com.n11.application.infrastructure.acl.repository.ApplicationRepository;
import com.n11.application.interfaces.ApiError;
import com.n11.application.interfaces.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class QueryApplicationHandler implements Handler {

    @Autowired
    ApplicationRepository applicationRepository;

    private Handler successor;

    @Override
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    @Override
    public ResponseEntity<ApiError> handle(ApplicationBox applicationBox) {

        log.info("Application query started..");

        final List<Application> applicationList = applicationRepository.findByTCKNAndBirthdate(applicationBox.getUserInfo().getTCKN(), applicationBox.getUserInfo().getBirthdate());
        if (applicationList == null) {
            log.debug("Could not found that application");
            return new ResponseEntity<>(ApiError.create(HttpStatus.BAD_REQUEST.value(), "Could not found that application", ErrorCode.APPLICATIONNOTFOUND.code()), HttpStatus.BAD_REQUEST);
        }

        final Application application = applicationList.get(applicationList.size()-1);
        UserInfo userInfo = new UserInfo();
        userInfo.setBirthdate(application.getBirthdate());
        userInfo.setTCKN(application.getTCKN());
        userInfo.setAssurance(application.getAssurance());
        userInfo.setIncome(application.getIncome());
        userInfo.setName(application.getName());
        userInfo.setSurname(application.getSurname());
        userInfo.setPhone(application.getPhone());
        applicationBox.setUserInfo(userInfo);
        applicationBox.setLimit(application.getLimit());
        applicationBox.setResult(application.getResult());
        applicationBox.setKkbScore(application.getKkbScore());

        if (this.successor != null) this.successor.handle(applicationBox);
        return null;
    }
}
