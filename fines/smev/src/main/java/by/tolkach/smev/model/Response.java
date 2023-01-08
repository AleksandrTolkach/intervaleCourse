package by.tolkach.smev.model;

import java.util.UUID;

public class Response {
    private UUID id;
    private UUID requestId;
    private UUID fineId;

    public Response(UUID id, UUID requestId, UUID fineId) {
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

    public static class ResponseBuilder {
        private UUID id;
        private UUID requestId;
        private UUID fineId;

        private ResponseBuilder() {}

        public static ResponseBuilder createBuilder() {
            return new ResponseBuilder();
        }

        public ResponseBuilder setId(UUID id) {
            this.id = id;
            return this;
        }

        public ResponseBuilder setRequestId(UUID requestId) {
            this.requestId = requestId;
            return this;
        }

        public ResponseBuilder setFineId(UUID fineId) {
            this.fineId = fineId;
            return this;
        }

        public Response build() {
            return new Response(id, requestId, fineId);
        }
    }
}
