package by.tolkach.smev.service;

import by.tolkach.smev.dao.api.IResponseStorage;
import by.tolkach.smev.dao.api.entity.ResponseEntity;
import by.tolkach.smev.dao.api.entity.converter.IEntityConverter;
import by.tolkach.smev.model.Response;
import by.tolkach.smev.service.api.IResponseService;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class ResponseService implements IResponseService {
    private final IResponseStorage responseStorage;
    private final IEntityConverter<Response, ResponseEntity> responseEntityConverter;

    public ResponseService(IResponseStorage responseStorage,
                           IEntityConverter<Response, ResponseEntity> responseEntityConverter) {
        this.responseStorage = responseStorage;
        this.responseEntityConverter = responseEntityConverter;
    }

    @Override
    public void create(Response response) {
        this.responseStorage.save(this.responseEntityConverter.toEntity(response));
    }

    @Override
    public Response readByRequestId(UUID requestId) {
        ResponseEntity responseEntity = null;
        while (responseEntity == null) {
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            responseEntity = this.responseStorage.findByRequestId(requestId);
        }
        return this.responseEntityConverter.toDto(responseEntity);
    }
}
