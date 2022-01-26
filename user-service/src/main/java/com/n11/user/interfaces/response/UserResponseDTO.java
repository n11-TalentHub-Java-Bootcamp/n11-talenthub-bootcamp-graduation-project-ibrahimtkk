package com.n11.user.interfaces.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserResponseDTO {

    private String name;
    private String surname;
    private String TCKN;

}
