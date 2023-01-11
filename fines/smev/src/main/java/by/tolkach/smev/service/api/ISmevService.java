package by.tolkach.smev.service.api;

import by.tolkach.smev.model.Fine;
import by.tolkach.smev.model.Request;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Validated
public interface ISmevService {

    UUID createRequest(@Valid Request request);
    Fine getResponse(@Valid @NotNull UUID requestId);
    void deleteRequest(@Valid @NotNull UUID requestId);
}
