package com.fandos.library.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOutDto {
    private long id;
    private String name;
    private String email;
    private LocalDate registerDate;
    private boolean partner;
}
