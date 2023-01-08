package by.tolkach.adapter.controller;

import by.tolkach.adapter.model.IdType;
import by.tolkach.adapter.model.Request;
import by.tolkach.adapter.service.api.IAdapterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fine")
public class AdapterController {

    private final IAdapterService adapterService;

    public AdapterController(IAdapterService adapterService) {
        this.adapterService = adapterService;
    }

    @RequestMapping(value = "/fl/{sts}",method = RequestMethod.GET)
    ResponseEntity<?> fineFlRequest(@PathVariable String sts) {
        return ResponseEntity.ok(this.adapterService.fineRequest(Request.RequestBuilder.createBuilder()
                .setIdentifier(sts).setIdType(IdType.STS).build()));
    }

    @RequestMapping(value = "/ul/{inn}", method = RequestMethod.GET)
    ResponseEntity<?> fineUlRequest(@PathVariable String inn) {
        return ResponseEntity.ok(this.adapterService.fineRequest(Request.RequestBuilder.createBuilder()
                .setIdentifier(inn).setIdType(IdType.INN).build()));
    }
}
