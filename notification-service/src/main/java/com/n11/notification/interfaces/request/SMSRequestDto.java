package com.n11.notification.interfaces.request;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.ObjectUtils;

import java.util.Map;

@Getter
@Setter
public class SMSRequestDto{

    @Expose
    private String text;

    @Expose
    private String phoneNumber;

    @Expose
    private String citizenId;

    @Expose
    private String applicationId;

}
