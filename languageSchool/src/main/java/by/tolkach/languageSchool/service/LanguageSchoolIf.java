package by.tolkach.languageSchool.service;

import by.tolkach.languageSchool.model.Languages;
import by.tolkach.languageSchool.model.Level;
import by.tolkach.languageSchool.model.Student;
import by.tolkach.languageSchool.service.api.ILanguageSchool;
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
    public void inviteStudent(Student student) {
        if (student.getLanguage().equals(Languages.ENGLISH)) {
            if (student.getLevel().equals(Level.A1)) {
                this.teachers.get("beginnerEnglishTeacher").teach(student);
                return;
            }
            if (student.getLevel().equals(Level.A2)) {
                this.teachers.get("elementaryEnglishTeacher").teach(student);
                return;
            }
        }
        if (student.getLanguage().equals(Languages.POLAND)) {
            if (student.getLevel().equals(Level.A1)) {
                this.teachers.get("beginnerPolandTeacher").teach(student);
                return;
            }
            if (student.getLevel().equals(Level.A2)) {
                this.teachers.get("elementaryPolandTeacher").teach(student);
                return;
            }
        }
    }
}
