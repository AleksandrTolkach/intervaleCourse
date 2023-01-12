package by.tolkach.languageSchool.service.teachers.api;

import by.tolkach.languageSchool.model.Languages;
import by.tolkach.languageSchool.model.Level;
import by.tolkach.languageSchool.model.Student;
import by.tolkach.languageSchool.service.teaching.api.Teaching;

import java.util.List;

public interface Teacher {

    String BEGINNER_ENGLISH_TEACHER = "beginnerEnglishTeacher";
    String ELEMENTARY_ENGLISH_TEACHER = "elementaryEnglishTeacher";
    String BEGINNER_POLAND_TEACHER = "beginnerPolandTeacher";
    String ELEMENTARY_POLAND_TEACHER = "elementaryPolandTeacher";
    String DEFAULT_TEACHER = "defaultTeacher";
    String POLAND_GREETING = "Cześć";
    String ENGLISH_GREETING = "Hello!";

    String teach(Student student);
    Languages language();
    Level level();

    default String prepareAnswer(String greeting, List<Teaching> teachings) {
        StringBuilder sb = new StringBuilder();
        sb.append(greeting + "\n");
        for (Teaching teaching : teachings) {
            sb.append(teaching.process() + "\n");
        }
        return sb.toString();
    }
}
