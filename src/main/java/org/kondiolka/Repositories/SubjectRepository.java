package org.kondiolka.Repositories;

import org.kondiolka.Modules.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

    List<Subject> findByTitleContainingOrDescriptionContaining(String text, String textAgain);
}
