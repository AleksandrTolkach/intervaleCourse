package by.tolkach.smev.dao.api.entity.converter;

import by.tolkach.smev.dao.api.entity.RequestEntity;
import by.tolkach.smev.model.Request;
import org.springframework.stereotype.Component;

@Component
public class RequestEntityConverter implements IEntityConverter<Request, RequestEntity> {
    @Override
    public RequestEntity toEntity(Request dto) {
        return RequestEntity.RequestEntityBuilder.createBuilder()
                .setId(dto.getId())
                .setVehicleId(dto.getVehicleId())
                .setIdType(dto.getIdType())
                .build();
    }

    @Override
    public Request toDto(RequestEntity entity) {
        return Request.RequestBuilder.createBuilder()
                .setId(entity.getId())
                .setVehicleId(entity.getVehicleId())
                .setIdType(entity.getIdType())
                .build();
    }
}
