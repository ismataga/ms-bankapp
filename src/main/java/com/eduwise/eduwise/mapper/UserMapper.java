package com.eduwise.eduwise.mapper;

import com.eduwise.eduwise.entity.User;
import com.eduwise.eduwise.model.registrationDto.RegistrationDTO;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(componentModel = "spring",imports = UUID.class)
public abstract class UserMapper{

    @Lazy
    @Autowired
    protected PasswordEncoder encoder;
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "enabled", constant = "false")
    @Mapping(target = "accountNonExpired", constant = "true")
    @Mapping(target = "accountNonLocked", constant = "true")
    @Mapping(target = "credentialsNonExpired", constant = "true")
    @Mapping(target = "password", expression = "java(encoder.encode(dto.getPassword()))")
    @Mapping(target = "uuid", expression = "java(UUID.randomUUID())")
    public abstract User toEntity(RegistrationDTO dto);
}
