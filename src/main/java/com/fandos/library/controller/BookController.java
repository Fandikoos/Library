package com.fandos.library.controller;

import com.fandos.library.domain.Book;
import com.fandos.library.dto.BookInDto;
import com.fandos.library.dto.BookOutDto;
import com.fandos.library.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAll(){
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/books/genre/{genre}")
    public ResponseEntity<List<Book>> getByGenre(@PathVariable String genre){
        return new ResponseEntity<>(bookService.findByGenre(genre), HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<BookOutDto> saveBook(@Valid @RequestBody BookInDto bookInDto){
        BookOutDto newBook = bookService.saveBook(bookInDto);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @DeleteMapping("/book/{bookId}")
    public ResponseEntity<Void> removeBook(@PathVariable long bookId){
        bookService.removeBook(bookId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/book/{bookId}")
    public ResponseEntity<Book> modifyBook(@Valid @RequestBody Book actualBook, @PathVariable long bookId){
        Book updateBook = bookService.modifyBook(actualBook, bookId);
        return new ResponseEntity<>(updateBook, HttpStatus.OK);

    }
}
