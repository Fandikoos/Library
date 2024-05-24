package com.fandos.library.repository;

import com.fandos.library.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRespository extends CrudRepository<Author, Long> {
    List<Author> findAll();
}
