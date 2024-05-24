package com.fandos.library.service;

import com.fandos.library.domain.Author;
import com.fandos.library.domain.Customer;
import com.fandos.library.dto.AuthorInDto;
import com.fandos.library.dto.AuthorOutDto;
import com.fandos.library.dto.CustomerOutDto;
import com.fandos.library.repository.AuthorRespository;
import com.fandos.library.repository.CustomerRespository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRespository authorRespository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Author> findAll(){
        return authorRespository.findAll();
    }

    // Devolvemos un objeto OutDto y tenemos un InDto de entrada
    public AuthorOutDto saveAuthor(AuthorInDto authorInDto){
        Author author = new Author();
        // Mapeamos los campos de AuthorInDto al objeto author, se los pasamos digamos, model mapper
        // se encarga de copiar estos valores
        // Tenemos el id automatico dentro del author por lo que lo coge de ahí que es incrementable, lo mismo pasaría con fechas...
        modelMapper.map(authorInDto, author);
        // Creamos un newAuthor que contiene los datos del InDto y lo guardamos en el repository
        // Guaradmos este objeto en la bbdd con el .save y el resultado se almacena en newAuthor
        Author newAuthor = authorRespository.save(author);

        // Creamos un OutDto para devolver una respuesta, en el Postman por ejemplo
        AuthorOutDto authorOutDto = new AuthorOutDto();
        // Mapemaos los atributos del newAuthor en nuestro AuthorDto para la respuesta
        modelMapper.map(newAuthor, authorOutDto);

        // Devolvemos el dto con todos los datos del author para enviarlo a través de Postman por ejemplo
        return authorOutDto;
    }

    public void removeAuthor (long authorId){
        Author author = authorRespository.findById(authorId).orElseThrow();
        authorRespository.delete(author);
    }

    public Author modifyAuthor(Author actualAuthor, long authorId){
        Optional<Author> author = authorRespository.findById(authorId);
        if (author.isPresent()) {
            Author existingAuthor = author.get();
            existingAuthor.setName(actualAuthor.getName());
            existingAuthor.setNationality(actualAuthor.getNationality());
            existingAuthor.setBiography(actualAuthor.getBiography());
            return authorRespository.save(existingAuthor);
        } else {
            throw new RuntimeException("Customer not found");
        }
    }


}
