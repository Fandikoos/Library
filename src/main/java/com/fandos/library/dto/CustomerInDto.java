package com.fandos.library.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerInDto {
    @NotNull(message = "Es obligatorio el nombre del cliente")
    private String name;
    @Email
    private String email;
    private LocalDate registerDate;
    private boolean partner;
}

