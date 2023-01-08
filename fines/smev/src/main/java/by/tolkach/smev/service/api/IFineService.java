package by.tolkach.smev.service.api;

import by.tolkach.smev.model.Fine;

import java.util.List;
import java.util.UUID;

public interface IFineService {
    void create(Fine fine);
    void createList(List<Fine> fines);
    Fine readByVehicleId(String vehicleId);
    Fine read(UUID fineId);
    long count();
}
