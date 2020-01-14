package org.kondiolka.Modules;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;

@Getter @Setter @ToString @NoArgsConstructor
public class Subject {
    private int id;
    private int credits;
    private String title;
    private String abbreviation;
    private String description;
    private String language;
    private String faculty;

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
