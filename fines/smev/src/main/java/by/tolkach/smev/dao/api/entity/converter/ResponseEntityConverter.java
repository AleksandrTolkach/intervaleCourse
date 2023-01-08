package by.tolkach.smev.dao.api.entity.converter;

import by.tolkach.smev.dao.api.entity.ResponseEntity;
import by.tolkach.smev.model.Response;
import org.springframework.stereotype.Component;

@Component
public class ResponseEntityConverter implements IEntityConverter<Response, ResponseEntity> {
    @Override
    public ResponseEntity toEntity(Response dto) {
        return ResponseEntity.ResponseEntityBuilder.createBuilder()
                .setId(dto.getId())
                .setRequestId(dto.getRequestId())
                .setFineId(dto.getFineId())
                .build();
    }

    @Override
    public Response toDto(ResponseEntity entity) {
        return Response.ResponseBuilder.createBuilder()
                .setId(entity.getId())
                .setRequestId(entity.getRequestId())
                .setFineId(entity.getFineId())
                .build();
    }
}
