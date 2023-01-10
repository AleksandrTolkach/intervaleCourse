package by.tolkach.adapter.model;

public class Request {
    private String vehicleId;
    private IdType idType;

    public Request(String vehicleId, IdType idType) {
        this.vehicleId = vehicleId;
        this.idType = idType;
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
        private String vehicleId;
        private IdType idType;

        private RequestBuilder() {
        }

        public static RequestBuilder createBuilder() {
            return new RequestBuilder();
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
            return new Request(vehicleId, idType);
        }
    }
}
