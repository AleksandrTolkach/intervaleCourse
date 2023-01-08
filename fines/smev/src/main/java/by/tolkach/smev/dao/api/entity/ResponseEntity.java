package by.tolkach.smev.dao.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "responses")
public class ResponseEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private UUID requestId;
    private UUID fineId;

    public ResponseEntity() {
    }

    public ResponseEntity(UUID id, UUID requestId, UUID fineId) {
        this.id = id;
        this.requestId = requestId;
        this.fineId = fineId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getRequestId() {
        return requestId;
    }

    public void setRequestId(UUID requestId) {
        this.requestId = requestId;
    }

    public UUID getFineId() {
        return fineId;
    }

    public void setFineId(UUID fineId) {
        this.fineId = fineId;
    }

    public static class ResponseEntityBuilder {
        private UUID id;
        private UUID requestId;
        private UUID fineId;

        private ResponseEntityBuilder() {}

        public static ResponseEntityBuilder createBuilder() {
            return new ResponseEntityBuilder();
        }

        public ResponseEntityBuilder setId(UUID id) {
            this.id = id;
            return this;
        }

        public ResponseEntityBuilder setRequestId(UUID requestId) {
            this.requestId = requestId;
            return this;
        }

        public ResponseEntityBuilder setFineId(UUID fineId) {
            this.fineId = fineId;
            return this;
        }

        public ResponseEntity build() {
            return new ResponseEntity(this.id, this.requestId, this.fineId);
        }
    }
}
