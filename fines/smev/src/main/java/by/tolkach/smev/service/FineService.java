package by.tolkach.smev.service;

import by.tolkach.smev.dao.api.IFineStorage;
import by.tolkach.smev.dao.api.entity.FineEntity;
import by.tolkach.smev.dao.api.entity.converter.IEntityConverter;
import by.tolkach.smev.model.Fine;
import by.tolkach.smev.service.api.IFineService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FineService implements IFineService {
    private IFineStorage fineStorage;
    private IEntityConverter<Fine, FineEntity> fineEntityConverter;

    public FineService(IFineStorage fineStorage, IEntityConverter<Fine, FineEntity> fineEntityConverter) {
        this.fineStorage = fineStorage;
        this.fineEntityConverter = fineEntityConverter;
    }

    @Override
    public void create(Fine fine) {
        this.fineStorage.save(this.fineEntityConverter.toEntity(fine));
    }

    @Override
    public void createList(List<Fine> fines) {
        this.fineStorage.saveAll(fines.stream().map(this.fineEntityConverter::toEntity).collect(Collectors.toList()));
    }

    @Override
    public Fine readByVehicleId(String vehicleId) {
        return this.fineEntityConverter.toDto(this.fineStorage.findByVehicleId(vehicleId));
    }

    @Override
    public Fine read(UUID fineId) {
        return this.fineEntityConverter.toDto(this.fineStorage.findById(fineId).orElse(null));
    }

    @Override
    public long count() {
        return this.fineStorage.count();
    }
}
