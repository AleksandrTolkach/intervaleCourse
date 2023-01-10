package by.tolkach.smev.service.api;

import by.tolkach.smev.model.Fine;

import java.util.UUID;

public interface IWorkerService extends Runnable {

    void checkRequests();
    Fine getResponse(UUID requestId);
    void shutdown();
}
