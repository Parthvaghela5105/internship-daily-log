package com.intern.librarymanagement.service;

import com.intern.librarymanagement.entity.BookEntity;

import java.util.List;

public interface LibraryService {
    String addBook(BookEntity book);
    List<BookEntity> getAllBook();
    BookEntity getBookById(Long id);
    String updateBook(Long id , BookEntity book);
    String deleteAllBook();
    String deleteBookById(Long id);
    List<BookEntity> serchBookByAuthor(String author);
    List<BookEntity> serchBookByTitle(String title);
    Long countBooks();
    List<BookEntity> sortBooks();
    String addBulkBooks(List<BookEntity> books);
}
