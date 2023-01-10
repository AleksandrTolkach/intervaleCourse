package by.tolkach.smev.dao.api.entity.converter;

import by.tolkach.smev.dao.api.entity.FineEntity;
import by.tolkach.smev.model.Fine;
import org.springframework.stereotype.Component;

@Component
public class FineEntityConverter implements IEntityConverter<Fine, FineEntity> {
    @Override
    public FineEntity toEntity(Fine dto) {
        return FineEntity.FineEntityBuilder.createBuilder()
                .setId(dto.getId())
                .setIncomeSum(dto.getIncomeSum())
                .setPaymentSum(dto.getPaymentSum())
                .setDecreeNumber(dto.getDecreeNumber())
                .setVehicleId(dto.getVehicleId())
                .setDate(dto.getDate())
                .setArticle(dto.getArticle())
                .build();
    }

    @Override
    public Fine toDto(FineEntity entity) {
        return Fine.FineBuilder.createBuilder()
                .setId(entity.getId())
                .setIncomeSum(entity.getIncomeSum())
                .setPaymentSum(entity.getPaymentSum())
                .setDecreeNumber(entity.getDecreeNumber())
                .setVehicleId(entity.getVehicleId())
                .setDate(entity.getDate())
                .setArticle(entity.getArticle())
                .build();
    }
}
