package by.tolkach.smev.model;

import java.util.UUID;

public class Request {
    private UUID id;
    private String vehicleId;
    private IdType idType;

    public Request(UUID id, String vehicleId, IdType idType) {
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

    public static class RequestBuilder {
        private UUID id;
        private String vehicleId;
        private IdType idType;

        private RequestBuilder() {}

        public static RequestBuilder createBuilder() {
            return new RequestBuilder();
        }

        public RequestBuilder setId(UUID id) {
            this.id = id;
            return this;
        }

        public RequestBuilder setVehicleId(String vehicleId) {
            this.vehicleId = vehicleId;
            return this;
        }

        public RequestBuilder setIdType(IdType idType) {
            this.idType = idType;
            return this;
        }

        public Request build() {
            return new Request(this.id, this.vehicleId, this.idType);
        }
    }
}
