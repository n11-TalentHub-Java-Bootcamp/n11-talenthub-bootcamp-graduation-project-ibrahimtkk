package com.n11.application.domain.flow;


import com.n11.application.domain.ApplicationBox;

public interface Handler {

    void setSuccessor(Handler successor);

    void handle(ApplicationBox applicationBox);
}
