package by.tolkach.adapter.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/fine")
@Validated
public interface IAdapterController {

    @RequestMapping(value = {"/fl/{sts}", "/fl/"},method = RequestMethod.GET)
    ResponseEntity<?> readFlFine(@PathVariable(required = false) String sts);

    @RequestMapping(value = {"/ul/{inn}", "/ul/"}, method = RequestMethod.GET)
    ResponseEntity<?> readUlFine(@PathVariable(required = false) String inn);
}
