package org.kondiolka.Modules;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//I could add also @Table(name="Subject") but it is not necessary because I want the table
// to have name same as this module --> Same for all columns (@Column(name="column_name"))
@Getter @Setter @ToString @NoArgsConstructor @Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int credits;
    private String title;
    private String abbreviation;
    private String description;
    private String language;
    private String faculty;

    public Subject(int credits, String title, String abbreviation, String description, String language, String faculty){
        this.credits = credits;
        this.title = title;
        this.abbreviation = abbreviation;
        this.description = description;
        this.language = language;
        this.faculty = faculty;
    }

    public Subject(int id, int credits, String title, String abbreviation, String description, String language, String faculty){
        this.id = id;
        this.credits = credits;
        this.title = title;
        this.abbreviation = abbreviation;
        this.description = description;
        this.language = language;
        this.faculty = faculty;
    }
}
