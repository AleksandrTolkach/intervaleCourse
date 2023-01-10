package by.tolkach.smev.service;

import by.tolkach.smev.model.Fine;
import by.tolkach.smev.model.Request;
import by.tolkach.smev.model.Response;
import by.tolkach.smev.service.api.IFineService;
import by.tolkach.smev.service.api.IRequestService;
import by.tolkach.smev.service.api.IResponseService;
import by.tolkach.smev.service.api.IWorkerService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class WorkerService implements IWorkerService {

    private boolean isWorking = false;
    private final IRequestService requestService;
    private final IFineService fineService;
    private final IResponseService responseService;

    public WorkerService(IRequestService requestService,
                         IFineService fineService,
                         IResponseService responseService) {
        this.requestService = requestService;
        this.fineService = fineService;
        this.responseService = responseService;
    }

    @Override
    public void run() {
        this.isWorking = true;
        while (isWorking) {
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            checkRequests();
        }
    }

    @Override
    public void checkRequests() {
        List<Request> requests = this.requestService.getRequests();
        if (requests != null && !requests.isEmpty()) {
            for (Request request : requests) {
                Fine fine = this.fineService.readByVehicleId(request.getVehicleId());
                this.responseService.create(Response.ResponseBuilder.createBuilder()
                        .setRequestId(request.getId())
                        .setFineId(fine.getId())
                        .build());
            }
        }
    }

    @Override
    public Fine getResponse(UUID requestId) {
        Response response = this.responseService.readByRequestId(requestId);
        return this.fineService.read(response.getFineId());
    }

    @Override
    public void shutdown() {
        this.isWorking = false;
    }

    @Component
    private class WorkerInitializer {
        private final ExecutorService executorService;
        private final IWorkerService workerService;

        public WorkerInitializer(ExecutorService executorService, IWorkerService workerService) {
            this.executorService = executorService;
            this.workerService = workerService;
        }

        @PostConstruct
        public void init() {
            this.executorService.submit(this.workerService);
        }
    }
}
