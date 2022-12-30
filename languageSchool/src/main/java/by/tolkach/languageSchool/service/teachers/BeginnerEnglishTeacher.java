package by.tolkach.languageSchool.service.teachers;

import by.tolkach.languageSchool.model.Languages;
import by.tolkach.languageSchool.model.Level;
import by.tolkach.languageSchool.model.Student;
import by.tolkach.languageSchool.service.teachers.api.Teacher;
import by.tolkach.languageSchool.service.teaching.Reading;
import by.tolkach.languageSchool.service.teaching.Writing;
import by.tolkach.languageSchool.service.teaching.api.BeginnersTeaching;
import by.tolkach.languageSchool.service.api.InjectList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeginnerEnglishTeacher implements Teacher {
    @InjectList({Reading.class, Writing.class})
    private List<BeginnersTeaching> teachings;

    public BeginnerEnglishTeacher(List<BeginnersTeaching> teachings) {
        this.teachings = teachings;
    }

    @Override
    public void teach(Student student) {
        System.out.println("Hello!");
        this.teachings.forEach(teaching -> teaching.process());
    }

    @Override
    public Languages language() {
        return Languages.ENGLISH;
    }

    @Override
    public Level level() {
        return Level.A1;
    }
}
