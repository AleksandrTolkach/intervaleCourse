package by.tolkach.adapter.service.rest.template;

import by.tolkach.adapter.model.IdType;

import java.util.UUID;

public class RequestTemplate {
    private UUID requestId;
    private String identifier;
    private IdType idType;

    public RequestTemplate(UUID requestId, String identifier, IdType idType) {
        this.requestId = requestId;
        this.identifier = identifier;
        this.idType = idType;
    }

    public UUID getRequestId() {
        return requestId;
    }

    public void setRequestId(UUID requestId) {
        this.requestId = requestId;
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

    public static class RequestTemplateBuilder {
        private UUID requestId;
        private String identifier;
        private IdType idType;

        private RequestTemplateBuilder() {
            }

        public static RequestTemplateBuilder createBuilder() {
            return new RequestTemplateBuilder();
        }

        public void setRequestId(UUID requestId) {
            this.requestId = requestId;
        }

        public RequestTemplateBuilder setIdentifier(String identifier) {
            this.identifier = identifier;
            return this;
        }

        public RequestTemplateBuilder setIdType(IdType idType) {
            this.idType = idType;
            return this;
        }

        public RequestTemplate build() {
            return new RequestTemplate(requestId, identifier, idType);
        }
    }
}
