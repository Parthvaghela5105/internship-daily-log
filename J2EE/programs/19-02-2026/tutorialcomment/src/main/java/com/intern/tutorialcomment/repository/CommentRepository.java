package com.intern.tutorialcomment.repository;

import com.intern.tutorialcomment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment , Long> {
}
