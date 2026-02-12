package com.intern.librarymanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Book")
public class BookEntity {
    @Id
    private Long id;
    private String title;
    private String author;
    private double price;


}
