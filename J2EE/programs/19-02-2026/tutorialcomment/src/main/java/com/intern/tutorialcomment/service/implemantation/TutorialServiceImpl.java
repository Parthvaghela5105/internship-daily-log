package com.intern.tutorialcomment.service.implemantation;

import com.intern.tutorialcomment.entity.Tutorial;
import com.intern.tutorialcomment.proxy.TutorialProxy;
import com.intern.tutorialcomment.repository.TutorialRepository;
import com.intern.tutorialcomment.service.TutorialService;
import com.intern.tutorialcomment.utility.MapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorialServiceImpl implements TutorialService {

    @Autowired
    private TutorialRepository tutorialRepository;

    @Autowired
    private MapperHelper helper;

    @Override
    public String saveTutorial(TutorialProxy tutorialProxy) {
        return tutorialRepository.save(helper.tutorial(tutorialProxy)).toString();
    }

    @Override
    public List<TutorialProxy> getAllTutorial() {
        return tutorialRepository.findAll().stream().map(t -> helper.tutorialProxy(t)).toList();
    }

    @Override
    public TutorialProxy getTutorialByTitle(String title) {
        Optional<Tutorial> optTut = tutorialRepository.findByTitle(title);
        if(optTut.isPresent()){
            return helper.tutorialProxy(optTut.get());
        }else{
            return null;
        }
    }

    @Override
    public String deleteTutorialById(Long id) {
        Optional<Tutorial> optTut = tutorialRepository.findById(id);
        if(optTut.isPresent()){
            tutorialRepository.deleteById(id);
            return "Tutorial With id "+id+" has been deleted successfully";
        }
        return "There is no record found with id "+id;
    }

    @Override
    public String deleteAllTutorial() {
        tutorialRepository.deleteAll();
        return "All Tutorial has been deleted successfully";
    }

    @Override
    public String updateTutorial(TutorialProxy tutorialProxy, Long id) {
        Optional<Tutorial> optTut = tutorialRepository.findById(id);
        if(optTut.isPresent()){
            tutorialRepository.save(helper.tutorial(tutorialProxy));
            return "Tutorial With id "+id+" has been updated successfully";
        }
        return "There is no record found with id "+id;
    }
}
