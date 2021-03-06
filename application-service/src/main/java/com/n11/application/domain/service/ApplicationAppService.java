package com.n11.application.domain.service;

import com.n11.application.interfaces.request.ApplicationRequestDto;
import com.n11.application.interfaces.request.DeleteApplicationRequestDto;
import com.n11.application.interfaces.request.ModifyApplicationRequestDto;
import com.n11.application.interfaces.response.ApplicationResponseDto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface ApplicationAppService {

    ApplicationResponseDto initiate(ApplicationRequestDto applicationRequestDto);

    ApplicationResponseDto modify(ModifyApplicationRequestDto applicationRequestDto);

    ApplicationResponseDto delete(DeleteApplicationRequestDto applicationRequestDto);

    ApplicationResponseDto query(String tckn, String birthdate);
}
