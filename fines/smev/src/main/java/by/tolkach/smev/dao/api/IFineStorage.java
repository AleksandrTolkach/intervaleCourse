package by.tolkach.smev.dao.api;

import by.tolkach.smev.dao.api.entity.FineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IFineStorage extends JpaRepository<FineEntity, UUID> {

    FineEntity findBySts(String sts);
}
