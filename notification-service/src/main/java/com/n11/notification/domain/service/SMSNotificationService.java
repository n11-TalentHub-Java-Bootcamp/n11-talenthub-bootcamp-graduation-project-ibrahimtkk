package com.n11.notification.domain.service;

import com.n11.notification.infrastructure.entity.Sms;
import com.n11.notification.infrastructure.repository.SMSRepository;
import com.n11.notification.interfaces.request.SMSRequestDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Slf4j
public class SMSNotificationService implements NotificationService<SMSRequestDto, Sms> {

    private final SMSRepository smsRepository;

    @Override
    public Sms send(SMSRequestDto smsRequest) {

        final String smsContent = "Krediniz onaylanmıştır";

        final Sms sms = new Sms();
        sms.setPhoneNumber(smsRequest.getPhoneNumber());
        sms.setText(smsContent);
        sms.setApplicationId(smsRequest.getApplicationId());
        sms.setInsertDate(LocalDateTime.now());

        // TODO: burada sms gönderme servisi çağırılacak

        return smsRepository.save(sms);
    }
}
