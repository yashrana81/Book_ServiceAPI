package com.bookapi.restapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bookapi.restapi.entities.Book;

@Service
public class BookService {
    

    //Fake service without database
    public static List<Book> books = new ArrayList<>();
    static
    {
        books.add(new Book(11,"book1","author1"));
        books.add(new Book(12,"book2","author2"));
        books.add(new Book(13,"book3","author3"));
    }

    public Book getBookById(int id)
    {
        Book result;
        result = books.stream().filter(e->e.getId()==id).findFirst().get();
        return result;
    }

    public List<Book> getAllBooks()
    {
        return books;
    }

    public Book addBook(Book book)
    {
        books.add(book);
        return book;
    }

    public void deleteBook(int id)
    {
        books=books.stream().filter(book->book.getId()!=id).collect(Collectors.toList());
    }
}
