package by.tolkach.smev.controller;

import by.tolkach.smev.controller.api.ISmevController;
import by.tolkach.smev.model.Request;
import by.tolkach.smev.service.api.ISmevService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class SmevController implements ISmevController {

    private final ISmevService smevService;

    public SmevController(ISmevService smevService) {
        this.smevService = smevService;
    }

    public ResponseEntity<?> createRequest(Request request) {
        return ResponseEntity.ok(this.smevService.createRequest(request));
    }

    public ResponseEntity<?> getResponse(UUID requestId) {
        return ResponseEntity.ok(this.smevService.getResponse(requestId));
    }

    public ResponseEntity<?> deleteRequest(UUID requestId) {
        this.smevService.deleteRequest(requestId);
        return ResponseEntity.ok().build();
    }
}
