package com.n11.application.domain.flow.initiate;

import com.n11.application.domain.ApplicationBox;
import com.n11.application.interfaces.request.DeleteApplicationRequestDto;

public interface InitiateStrategy {

    void initiate(ApplicationBox applicationBox);

    void modify(ApplicationBox applicationBox);

    void delete(ApplicationBox applicationBox);

    void query(ApplicationBox applicationBox);
}
