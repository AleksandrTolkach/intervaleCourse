package by.tolkach.adapter.controller;

import by.tolkach.adapter.controller.api.IAdapterController;
import by.tolkach.adapter.model.IdType;
import by.tolkach.adapter.model.Request;
import by.tolkach.adapter.service.api.IAdapterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdapterController implements IAdapterController {

    private final IAdapterService adapterService;

    public AdapterController(IAdapterService adapterService) {
        this.adapterService = adapterService;
    }

    public ResponseEntity<?> readFlFine(String sts) {
        return ResponseEntity.ok(this.adapterService.fineRequest(Request.RequestBuilder.createBuilder()
                .setVehicleId(sts).setIdType(IdType.STS).build()));
    }

    public ResponseEntity<?> readUlFine(String inn) {
        return ResponseEntity.ok(this.adapterService.fineRequest(Request.RequestBuilder.createBuilder()
                .setVehicleId(inn).setIdType(IdType.INN).build()));
    }
}
