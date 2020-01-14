package org.kondiolka.Controller;

import org.kondiolka.Modules.Subject;
import org.kondiolka.Repositories.SubjectRepository;
import org.kondiolka.SubjectMockedData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
public class SubjectController {
    @Autowired
    SubjectRepository subjectRepository;

    @GetMapping("/subject")
    public List<Subject> index(){
        return subjectRepository.findAll();
    }

    @GetMapping("/subject/{id}")
    public Subject show(@PathVariable String id){
        return subjectRepository.findById(Integer.parseInt(id)).get();
    }

    @PostMapping("/subject/search")
    public List<Subject> search(@RequestBody Map<String, String> body){
        return subjectRepository.findByTitleContainingOrDescriptionContaining(body.get("text"), body.get("text"));
    }

    @PostMapping("/subject")
    public Subject create(@RequestBody Map<String, String> body){
        return subjectRepository.save(new Subject(
                Integer.parseInt(body.get("credits")),
                body.get("title"),
                body.get("abbreviation"),
                body.get("description"),
                body.get("language"),
                body.get("faculty")
        ));
    }

    @PutMapping("/subject/{id}")
    public Subject update(@PathVariable String id, @RequestBody Map<String, String> body){
        Subject updatedSubject = subjectRepository.findById(Integer.parseInt(id)).get();
        updatedSubject.setCredits(Integer.parseInt(body.get("credits")));
        updatedSubject.setTitle(body.get("title"));
        updatedSubject.setDescription(body.get("description"));
        updatedSubject.setAbbreviation(body.get("abbreviation"));
        updatedSubject.setLanguage(body.get("language"));
        updatedSubject.setFaculty(body.get("faculty"));
        return subjectRepository.save(updatedSubject);
    }

    @DeleteMapping("subject/{id}")
    public boolean delete(@PathVariable String id){
        subjectRepository.delete(subjectRepository.findById(Integer.parseInt(id)).get());
        return true;
    }
}
