package by.tolkach.languageSchool.service.teachers;

import by.tolkach.languageSchool.model.Languages;
import by.tolkach.languageSchool.model.Level;
import by.tolkach.languageSchool.model.Student;
import by.tolkach.languageSchool.service.teachers.api.Teacher;
import by.tolkach.languageSchool.service.teaching.Speaking;
import by.tolkach.languageSchool.service.teaching.Testing;
import by.tolkach.languageSchool.service.teaching.api.Teaching;
import by.tolkach.languageSchool.service.api.InjectList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElementaryEnglishTeacher implements Teacher {
    @InjectList({Speaking.class, Testing.class})
    private List<Teaching> teachings;

    public ElementaryEnglishTeacher(List<Teaching> teachings) {
        this.teachings = teachings;
    }

    @Override
    public String teach(Student student) {
        System.out.println(ENGLISH_GREETING);
        return prepareAnswer(ENGLISH_GREETING, teachings);
    }

    @Override
    public Languages language() {
        return Languages.ENGLISH;
    }

    @Override
    public Level level() {
        return Level.A2;
    }
}
