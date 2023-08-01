package com.bookapi.restapi.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookapi.restapi.entities.Book;
import com.bookapi.restapi.service.BookService;

@RestController
public class BookController {

    @Autowired
    BookService bookService;
    
    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int id)
    {
        return bookService.getBookById(id);
    }

    @GetMapping("/books")
    public List<Book> getBooks()
    {
        return bookService.getAllBooks();
    }

    @PostMapping("/books")
    public Book postBook(@RequestBody Book book)
    {
        Book b = bookService.addBook(book);
        return b;
    }

    @DeleteMapping("books/{bookId}")
    public void deleteBookbyId(@PathVariable("bookId") int bid)
    {
        this.bookService.deleteBook(bid);
    }

    @PutMapping("books/{bookId}")
    public Book updateBookbyId(@PathVariable("bookId") int bid,@RequestBody Book book)
    {
        bookService.updateBook(bid,book);
        return book;
    }
}