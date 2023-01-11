package by.tolkach.smev.controller.api;

import by.tolkach.smev.model.Request;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

@RequestMapping("/smev")
public interface ISmevController {

    @RequestMapping(value = "/request/", method = RequestMethod.POST)
    ResponseEntity<?> createRequest(@RequestBody Request request);

    @RequestMapping(value = {"/response/{request_id}", "/response/"}, method = RequestMethod.GET)
    ResponseEntity<?> getResponse(@PathVariable(value = "request_id", required = false) UUID requestId);

    @RequestMapping(value = {"/response/{request_id}", "/response/"}, method = RequestMethod.DELETE)
    ResponseEntity<?> deleteRequest(@PathVariable(value = "request_id", required = false) UUID requestId);
}
