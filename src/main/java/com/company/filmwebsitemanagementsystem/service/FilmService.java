package com.company.filmwebsitemanagementsystem.service;

import com.company.filmwebsitemanagementsystem.model.dto.request.FilmRequest;
import com.company.filmwebsitemanagementsystem.model.dto.response.FilmResponse;

import java.util.List;

public interface FilmService {
    FilmResponse createFilm(FilmRequest request);

    FilmResponse updateFilm(Long id, FilmRequest request);

    void deleteFilm(Long id);

    FilmResponse findFilmById(Long id);

    List<FilmResponse> findByName (String name);

    List<FilmResponse> findAllFilm();

}
