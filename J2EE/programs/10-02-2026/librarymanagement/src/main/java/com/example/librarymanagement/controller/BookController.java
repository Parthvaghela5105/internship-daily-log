package com.example.librarymanagement.controller;

import com.example.librarymanagement.proxy.Book;
import com.example.librarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping()
    public String saveBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @GetMapping()
    public List<Book> getAllBooks(){
        return bookService.getAllBook();
    }

    @GetMapping(value = "/{id}")
    public Book getById(@PathVariable Long id){
        return bookService.getBookById(id);
    }

    @DeleteMapping(value = "/{id}")
    public String removeBookById(@PathVariable Long id){
        return bookService.removeBook(id);
    }

    @PutMapping(value = "/{id}")
    public String updateBook(@PathVariable Long id , @RequestBody Book book){
        return bookService.updateBook(id , book);
    }

    @GetMapping(value="search/title/{title}")
    public List<Book> getBookByTitle(@PathVariable String title){
        return bookService.getBookByTitle(title);
    }

    @GetMapping(value="search/author/{author}")
    public List<Book> getBookByAuthor(@PathVariable String author){
        return bookService.getBookByAuthor(author);
    }

    @GetMapping(value = "/count")
    public Long getBooksCount(){
        return bookService.countBooks();
    }

    @GetMapping(value = "sort/price")
    public List<Book> sortedByPrice(){
        return bookService.sortBookByPrice();
    }

    @PostMapping(value = "/bulk")
    public String addBulkBooks(@RequestBody List<Book> books){
        return bookService.addBulkBook(books);
    }

    @DeleteMapping(value = "/delete-all")
    public String removeAllBooks(){
        return bookService.deleteAllBook();
    }
}