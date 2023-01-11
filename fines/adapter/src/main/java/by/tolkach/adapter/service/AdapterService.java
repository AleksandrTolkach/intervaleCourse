package by.tolkach.adapter.service;

import by.tolkach.adapter.model.Fine;
import by.tolkach.adapter.model.Request;
import by.tolkach.adapter.model.exception.NotFoundException;
import by.tolkach.adapter.service.api.IAdapterService;
import by.tolkach.adapter.service.rest.api.ISmevRest;
import by.tolkach.adapter.service.rest.template.FineTemplate;
import by.tolkach.adapter.service.rest.template.RequestTemplate;
import by.tolkach.adapter.service.rest.template.converter.ITemplateConverter;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
public class AdapterService implements IAdapterService {
    private final ISmevRest smevRest;
    private final ITemplateConverter<Fine, FineTemplate> fineTemplateConverter;
    private final ITemplateConverter<Request, RequestTemplate> requestTemplateConverter;

    public AdapterService(ISmevRest smevRest,
                          ITemplateConverter<Fine, FineTemplate> fineTemplateConverter,
                          ITemplateConverter<Request, RequestTemplate> requestTemplateConverter) {
        this.smevRest = smevRest;
        this.fineTemplateConverter = fineTemplateConverter;
        this.requestTemplateConverter = requestTemplateConverter;
    }

    @Override
    public Fine fineRequest(Request request) {
        CompletableFuture<UUID> uuidCompletableFuture =
                this.smevRest.createRequest(this.requestTemplateConverter.toTemplate(request));
        UUID requestId = null;
        try {
            requestId = uuidCompletableFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        CompletableFuture<FineTemplate> fineTemplateCompletableFuture = this.smevRest.getResponse(requestId);
        FineTemplate fineTemplate = null;

        for (int i = 0; i < 4; i++) {
            try {
                fineTemplate = fineTemplateCompletableFuture.get(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                System.err.println("Запрос №" + i + " не вернул результат");
            }
            if (fineTemplate != null) {
                break;
            }
        }
        if (fineTemplate == null) {
            System.err.println("Штрафа для данного ТС нет");
            throw new NotFoundException("Штрафа для данного ТС нет");
        }
        this.smevRest.deleteRequest(requestId);
        return this.fineTemplateConverter.toDto(fineTemplate);
    }
}
