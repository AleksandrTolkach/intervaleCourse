package by.tolkach.languageSchool.service;

import by.tolkach.languageSchool.model.Languages;
import by.tolkach.languageSchool.model.Level;
import by.tolkach.languageSchool.model.Student;
import by.tolkach.languageSchool.service.api.ILanguageSchool;
import by.tolkach.languageSchool.service.api.SchoolType;
import by.tolkach.languageSchool.service.teachers.api.Teacher;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LanguageSchoolIf implements ILanguageSchool {

    public Map<String, Teacher> teachers;

    public LanguageSchoolIf(Map<String, Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public String inviteStudent(Student student) {
        if (student.getLanguage().equals(Languages.ENGLISH)) {
            if (student.getLevel().equals(Level.A1)) {
                return this.teachers.get(Teacher.BEGINNER_ENGLISH_TEACHER).teach(student);
            }
            if (student.getLevel().equals(Level.A2)) {
                return this.teachers.get(Teacher.ELEMENTARY_ENGLISH_TEACHER).teach(student);
            }
        }
        if (student.getLanguage().equals(Languages.POLAND)) {
            if (student.getLevel().equals(Level.A1)) {
                return this.teachers.get(Teacher.BEGINNER_POLAND_TEACHER).teach(student);
            }
            if (student.getLevel().equals(Level.A2)) {
                return this.teachers.get(Teacher.ELEMENTARY_POLAND_TEACHER).teach(student);
            }
        }
         return this.teachers.get(Teacher.DEFAULT_TEACHER).teach(student);
    }

    @Override
    public SchoolType schoolType() {
        return SchoolType.IF;
    }
}
