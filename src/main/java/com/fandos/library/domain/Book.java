package com.fandos.library.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String title;
    @Column
    private String genre;
    @Column
    private LocalDate publicationDate;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    // Para que no se haga un bucle infinito en Postman
    @JsonBackReference
    private Author author;

}
