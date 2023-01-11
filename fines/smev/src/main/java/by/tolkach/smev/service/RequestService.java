package by.tolkach.smev.service;

import by.tolkach.smev.dao.api.IRequestStorage;
import by.tolkach.smev.dao.api.entity.RequestEntity;
import by.tolkach.smev.dao.api.entity.converter.IEntityConverter;
import by.tolkach.smev.model.Request;
import by.tolkach.smev.service.api.IRequestService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RequestService implements IRequestService {

    private final IRequestStorage requestStorage;
    private final IEntityConverter<Request, RequestEntity> requestEntityConverter;

    public RequestService(IRequestStorage requestStorage,
                          IEntityConverter<Request, RequestEntity> requestEntityConverter) {
        this.requestStorage = requestStorage;
        this.requestEntityConverter = requestEntityConverter;
    }

    @Override
    public UUID createRequest(Request request) {
        UUID requestId = UUID.randomUUID();
        request.setId(requestId);
        this.requestStorage.save(this.requestEntityConverter.toEntity(request));
        return requestId;
    }

    @Override
    public List<Request> getRequests() {
        List<RequestEntity> requestEntities = this.requestStorage.findAll();
        return requestEntities.stream()
                .map(this.requestEntityConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteRequest(UUID requestId) {
        this.requestStorage.deleteById(requestId);
    }
}
