package com.fandos.library.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

// Clase In para cuando ingresamos los datos
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorInDto {
    @NotNull(message = "Es obligatorio establecer el nombre")
    private String name;
    @Size(message = "Como máximo puede haber 40 carácteres", min = 0, max = 40)
    private String nationality;
    @NotNull(message = "Es obligatorio establecer el nombre")
    private LocalDate bornDate;
    private String biography;
    private boolean active;

}
