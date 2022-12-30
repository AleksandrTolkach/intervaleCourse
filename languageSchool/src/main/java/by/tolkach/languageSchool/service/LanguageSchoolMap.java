package by.tolkach.languageSchool.service;

import by.tolkach.languageSchool.model.Student;
import by.tolkach.languageSchool.service.api.ILanguageSchool;
import by.tolkach.languageSchool.service.api.SchoolType;
import by.tolkach.languageSchool.service.teachers.DefaultTeacher;
import by.tolkach.languageSchool.service.teachers.api.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class LanguageSchoolMap implements ILanguageSchool {

    private Map<String, Teacher> teachers;

    public LanguageSchoolMap(List<Teacher> teachers) {
        this.teachers = teachers.stream().collect(Collectors.toMap(x -> {
            return x.language().toString() + x.level().toString();
        }, Function.identity()));
    }

    @Override
    public void inviteStudent(Student student) {
        Teacher teacher = this.teachers.getOrDefault(student.getLanguage().toString() + student.getLevel().toString(),
                new DefaultTeacher());
        teacher.teach(student);
    }

    @Override
    public SchoolType schoolType() {
        return SchoolType.MAP;
    }
}
