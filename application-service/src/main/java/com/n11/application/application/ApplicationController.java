package com.n11.application.application;

import com.n11.application.application.validation.ApplicationRequestValidationService;
import com.n11.application.application.validation.ValidationResult;
import com.n11.application.domain.service.ApplicationAppService;
import com.n11.application.interfaces.ApiError;
import com.n11.application.interfaces.request.ApplicationRequestDto;
import com.n11.application.interfaces.response.ApplicationResponseDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    private ApplicationAppService applicationAppService;

    @Autowired
    private ApplicationRequestValidationService applicationRequestValidationService;

    // Girilen bilgilere göre sonucu, kkbscore'unu ve limiti döndürür
    @PostMapping("/initiate")
    public ResponseEntity initiate(@RequestBody ApplicationRequestDto applicationRequestDto) {

        final ValidationResult validationResult = applicationRequestValidationService.validate(applicationRequestDto);
        if (!validationResult.getIsValid()) {
            log.warn(validationResult.getMessage());
            return new ResponseEntity<>(ApiError.create(HttpStatus.BAD_REQUEST.value(), validationResult.getMessage(), validationResult.getErrorCode().code()), HttpStatus.BAD_REQUEST);
        }

        final ApplicationResponseDto applicationResponseDto = applicationAppService.initiate(applicationRequestDto);

        return new ResponseEntity<>(applicationResponseDto, HttpStatus.CREATED);
    }
}
