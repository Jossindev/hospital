package com.example.hospital.dto;

import com.example.hospital.entity.User;
import com.example.hospital.validation.annotation.Password;
import com.example.hospital.validation.annotation.UniqueEmail;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UserDto {


    @NotBlank(message = "field name can`t be blank")
    private String name;

    private String surname;

    @Email(message = "email is not valid")
    @UniqueEmail
    @NotBlank(message = "field email can`t be blank")
    private String email;

    @Password
    private String password;

    private byte[] photo;

    public User toUser() {
        User user = new User();
        user.setPassword(password);
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        return user;
    }

}