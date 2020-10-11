package com.example.hospital.service;


import org.springframework.security.core.userdetails.UserDetailsService;

import java.time.LocalDate;

public interface SignService extends UserDetailsService {
    public void signUp(String name, String surname, LocalDate birthday, String email, String password, String role);
}
