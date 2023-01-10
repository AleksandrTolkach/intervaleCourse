package by.tolkach.adapter.service.rest.template;

import by.tolkach.adapter.model.IdType;

import java.util.UUID;

public class RequestTemplate {
    private UUID requestId;
    private String vehicleId;
    private IdType idType;

    public RequestTemplate(UUID requestId, String vehicleId, IdType idType) {
        this.requestId = requestId;
        this.vehicleId = vehicleId;
        this.idType = idType;
    }

    public UUID getRequestId() {
        return requestId;
    }

    public void setRequestId(UUID requestId) {
        this.requestId = requestId;
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

    public static class RequestTemplateBuilder {
        private UUID requestId;
        private String vehicleId;
        private IdType idType;

        private RequestTemplateBuilder() {
            }

        public static RequestTemplateBuilder createBuilder() {
            return new RequestTemplateBuilder();
        }

        public void setRequestId(UUID requestId) {
            this.requestId = requestId;
        }

        public RequestTemplateBuilder setVehicleId(String vehicleId) {
            this.vehicleId = vehicleId;
            return this;
        }

        public RequestTemplateBuilder setIdType(IdType idType) {
            this.idType = idType;
            return this;
        }

        public RequestTemplate build() {
            return new RequestTemplate(requestId, vehicleId, idType);
        }
    }
}
