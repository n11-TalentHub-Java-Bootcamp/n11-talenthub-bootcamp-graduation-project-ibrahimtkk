package com.n11.notification.application;

import com.n11.notification.domain.service.NotificationService;
import com.n11.notification.infrastructure.entity.Sms;
import com.n11.notification.interfaces.request.SMSRequestDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@Slf4j
@RequestMapping("/notification")
public class NotificationController {

    // TODO: bunu SMSNotificationService'ten annote et
    private final NotificationService<SMSRequestDto, Sms> smsNotificationService;


    @PostMapping(path = "/sms")
    public ResponseEntity<Sms> addSMS(@RequestBody SMSRequestDto smsRequestDto) {

        final Sms sms = smsNotificationService.send(smsRequestDto);
        return new ResponseEntity<>(sms, HttpStatus.CREATED);
    }
}
