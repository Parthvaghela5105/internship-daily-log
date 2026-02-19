package com.intern.tutorialcomment.service;

import com.intern.tutorialcomment.proxy.TutorialProxy;

import java.util.List;

public interface TutorialService {
    String saveTutorial(TutorialProxy tutorialProxy);
    List<TutorialProxy> getAllTutorial();
    TutorialProxy getTutorialByTitle(String title);
    String deleteTutorialById(Long id);
    String deleteAllTutorial();
    String updateTutorial(TutorialProxy  tutorialProxy, Long id );
}
