package by.tolkach.languageSchool.service.api;

import by.tolkach.languageSchool.model.Student;

public interface ILanguageSchool {

    String inviteStudent(Student student);
    SchoolType schoolType();
}
