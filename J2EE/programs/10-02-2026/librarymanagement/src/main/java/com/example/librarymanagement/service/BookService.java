package com.example.librarymanagement.service;


import com.example.librarymanagement.proxy.Book;

import java.util.List;

public interface BookService {

    String addBook(Book book);

    List<Book> getAllBook();

    Book getBookById(Long id);

    String updateBook(Long id , Book book);

    String removeBook(Long id);

    List<Book> getBookByTitle(String title);

    List<Book> getBookByAuthor(String author);

    Long countBooks();

    List<Book> sortBookByPrice();

    String addBulkBook(List<Book> books);

    String deleteAllBook();
}
