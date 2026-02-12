package com.intern.librarymanagement.repository;

import com.intern.librarymanagement.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepository extends JpaRepository<BookEntity , Long>{
    List<BookEntity> findByTitle(String title);
    List<BookEntity> findByAuthor(String Author);
}
