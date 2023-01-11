package by.tolkach.smev.service;

import by.tolkach.smev.model.Fine;
import by.tolkach.smev.model.Request;
import by.tolkach.smev.service.api.IRequestService;
import by.tolkach.smev.service.api.ISmevService;
import by.tolkach.smev.service.api.IWorkerService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SmevService implements ISmevService {

    private final IRequestService requestService;
    private final IWorkerService workerService;

    public SmevService(IRequestService requestService, IWorkerService workerService) {
        this.requestService = requestService;
        this.workerService = workerService;
    }

    @Override
    public UUID createRequest(Request request) {
        return this.requestService.createRequest(request);
    }

    @Override
    public Fine getResponse(UUID requestId) {
        return this.workerService.getResponse(requestId);
    }

    @Override
    public void deleteRequest(UUID requestId) {
        this.requestService.deleteRequest(requestId);
    }
}
