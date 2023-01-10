package by.tolkach.adapter.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/fine")
public interface IAdapterController {

    @RequestMapping(value = "/fl/{sts}",method = RequestMethod.GET)
    ResponseEntity<?> readFlFine(@PathVariable String sts);

    @RequestMapping(value = "/ul/{inn}", method = RequestMethod.GET)
    ResponseEntity<?> readUlFine(@PathVariable String inn);
}
