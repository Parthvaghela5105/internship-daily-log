package com.intern.tutorialcomment.utility;

import com.intern.tutorialcomment.entity.Comment;
import com.intern.tutorialcomment.entity.Tutorial;
import com.intern.tutorialcomment.proxy.CommentProxy;
import com.intern.tutorialcomment.proxy.TutorialProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
public class MapperHelper {
    @Autowired
    private ObjectMapper mapper;

    public Tutorial tutorial(TutorialProxy proxy){
        return mapper.convertValue(proxy , Tutorial.class);
    }

    public TutorialProxy tutorialProxy(Tutorial tutorial){
        return mapper.convertValue(tutorial , TutorialProxy.class);
    }

    public Comment comment(CommentProxy proxy){
        return mapper.convertValue(proxy , Comment.class);
    }

    public CommentProxy commentProxy(Comment comment){
        return mapper.convertValue(comment , CommentProxy.class);
    }
}
