package by.tolkach.languageSchool.service.teachers;

import by.tolkach.languageSchool.model.Languages;
import by.tolkach.languageSchool.model.Level;
import by.tolkach.languageSchool.model.Student;
import by.tolkach.languageSchool.service.teachers.api.Teacher;
import org.springframework.stereotype.Service;

@Service
public class DefaultTeacher implements Teacher {
    @Override
    public String teach(Student student) {
        System.out.println("Открываем словарь");
        return "Открываем словарь";
    }

    @Override
    public Languages language() {
        return Languages.RUSSIAN;
    }

    @Override
    public Level level() {
        return Level.A1;
    }
}
