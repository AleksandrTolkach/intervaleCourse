package by.tolkach.languageSchool.controller;

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
@RequestMapping("/school")
public class LanguageSchoolController {

    private Map<SchoolType, ILanguageSchool> schools;

    public LanguageSchoolController(List<ILanguageSchool> schoolsList) {
        this.schools = schoolsList.stream().collect(Collectors.toMap(ILanguageSchool::schoolType, Function.identity()));
    }

    @RequestMapping(value = "/student/{school_type}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> inviteStudent(@PathVariable("school_type") SchoolType schoolType,
                                           @RequestBody Student student) {
        this.schools.get(schoolType).inviteStudent(student);
        return ResponseEntity.ok().build();
    }

}
