package com.fandos.library.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

// Debemos incluir referencia al authorId para establecer la relación con el author
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookInDto {
    @NotNull(message = "El título es obligatorio")
    private String title;

    @NotNull(message = "El género es obligatorio")
    private String genre;

    @NotNull(message = "La fecha de publicación es obligatoria")
    private LocalDate publicationDate;

    @NotNull(message = "El ID del autor es obligatorio")
    private Long authorId;
}
