package com.intern.librarymanagement.service.implementation;

import com.intern.librarymanagement.entity.BookEntity;
import com.intern.librarymanagement.repository.LibraryRepository;
import com.intern.librarymanagement.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.awt.print.Book;
import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private LibraryRepository libraryRepo;

    @Override
    public String addBook(BookEntity book) {
        return libraryRepo.save(book).toString();
    }

    @Override
    public List<BookEntity> getAllBook() {
        return libraryRepo.findAll();
    }

    @Override
    public BookEntity getBookById(Long id) {
        return libraryRepo.findById(id).orElse(new BookEntity(null , null , null , 0.0));
    }

    @Override
    public String updateBook(Long id, BookEntity book) {
        return libraryRepo.save(book).toString();
    }

    @Override
    public String deleteAllBook() {
        libraryRepo.deleteAll();
        return "Deleted all book successfully";
    }

    @Override
    public String deleteBookById(Long id) {
        libraryRepo.deleteById(id);
        return "deleted Successfully";
    }

    @Override
    public List<BookEntity> serchBookByAuthor(String author) {
        return libraryRepo.findByAuthor(author);
    }

    @Override
    public List<BookEntity> serchBookByTitle(String title) {
        return libraryRepo.findByTitle(title);
    }

    @Override
    public Long countBooks() {
        return libraryRepo.count();
    }

    @Override
    public List<BookEntity> sortBooks() {
        return libraryRepo.findAll();
    }

    @Override
    public String addBulkBooks(List<BookEntity> books) {
        return "";
    }
}
