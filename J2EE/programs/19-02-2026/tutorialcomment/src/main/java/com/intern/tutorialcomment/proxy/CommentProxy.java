package com.intern.tutorialcomment.proxy;

import lombok.Data;

@Data
public class CommentProxy {
    private Long id;
    private String content;
    private TutorialProxy tutorial;
}
