package by.tolkach.adapter.model;

public class Request {
    private String identifier;
    private IdType idType;

    public Request(String identifier, IdType idType) {
        this.identifier = identifier;
        this.idType = idType;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public IdType getIdType() {
        return idType;
    }

    public void setIdType(IdType idType) {
        this.idType = idType;
    }

    public static class RequestBuilder {
        private String identifier;
        private IdType idType;

        private RequestBuilder() {
        }

        public static RequestBuilder createBuilder() {
            return new RequestBuilder();
        }

        public RequestBuilder setIdentifier(String identifier) {
            this.identifier = identifier;
            return this;
        }

        public RequestBuilder setIdType(IdType idType) {
            this.idType = idType;
            return this;
        }

        public Request build() {
            return new Request(identifier, idType);
        }
    }
}
