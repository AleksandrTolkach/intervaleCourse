package by.tolkach.smev.dao.api.entity;

import by.tolkach.smev.model.IdType;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "request")
public class RequestEntity {
    @Id
    private UUID id;
    private String vehicleId;
    @Enumerated(EnumType.STRING)
    private IdType idType;

    public RequestEntity() {
    }

    public RequestEntity(UUID id, String vehicleId, IdType idType) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.idType = idType;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public IdType getIdType() {
        return idType;
    }

    public void setIdType(IdType idType) {
        this.idType = idType;
    }

    public static class RequestEntityBuilder {
        private UUID id;
        private String vehicleId;
        private IdType idType;

        private RequestEntityBuilder() {}

        public static RequestEntityBuilder createBuilder() {
            return new RequestEntityBuilder();
        }

        public RequestEntityBuilder setId(UUID id) {
            this.id = id;
            return this;
        }

        public RequestEntityBuilder setVehicleId(String vehicleId) {
            this.vehicleId = vehicleId;
            return this;
        }

        public RequestEntityBuilder setIdType(IdType idType) {
            this.idType = idType;
            return this;
        }

        public RequestEntity build() {
            return new RequestEntity(this.id, this.vehicleId, this.idType);
        }
    }
}
