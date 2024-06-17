package com.fandos.library.service;

import com.fandos.library.domain.Book;
import com.fandos.library.dto.BookInDto;
import com.fandos.library.dto.BookOutDto;
import com.fandos.library.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public List<Book> findByGenre(String genre){
        return bookRepository.findByGenre(genre);
    }

    public BookOutDto saveBook (BookInDto bookInDto){
        Book book = new Book();
        modelMapper.map(bookInDto, book);
        // Guardamos el libro en la bbdd
        Book newBook = bookRepository.save(book);

        //Esto es solamente pare devolver la respuesta en Postman
        // Mapeamos el nombre del autor al DTO de salida
        BookOutDto bookOutDto = modelMapper.map(newBook, BookOutDto.class);
        bookOutDto.setAuthorId(newBook.getAuthor().getId());
        return bookOutDto;
    }

    public void removeBook(long bookId){
        Book book = bookRepository.findById(bookId).orElseThrow();
        bookRepository.delete(book);
    }

    public Book modifyBook (Book actualBook, long bookId){
        Optional<Book> book = bookRepository.findById(bookId);
        if (book.isPresent()){
            Book existingBook = book.get();
            existingBook.setTitle(actualBook.getTitle());
            existingBook.setGenre(actualBook.getGenre());
            existingBook.setPublicationDate(actualBook.getPublicationDate());
            existingBook.setNumberOfPages(actualBook.getNumberOfPages());
            existingBook.setInStock(actualBook.isInStock());
            existingBook.setAuthor(actualBook.getAuthor());
            return bookRepository.save(existingBook);
        } else {
            throw new RuntimeException("Book not found");
        }
    }
}
