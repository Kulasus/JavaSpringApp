package org.kondiolka.Controller;

import org.kondiolka.Modules.Subject;
import org.kondiolka.SubjectMockedData;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Map;

@RestController
public class SubjectController {
    SubjectMockedData subjectMockedData = SubjectMockedData.getInstance();

    @GetMapping("/subject")
    public ArrayList<Subject> index(){
        return subjectMockedData.fetchSubjects();
    }

    @GetMapping("/subject/{id}")
    public Subject show(@PathVariable String id){
        return subjectMockedData.getSubjectByID(Integer.parseInt(id));
    }

    @PostMapping("/subject/search")
    public ArrayList<Subject> search(@RequestBody Map<String, String> body){
        return subjectMockedData.searchSubjects(body.get("text"));
    }

    @PostMapping("/subject")
    public Subject create(@RequestBody Map<String, String> body){
        return subjectMockedData.createSubject(
                Integer.parseInt(body.get("id")),
                Integer.parseInt(body.get("credits")),
                body.get("title"),
                body.get("abbreviation"),
                body.get("description"),
                body.get("language"),
                body.get("faculty")
        );
    }

    @PutMapping("/subject/{id}")
    public Subject update(@PathVariable String id, @RequestBody Map<String, String> body){
        return subjectMockedData.updateSubject(
                Integer.parseInt(id),
                Integer.parseInt(body.get("credits")),
                body.get("title"),
                body.get("abbreviation"),
                body.get("description"),
                body.get("language"),
                body.get("faculty")
        );
    }

    @DeleteMapping("subject/{id}")
    public boolean delete(@PathVariable String id){
        return subjectMockedData.deleteSubject(Integer.parseInt(id));
    }
}
