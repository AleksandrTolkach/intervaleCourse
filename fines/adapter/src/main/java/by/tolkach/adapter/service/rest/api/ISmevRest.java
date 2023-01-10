package by.tolkach.adapter.service.rest.api;

import by.tolkach.adapter.service.rest.template.FineTemplate;
import by.tolkach.adapter.service.rest.template.RequestTemplate;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface ISmevRest {
    CompletableFuture<UUID> createRequest(RequestTemplate requestTemplate);
    CompletableFuture<FineTemplate> getResponse(UUID requestId);
    void deleteRequest(UUID requestId);
}
