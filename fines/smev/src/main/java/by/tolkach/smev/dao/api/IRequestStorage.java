package by.tolkach.smev.dao.api;

import by.tolkach.smev.dao.api.entity.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IRequestStorage extends JpaRepository<RequestEntity, UUID> {
    void deleteById(UUID id);
}
