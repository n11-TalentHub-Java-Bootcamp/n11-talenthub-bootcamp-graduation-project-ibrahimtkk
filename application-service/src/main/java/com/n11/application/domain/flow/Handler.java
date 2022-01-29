package com.n11.application.domain.flow;


import com.n11.application.domain.ApplicationBox;
import com.n11.application.interfaces.ApiError;
import org.springframework.http.ResponseEntity;

public interface Handler {

    void setSuccessor(Handler successor);

    ResponseEntity<ApiError> handle(ApplicationBox applicationBox);
}
