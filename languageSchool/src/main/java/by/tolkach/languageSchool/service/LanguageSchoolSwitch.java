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
    public void inviteStudent(Student student) {
        switch (student.getLanguage()) {
            case ENGLISH: {
                switch (student.getLevel()) {
                    case A1: {
                        this.teachers.get(Teacher.BEGINNER_ENGLISH_TEACHER).teach(student);
                        break;
                    }
                    case A2: {
                        this.teachers.get(Teacher.ELEMENTARY_ENGLISH_TEACHER).teach(student);
                        break;
                    }
                }
                break;
            }
            case POLAND: {
                switch (student.getLevel()) {
                    case A1: {
                        this.teachers.get(Teacher.BEGINNER_POLAND_TEACHER).teach(student);
                        break;
                    }
                    case A2: {
                        this.teachers.get(Teacher.ELEMENTARY_POLAND_TEACHER).teach(student);
                        break;
                    }
                }
                break;
            }
        }
    }

    @Override
    public SchoolType schoolType() {
        return SchoolType.SWITCH;
    }
}
