package by.tolkach.languageSchool.service.teachers.api;

import by.tolkach.languageSchool.model.Languages;
import by.tolkach.languageSchool.model.Level;
import by.tolkach.languageSchool.model.Student;

public interface Teacher {

    String BEGINNER_ENGLISH_TEACHER = "beginnerEnglishTeacher";
    String ELEMENTARY_ENGLISH_TEACHER = "elementaryEnglishTeacher";
    String BEGINNER_POLAND_TEACHER = "beginnerPolandTeacher";
    String ELEMENTARY_POLAND_TEACHER = "elementaryPolandTeacher";

    void teach(Student student);
    Languages language();
    Level level();
}
