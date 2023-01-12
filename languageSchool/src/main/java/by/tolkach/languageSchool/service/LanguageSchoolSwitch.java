package by.tolkach.languageSchool.service;

import by.tolkach.languageSchool.model.Student;
import by.tolkach.languageSchool.service.api.ILanguageSchool;
import by.tolkach.languageSchool.service.api.SchoolType;
import by.tolkach.languageSchool.service.teachers.api.Teacher;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LanguageSchoolSwitch implements ILanguageSchool {

    private Map<String, Teacher> teachers;

    public LanguageSchoolSwitch(Map<String, Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public String inviteStudent(Student student) {
        switch (student.getLanguage()) {
            case ENGLISH: {
                switch (student.getLevel()) {
                    case A1: {
                        return this.teachers.get(Teacher.BEGINNER_ENGLISH_TEACHER).teach(student);
                    }
                    case A2: {
                        return this.teachers.get(Teacher.ELEMENTARY_ENGLISH_TEACHER).teach(student);
                    }
                    default: {
                        return this.teachers.get(Teacher.DEFAULT_TEACHER).teach(student);
                    }
                }
            }
            case POLAND: {
                switch (student.getLevel()) {
                    case A1: {
                        return this.teachers.get(Teacher.BEGINNER_POLAND_TEACHER).teach(student);
                    }
                    case A2: {
                        return this.teachers.get(Teacher.ELEMENTARY_POLAND_TEACHER).teach(student);
                    }
                    default: {
                        return this.teachers.get(Teacher.DEFAULT_TEACHER).teach(student);
                    }
                }
            }
            default: {
                return this.teachers.get(Teacher.DEFAULT_TEACHER).teach(student);
            }
        }
    }

    @Override
    public SchoolType schoolType() {
        return SchoolType.SWITCH;
    }
}
