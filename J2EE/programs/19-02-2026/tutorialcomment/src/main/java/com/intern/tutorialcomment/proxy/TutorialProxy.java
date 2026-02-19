package com.intern.tutorialcomment.proxy;

import com.intern.tutorialcomment.entity.Comment;
import lombok.Data;

import java.util.List;

@Data
public class TutorialProxy {
    private Long id;
    private String title;
    private String description;
    private List<CommentProxy> comment;
}
