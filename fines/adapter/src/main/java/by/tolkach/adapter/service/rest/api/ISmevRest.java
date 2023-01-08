package by.tolkach.adapter.service.rest.api;

import by.tolkach.adapter.service.rest.template.FineTemplate;
import by.tolkach.adapter.service.rest.template.RequestTemplate;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface ISmevRest {
    CompletableFuture<UUID> informationRequest(RequestTemplate requestTemplate);
    CompletableFuture<FineTemplate> responseRequest(UUID requestId);
    void deleteRequest(UUID requestId);
}
