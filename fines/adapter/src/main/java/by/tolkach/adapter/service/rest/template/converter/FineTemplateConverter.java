package by.tolkach.adapter.service.rest.template.converter;

import by.tolkach.adapter.model.Fine;
import by.tolkach.adapter.service.rest.template.FineTemplate;
import org.springframework.stereotype.Component;

@Component
public class FineTemplateConverter implements ITemplateConverter<Fine, FineTemplate> {

    @Override
    public FineTemplate toTemplate(Fine dto) {
        return FineTemplate.FineTemplateBuilder.createBuilder()
                .setIncomeSum(dto.getIncomeSum())
                .setPaymentSum(dto.getPaymentSum())
                .setDecreeNumber(dto.getDecreeNumber())
                .setVehicleId(dto.getVehicleId())
                .setDate(dto.getDate())
                .setArticle(dto.getArticle())
                .build();
    }

    @Override
    public Fine toDto(FineTemplate template) {
        return Fine.FineBuilder.createBuilder()
                .setIncomeSum(template.getIncomeSum())
                .setPaymentSum(template.getPaymentSum())
                .setDecreeNumber(template.getDecreeNumber())
                .setVehicleId(template.getVehicleId())
                .setDate(template.getDate())
                .setArticle(template.getArticle())
                .build();
    }
}
