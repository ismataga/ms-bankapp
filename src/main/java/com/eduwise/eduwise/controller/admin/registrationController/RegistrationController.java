package com.eduwise.eduwise.controller.admin.registrationController;

import com.eduwise.eduwise.model.registrationDto.RegistrationDTO;
import com.eduwise.eduwise.service.registrationService.RegistrationService;
import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/registration")
public class RegistrationController {
    private final RegistrationService registrationService;



    @PostMapping
    @PreAuthorize("permitAll()")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@Valid @RequestBody RegistrationDTO dto){

        registrationService.register(dto);
    }

    @GetMapping("/confirmation/{uuid}")
    public void confirmation(@PathVariable UUID uuid){
        registrationService.confirm(uuid);

    }

}
