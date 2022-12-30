package by.tolkach.languageSchool.controller;

import by.tolkach.languageSchool.model.Student;
import by.tolkach.languageSchool.service.api.ILanguageSchool;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/school")
public class LanguageSchoolController {

    private ILanguageSchool languageSchool;

    public LanguageSchoolController(@Qualifier("languageSchoolIf") ILanguageSchool languageSchool) {
        this.languageSchool = languageSchool;
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> inviteStudent(@RequestBody Student student) {
        this.languageSchool.inviteStudent(student);
        return ResponseEntity.ok().build();
    }

}
