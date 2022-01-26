package com.n11.application.infrastructure.user;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.n11.application.infrastructure.exception.GatewayException;
import com.n11.application.infrastructure.serializer.EpochToDateDeserializer;
import com.n11.application.interfaces.request.ApplicationRequestDto;
import com.n11.application.interfaces.response.ApplicationResponseDto;
import io.vavr.control.Either;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class UserServiceGateway implements UserService{

    private final Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new EpochToDateDeserializer()).serializeNulls().create();
    private final RestTemplate restTemplate;
    private final UserServiceGatewayConfiguration userServiceGatewayConfiguration;


    public UserServiceGateway(RestTemplate restTemplate, UserServiceGatewayConfiguration userServiceGatewayConfiguration) {
        this.restTemplate = restTemplate;
        this.userServiceGatewayConfiguration = userServiceGatewayConfiguration;
    }


    @Override
    public Either<GatewayException, ApplicationResponseDto> save(ApplicationRequestDto applicationRequestDto) {

        return CompletableFuture
                .supplyAsync(() -> restTemplate.exchange(getUrlV2(), HttpMethod.POST, new HttpEntity<>(applicationRequestDto), new ParameterizedTypeReference<ApplicationResponseDto>() {
                }))
                .<Either<GatewayException, ApplicationResponseDto>>thenApply(resp -> {
                    log.info("product service search called");
                    return Either.right(resp.getBody());
                })
                .exceptionally(ex -> Either.left(new GatewayException(UserServiceGateway.class.getName(), ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value())))
                .join();

    }

    // TODO: conf altına taşınacak
    private String getUrlV2() {
        return "http://localhost:7002";
    }
}
