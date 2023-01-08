package by.tolkach.smev.service.api;

import by.tolkach.smev.model.Request;

import java.util.List;
import java.util.UUID;

public interface IRequestService {

    UUID getFlInformation(String sts);
    UUID getUlInformation(String inn);
    List<Request> getRequests();
    void deleteRequest(UUID requestId);
}
