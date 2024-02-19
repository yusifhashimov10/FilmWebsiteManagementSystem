package com.company.filmwebsitemanagementsystem.mapper;

import com.company.filmwebsitemanagementsystem.model.dto.request.GenreRequest;
import com.company.filmwebsitemanagementsystem.model.dto.response.GenreResponse;
import com.company.filmwebsitemanagementsystem.model.entity.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface GenreMapper {
    GenreResponse mapToGenreResponseFromGenre(Genre genre);

    Genre mapToGenreFromGenreRequest(GenreRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    Genre mapForUpdate(@MappingTarget Genre genre, GenreRequest request);
}
