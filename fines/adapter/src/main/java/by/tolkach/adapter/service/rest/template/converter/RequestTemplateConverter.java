package by.tolkach.adapter.service.rest.template.converter;

import by.tolkach.adapter.model.Request;
import by.tolkach.adapter.service.rest.template.RequestTemplate;
import org.springframework.stereotype.Component;

@Component
public class RequestTemplateConverter implements ITemplateConverter<Request, RequestTemplate> {
    @Override
    public RequestTemplate toTemplate(Request dto) {
        return RequestTemplate.RequestTemplateBuilder.createBuilder()
                .setVehicleId(dto.getVehicleId())
                .setIdType(dto.getIdType())
                .build();
    }

    @Override
    public Request toDto(RequestTemplate template) {
        return Request.RequestBuilder.createBuilder()
                .setVehicleId(template.getVehicleId())
                .setIdType(template.getIdType())
                .build();
    }
}
