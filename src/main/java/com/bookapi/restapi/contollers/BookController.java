package com.bookapi.restapi.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    private BookService bookService;
    
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id)
    {
        Book book = bookService.getBookById(id);
        if(book == null)
        {
            return ResponseEntity.noContent().build();
        }
        else
        {
            return ResponseEntity.ok(book);
        }
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks()
    {
        List<Book> booksList = bookService.getAllBooks();
        if(booksList.size()<=0)
        {
            return ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok(booksList);
        }
    }

    @PostMapping("/books")
    public ResponseEntity<Book> postBook(@RequestBody Book book)
    {
        Book b = null;
        try{
            b = bookService.addBook(book);
            return ResponseEntity.ok(b);
        }catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("books/{bookId}")
    public ResponseEntity<Void> deleteBookbyId(@PathVariable("bookId") int bid)
    {
        try{
            bookService.deleteBook(bid);
            return ResponseEntity.noContent().build();
        }catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("books/{bookId}")
    public ResponseEntity<Book> updateBookbyId(@PathVariable("bookId") int bid,@RequestBody Book book)
    {
       try{
            bookService.updateBook(bid, book);
            return ResponseEntity.ok(book);
        }catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}