package by.tolkach.languageSchool.controller.api;


import by.tolkach.languageSchool.model.Student;
import by.tolkach.languageSchool.service.api.SchoolType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/school")
public interface ILanguageSchoolController {

    @RequestMapping(value = "/student/{school_type}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> inviteStudent(@PathVariable("school_type") SchoolType schoolType,
                                           @RequestBody Student student);
}
