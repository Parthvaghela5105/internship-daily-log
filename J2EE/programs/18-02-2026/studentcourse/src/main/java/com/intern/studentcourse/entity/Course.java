package com.intern.studentcourse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class Course {
    private Long id;
    private String title;
    private Double fees;

    @ManyToMany(mappedBy = "courses" , fetch = FetchType.LAZY)
    private Student students;
}
