package by.tolkach.adapter.service.rest;

import by.tolkach.adapter.model.IdType;
import by.tolkach.adapter.service.rest.api.ISmevRest;
import by.tolkach.adapter.service.rest.template.FineTemplate;
import by.tolkach.adapter.service.rest.template.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class SmevRest implements ISmevRest {

    private final RestTemplate restTemplate;
    private @Value("${smev.url.fl}") String urlFl;
    private @Value("${smev.url.ul}") String urlUl;
    private @Value("{smev.url.response}") String response;
    private Map<IdType, String> urlList = new HashMap<>();

    public SmevRest(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        this.urlList.put(IdType.STS, "http://localhost:8082/smev/fl/{sts}");
        this.urlList.put(IdType.INN, "http://localhost:8082/smev/ul/{inn}");
    }

    @Override
    @Async
    public CompletableFuture<UUID> informationRequest(RequestTemplate requestTemplate) {
        String uri = this.urlList.get(requestTemplate.getIdType());
        UUID requestId = this.restTemplate.getForObject(uri, UUID.class, requestTemplate.getIdentifier());
        return CompletableFuture.completedFuture(requestId);
    }

    @Override
    @Async
    public CompletableFuture<FineTemplate> responseRequest(UUID requestId) {
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
