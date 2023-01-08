package by.tolkach.adapter.service.rest.template.converter;

public interface ITemplateConverter<D, T> {

    T toTemplate(D dto);
    D toDto(T template);
}
