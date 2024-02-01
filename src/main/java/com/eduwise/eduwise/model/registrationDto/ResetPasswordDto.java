package com.eduwise.eduwise.model.registrationDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResetPasswordDto {
    @NotBlank
    @Email
    private String username;

    @NotBlank
    private String otpCode;

    @NotBlank
    private String password;

    @NotBlank
    private String confirmPassword;
}
