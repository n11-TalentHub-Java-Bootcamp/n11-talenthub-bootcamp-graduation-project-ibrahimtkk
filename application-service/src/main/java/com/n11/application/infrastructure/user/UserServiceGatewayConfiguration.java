package com.n11.application.infrastructure.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("user-service")
@Getter
@Setter
public class UserServiceGatewayConfiguration {

    @Value("url")
    private String URL;
}
