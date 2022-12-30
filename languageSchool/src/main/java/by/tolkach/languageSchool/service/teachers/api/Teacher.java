package by.tolkach.languageSchool.service.teachers.api;

import by.tolkach.languageSchool.model.Languages;
import by.tolkach.languageSchool.model.Level;
import by.tolkach.languageSchool.model.Student;

public interface Teacher {
    void teach(Student student);
    Languages language();
    Level level();
}
