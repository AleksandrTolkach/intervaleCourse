package by.tolkach.smev.dao.api;

import by.tolkach.smev.dao.api.entity.ResponseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IResponseStorage extends JpaRepository<ResponseEntity, UUID> {
    ResponseEntity findByRequestId(UUID requestId);

}
