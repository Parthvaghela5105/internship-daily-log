package com.example.librarymanagement.service.implemantation;

import com.example.librarymanagement.proxy.Book;
import com.example.librarymanagement.service.BookService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookServiceImplemantation implements BookService {
    List<Book> bookList = new ArrayList<>();

    @Override
    public String addBook(Book book) {
        Optional<Book> optionalBook = bookList.stream().filter(b -> b.getId().equals(book.getId())).findFirst();
        if(optionalBook.isPresent())
            return "Book is already available with id "+book.getId();
        bookList.add(book);
        return "Book has been added successfully";
    }

    @Override
    public List<Book> getAllBook() {
        return bookList;
    }

    @Override
    public Book getBookById(Long id) {
        return bookList.stream().filter(b -> b.getId().equals(id))
                .findFirst().orElse(new Book(null , null , null , null));
    }

    @Override
    public String updateBook(Long id, Book book) {
        Optional<Book> optionalBook = bookList.stream().filter(b -> b.getId().equals(id)).findFirst();
        if(optionalBook.isPresent()){
            Book updatedBook = optionalBook.get();
            updatedBook.setAuthor(book.getAuthor());
            updatedBook.setPrice(book.getPrice());
            updatedBook.setTitle(book.getTitle());
            return "Book has been Updated Successfully";
        }
        return "There is no Book available with id "+id;
    }

    @Override
    public String removeBook(Long id) {
        boolean isDeleted = bookList.removeIf(b -> b.getId().equals(id));

        if(isDeleted)
            return "Book with id "+id+" has been deleted Successfully";
        else
            return "There is no record found with id "+id;
    }

    @Override
    public List<Book> getBookByTitle(String title) {
        return bookList.stream()
                .filter(b -> b.getTitle().equals(title)).collect(Collectors.toList());

    }

    @Override
    public List<Book> getBookByAuthor(String author) {
        return  bookList.stream()
                .filter(b -> b.getAuthor().equals(author)).collect(Collectors.toList());

    }

    @Override
    public Long countBooks() {
        return (long) bookList.size();
    }

    @Override
    public List<Book> sortBookByPrice() {
        return bookList.stream()
                .sorted((b1 , b2) -> b1.getPrice().compareTo(b2.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public String addBulkBook(List<Book> books) {
        bookList.addAll(books);
        return "Bulk books are added successfully";
    }

    @Override
    public String deleteAllBook() {
        if(bookList.isEmpty())
            return "There is no record found";
        bookList.clear();
        return "All books are removed successfully";
    }
}
