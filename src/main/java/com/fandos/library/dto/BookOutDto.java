package com.fandos.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

// Clase para enviar datos de repsuesta al Postman normalmente, debe contener id y authorId y la informaciónd e los libros
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookOutDto {
    private long id;
    private String title;
    private String genre;
    private LocalDate publicationDate;
    private Long authorId;  // Para mostrar el nombre del autor en la respuesta
}
