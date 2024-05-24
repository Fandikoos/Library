package com.fandos.library.controller;

import com.fandos.library.domain.Author;
import com.fandos.library.dto.AuthorInDto;
import com.fandos.library.dto.AuthorOutDto;
import com.fandos.library.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAll(){
        return new ResponseEntity<>(authorService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/authors")
    public ResponseEntity<AuthorOutDto> saveAuthor(@Valid @RequestBody AuthorInDto author){
        // Creamos un OutDto que contendra Id y recogemos el InDto con el resto de información
        AuthorOutDto newAuthor = authorService.saveAuthor(author);
        // Devolvemos esta información
        return new ResponseEntity<>(newAuthor, HttpStatus.CREATED);
    }

    @DeleteMapping("/author/{authorId}")
    public ResponseEntity<Void> removeAuthor (@PathVariable long authorId){
        authorService.removeAuthor(authorId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/author/{authorId}")
    public ResponseEntity<Author> modifyAuthor(@Valid @RequestBody Author actualAuthor, @PathVariable long authorId){
        Author updateAuthor = authorService.modifyAuthor(actualAuthor, authorId);
        return new ResponseEntity<>(updateAuthor, HttpStatus.OK);
    }
}
