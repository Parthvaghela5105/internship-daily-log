package com.intern.tutorialcomment.repository;

import com.intern.tutorialcomment.entity.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial , Long> {
    Optional<Tutorial> findByTitle(String title);
}
