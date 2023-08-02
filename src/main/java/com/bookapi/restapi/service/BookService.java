package com.bookapi.restapi.service;

// import java.util.ArrayList;
// import java.util.stream.Collector;
// import java.util.stream.Collectors;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapi.restapi.entities.Book;
import com.bookapi.restapi.repository.UserRepository;

@Service
public class BookService {
    

    // //Fake service without database
    // public static List<Book> books = new ArrayList<>();
    // static
    // {
    //     books.add(new Book(11,"book1","author1"));
    //     books.add(new Book(12,"book2","author2"));
    //     books.add(new Book(13,"book3","author3"));
    // }
    @Autowired
    UserRepository userRepository;

    public Book getBookById(int id)
    {
        Book book = null;
        try{
            //book = books.stream().filter(e->e.getId()==id).findFirst().get();
            book=userRepository.findById(id);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return book;

    }

    public List<Book> getAllBooks()
    {
        //return books;
        List<Book> books =(List<Book>) userRepository.findAll();
        return books;
    }

    public Book addBook(Book book)
    {
        //books.add(book);
        Book result = userRepository.save(book);
        return result;
    }

    public void deleteBook(int id)
    {
        //books=books.stream().filter(book->book.getId()!=id).collect(Collectors.toList());
        userRepository.deleteById(id);
    }

    public void updateBook(int id,Book book)
    {
        // books = books.stream().map(b->{
        //     if(b.getId()==id)
        //     {
        //         b.setAuthor(book.getAuthor());
        //         b.setTitle(book.getTitle());
        //     }
        //     return b;
        // }).collect(Collectors.toList());

        //if id doesnot match with book->id
        book.setId(id);
        userRepository.save(book);
    }
}
