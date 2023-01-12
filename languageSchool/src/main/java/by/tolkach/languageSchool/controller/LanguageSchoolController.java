package by.tolkach.languageSchool.controller;

import by.tolkach.languageSchool.controller.api.ILanguageSchoolController;
import by.tolkach.languageSchool.model.Student;
import by.tolkach.languageSchool.service.api.ILanguageSchool;
import by.tolkach.languageSchool.service.api.SchoolType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
public class LanguageSchoolController implements ILanguageSchoolController {
    private Map<SchoolType, ILanguageSchool> schools;

    public LanguageSchoolController(List<ILanguageSchool> schoolsList) {
        this.schools = schoolsList.stream().collect(Collectors.toMap(ILanguageSchool::schoolType, Function.identity()));
    }

    @Override
    public ResponseEntity<?> inviteStudent(SchoolType schoolType, Student student) {
        return ResponseEntity.ok(this.schools.get(schoolType).inviteStudent(student));
    }

}
