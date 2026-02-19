package com.intern.tutorialcomment.controller;

import com.intern.tutorialcomment.proxy.TutorialProxy;
import com.intern.tutorialcomment.service.TutorialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "v1/tutorial")
public class TutorialController {

    private TutorialService tutorialService;

    @PostMapping()
    public String saveTutorial(@RequestBody TutorialProxy tutorialProxy){
        return tutorialService.saveTutorial(tutorialProxy);
    }

    @GetMapping()
    public List<TutorialProxy> getAllTutorial(){
        return tutorialService.getAllTutorial();
    }

    @GetMapping("/{title}")
    public TutorialProxy getTutorialByTitle(@PathVariable String title){
        return tutorialService.getTutorialByTitle(title);
    }

    @DeleteMapping()
    public String deleteAllStudent(){
        return tutorialService.deleteAllTutorial();
    }

}
