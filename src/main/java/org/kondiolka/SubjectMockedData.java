package org.kondiolka;


import org.kondiolka.Modules.Subject;
import java.util.ArrayList;
import java.util.Iterator;

public class SubjectMockedData {
    private ArrayList<Subject> subjects;
    private static SubjectMockedData instance = null;

    public SubjectMockedData(){
        subjects = new ArrayList<Subject>();
        //Adding first instance of Subject
        subjects.add(new Subject(1,6,"Diskretni matematika", "DIM", "Předmět seznamuje " +
                "studenty se základními pojmy diskrétní matematiky a teorie grafů, se kterými se nejčastěji pracuje v různých " +
                "oblastech teoretické a aplikované informatiky.", "Czech", "FEI"));
        //Adding second instance of Subject
        subjects.add(new Subject(2,8,"Programovací jazyky 1","PJ1", "Seznámit studenty s možností tvorby objektově orientovaných aplikací v rámci platformy Java.",
                "Czech", "FEI"));

    }

    public static SubjectMockedData getInstance(){
        if(instance == null){
            instance = new SubjectMockedData();
        }
        return instance;
    }

    public ArrayList<Subject> fetchSubjects(){
        return subjects;
    }

    public Subject getSubjectByID(int id){
        Iterator<Subject> subjectArrayIterator = subjects.iterator();
        while(subjectArrayIterator.hasNext()){
            Subject s = subjectArrayIterator.next();
            if(s.getId() == id){
                return s;
            }
        }
        return null;
    }

    public ArrayList<Subject> searchSubjects(String searchTerm){
        ArrayList<Subject> searchedSubjects = new ArrayList<Subject>();
        Iterator<Subject> subjectArrayIterator = subjects.iterator();
        while(subjectArrayIterator.hasNext()){
            Subject s = subjectArrayIterator.next();
            if(s.getTitle().toLowerCase().contains(searchTerm.toLowerCase()) || s.getDescription().toLowerCase().contains(searchTerm.toLowerCase())){
                searchedSubjects.add(s);
            }
        }
        return searchedSubjects;
    }

    public Subject createSubject(int id, int credits, String title, String abbreviation, String description, String language, String faculty){
        Subject newSubject = new Subject(id,credits,title,abbreviation,description,language,faculty);
        subjects.add(newSubject);
        return newSubject;
    }

    public Subject updateSubject(int id, int credits, String title, String abbreviation, String description, String language, String faculty){
        Subject updatedSubject = getSubjectByID(id);
        updatedSubject.setCredits(credits);
        updatedSubject.setTitle(title);
        updatedSubject.setAbbreviation(abbreviation);
        updatedSubject.setDescription(description);
        updatedSubject.setLanguage(language);
        updatedSubject.setFaculty(faculty);
        return updatedSubject;
    }

    public boolean deleteSubject(int id){
        Subject deletedSubject = getSubjectByID(id);
        if(deletedSubject == null){
            return false;
        }
        else {
            subjects.remove(deletedSubject);
            return true;
        }
    }




}
