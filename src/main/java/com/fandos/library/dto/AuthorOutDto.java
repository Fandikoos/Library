package com.fandos.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

// Lo que te devuelve cuando insertas datos, el id que es automatico y la lista de libros
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorOutDto {

    private long id;
    private String name;
    private String nationality;
    private LocalDate bornDate;
    private String biography;
    private boolean active;
    private List<String> bookTitles; // O List<BookDto> si prefieres incluir detalles de los libros
}
