package by.tolkach.smev.controller;

import by.tolkach.smev.service.api.ISmevService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/smev")
public class SmevController {

    private final ISmevService smevService;

    public SmevController(ISmevService smevService) {
        this.smevService = smevService;
    }

    @RequestMapping(value = "/fl/{sts}", method = RequestMethod.GET)
    public ResponseEntity<?> getFlInformation(@PathVariable String sts) {
        return ResponseEntity.ok(this.smevService.getFlInformation(sts));
    }

    @RequestMapping(value = "/ul/{inn}", method = RequestMethod.GET)
    public ResponseEntity<?> getUlInformation(@PathVariable String inn) {
        return ResponseEntity.ok(this.smevService.getUlInformation(inn));
    }

    @RequestMapping(value = "/response/{request_id}", method = RequestMethod.GET)
    public ResponseEntity<?> getResponse(@PathVariable("request_id") UUID requestId) {
        return ResponseEntity.ok(this.smevService.getResponse(requestId));
    }

    @RequestMapping(value = "/response/{request_id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteRequest(@PathVariable("request_id") UUID requestId) {
        this.smevService.deleteRequest(requestId);
        return ResponseEntity.ok().build();
    }
}
