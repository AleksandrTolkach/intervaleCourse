package by.tolkach.smev.service.api;

import by.tolkach.smev.model.Fine;
import by.tolkach.smev.model.Request;

import java.util.List;
import java.util.UUID;

public interface ISmevService {

    UUID getFlInformation(Request request);
    Fine getResponse(UUID requestId);
    List<Request> getRequests();
    void deleteRequest(UUID requestId);
}
