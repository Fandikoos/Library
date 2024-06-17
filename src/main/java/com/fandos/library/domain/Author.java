package com.fandos.library.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;
    @Column
    private String nationality;
    @Column
    private LocalDate bornDate;
    @Column
    private String biography;
    @Column
    private boolean active;


    @OneToMany(mappedBy = "author")
    // Para que no se haga un bucle infitio en la respuesta como en Postman
    @JsonManagedReference
    private List<Book> books;
}
