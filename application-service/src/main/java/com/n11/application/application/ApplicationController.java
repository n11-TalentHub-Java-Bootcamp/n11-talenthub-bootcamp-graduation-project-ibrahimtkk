package com.n11.application.application;

import com.n11.application.application.validation.ApplicationRequestValidationService;
import com.n11.application.application.validation.DeleteApplicationRequestValidationService;
import com.n11.application.application.validation.ModifyApplicationRequestValidationService;
import com.n11.application.application.validation.ValidationResult;
import com.n11.application.domain.service.ApplicationAppService;
import com.n11.application.interfaces.ApiError;
import com.n11.application.interfaces.request.ApplicationRequestDto;
import com.n11.application.interfaces.request.DeleteApplicationRequestDto;
import com.n11.application.interfaces.request.ModifyApplicationRequestDto;
import com.n11.application.interfaces.response.ApplicationResponseDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    private ApplicationAppService applicationAppService;

    @Autowired
    private ApplicationRequestValidationService applicationRequestValidationService;

    @Autowired
    private ModifyApplicationRequestValidationService modifyApplicationRequestValidationService;

    @Autowired
    private DeleteApplicationRequestValidationService deleteApplicationRequestValidationService;
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

    @PostMapping("/modify")
    public ResponseEntity modify(@RequestBody ModifyApplicationRequestDto modifyApplicationRequestDto) {
        final ValidationResult validationResult = modifyApplicationRequestValidationService.validate(modifyApplicationRequestDto);
        if (!validationResult.getIsValid()) {
            log.warn(validationResult.getMessage());
            return new ResponseEntity<>(ApiError.create(HttpStatus.BAD_REQUEST.value(), validationResult.getMessage(), validationResult.getErrorCode().code()), HttpStatus.BAD_REQUEST);
        }
        final ApplicationResponseDto applicationResponseDto = applicationAppService.modify(modifyApplicationRequestDto);

        return new ResponseEntity<>(applicationResponseDto, HttpStatus.CREATED);
    }

    @DeleteMapping()
    public ResponseEntity delete(@RequestBody DeleteApplicationRequestDto deleteApplicationRequestDto) {
        final ValidationResult validationResult = deleteApplicationRequestValidationService.validate(deleteApplicationRequestDto);
        if (!validationResult.getIsValid()) {
            log.warn(validationResult.getMessage());
            return new ResponseEntity<>(ApiError.create(HttpStatus.BAD_REQUEST.value(), validationResult.getMessage(), validationResult.getErrorCode().code()), HttpStatus.BAD_REQUEST);
        }
        final ApplicationResponseDto applicationResponseDto = applicationAppService.delete(deleteApplicationRequestDto);

        return new ResponseEntity<>(applicationResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{tckn}/{birthdate}")
    public ResponseEntity query(@PathVariable String tckn, @PathVariable String birthdate) {

        final ApplicationResponseDto applicationResponseDto = applicationAppService.query(tckn, birthdate);

        return new ResponseEntity<>(applicationResponseDto, HttpStatus.CREATED);
    }
}
