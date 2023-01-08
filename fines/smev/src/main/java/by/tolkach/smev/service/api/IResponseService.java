package by.tolkach.smev.service.api;

import by.tolkach.smev.model.Response;

import java.util.UUID;

public interface IResponseService {

    void create(Response response);
    Response readByRequestId(UUID requestId);
}
