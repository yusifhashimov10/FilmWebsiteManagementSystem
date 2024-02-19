package com.company.filmwebsitemanagementsystem.mapper;

import com.company.filmwebsitemanagementsystem.model.dto.request.FilmRequest;
import com.company.filmwebsitemanagementsystem.model.dto.response.FilmResponse;
import com.company.filmwebsitemanagementsystem.model.entity.Film;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface FilmMapper {
    FilmResponse mapToFilmResponseFromFilm(Film film);
    Film mapToFilmFromFilmRequest(FilmRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    Film mapForUpdate(@MappingTarget Film film, FilmRequest request);
}
