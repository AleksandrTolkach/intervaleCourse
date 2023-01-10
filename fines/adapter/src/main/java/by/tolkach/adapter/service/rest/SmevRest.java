package by.tolkach.adapter.service.rest;

import by.tolkach.adapter.service.rest.api.ISmevRest;
import by.tolkach.adapter.service.rest.template.FineTemplate;
import by.tolkach.adapter.service.rest.template.RequestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class SmevRest implements ISmevRest {

    private final RestTemplate restTemplate;

    public SmevRest(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public CompletableFuture<UUID> createRequest(RequestTemplate requestTemplate) {
        String uri = "http://localhost:8082/smev/request/";
        UUID requestId = this.restTemplate.postForObject(uri, requestTemplate, UUID.class);
        return CompletableFuture.completedFuture(requestId);
    }

    @Override
    public CompletableFuture<FineTemplate> getResponse(UUID requestId) {
        String uri = "http://localhost:8082/smev/response/{request_id}";
        FineTemplate fineTemplate = this.restTemplate.getForObject(uri, FineTemplate.class, requestId);
        return CompletableFuture.completedFuture(fineTemplate);
    }

    @Override
    public void deleteRequest(UUID requestId) {
        String uri = "http://localhost:8082/smev/response/{request_id}";
        this.restTemplate.delete(uri, requestId);
    }
}
