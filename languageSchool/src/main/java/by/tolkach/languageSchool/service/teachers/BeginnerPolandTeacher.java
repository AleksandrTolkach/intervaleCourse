package by.tolkach.languageSchool.service.teachers;

import by.tolkach.languageSchool.model.Languages;
import by.tolkach.languageSchool.model.Level;
import by.tolkach.languageSchool.model.Student;
import by.tolkach.languageSchool.service.teachers.api.Teacher;
import by.tolkach.languageSchool.service.teaching.Reading;
import by.tolkach.languageSchool.service.teaching.Writing;
import by.tolkach.languageSchool.service.teaching.api.Teaching;
import by.tolkach.languageSchool.service.api.InjectList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeginnerPolandTeacher implements Teacher {
    @InjectList({Reading.class, Writing.class})
    private List<Teaching> teachings;

    public BeginnerPolandTeacher(List<Teaching> teachings) {
        this.teachings = teachings;
    }

    @Override
    public String teach(Student student) {
        System.out.println(POLAND_GREETING);
        return prepareAnswer(POLAND_GREETING, teachings);
    }

    @Override
    public Languages language() {
        return Languages.POLAND;
    }

    @Override
    public Level level() {
        return Level.A1;
    }
}
