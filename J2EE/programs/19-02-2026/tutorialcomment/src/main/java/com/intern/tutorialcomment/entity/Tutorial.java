package com.intern.tutorialcomment.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "comments")
public class Tutorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @OneToMany(mappedBy = "tutorial", orphanRemoval = true , cascade = CascadeType.ALL)
    private List<Comment> comment = new ArrayList<>();

}
