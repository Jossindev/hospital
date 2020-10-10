package com.example.hospital.service;

import com.example.hospital.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface SignService extends UserDetailsService {
    void signUp(UserDto userDto);
}
