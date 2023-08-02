package com.bookapi.restapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookapi.restapi.entities.Book;

@Repository
public interface UserRepository extends CrudRepository<Book,Integer>{
    
    public Book findById(int id);
}
