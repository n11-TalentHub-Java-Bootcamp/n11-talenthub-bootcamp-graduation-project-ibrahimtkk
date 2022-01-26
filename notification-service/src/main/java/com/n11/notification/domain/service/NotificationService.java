package com.n11.notification.domain.service;

import org.springframework.stereotype.Service;

@Service
public interface NotificationService<R1, R2> {

    R2 send(R1 request);
}
