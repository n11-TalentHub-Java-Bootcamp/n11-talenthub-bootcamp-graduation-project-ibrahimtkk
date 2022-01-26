package com.n11.application.infrastructure.user;

import com.n11.application.infrastructure.exception.GatewayException;
import com.n11.application.interfaces.request.ApplicationRequestDto;
import com.n11.application.interfaces.response.ApplicationResponseDto;
import io.vavr.control.Either;

public interface UserService {
    Either<GatewayException, ApplicationResponseDto> save(ApplicationRequestDto applicationRequestDto);
}
