package by.tolkach.smev.dao.api.entity.converter;

public interface IEntityConverter<D, E> {

    E toEntity(D dto);
    D toDto(E entity);
}
