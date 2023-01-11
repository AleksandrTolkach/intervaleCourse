package by.tolkach.adapter.service.api;

import by.tolkach.adapter.model.Fine;
import by.tolkach.adapter.model.Request;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
public interface IAdapterService {

    Fine fineRequest(@Valid Request request);
}
