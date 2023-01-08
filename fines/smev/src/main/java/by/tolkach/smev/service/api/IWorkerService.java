package by.tolkach.smev.service.api;

import by.tolkach.smev.model.Fine;

import java.util.UUID;

public interface IWorkerService {

    void run();
    void checkRequests();
    Fine getInformation(UUID requestId);
    void shutdown();
}
