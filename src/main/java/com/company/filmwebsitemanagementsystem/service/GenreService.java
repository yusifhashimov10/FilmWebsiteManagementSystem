package com.company.filmwebsitemanagementsystem.service;

import com.company.filmwebsitemanagementsystem.model.dto.request.GenreRequest;
import com.company.filmwebsitemanagementsystem.model.dto.response.GenreResponse;


import java.util.List;

public interface GenreService {

    GenreResponse createGenre(GenreRequest request);

    GenreResponse updateGenre(Long id, GenreRequest request);

    void deleteGenre(Long id);

    GenreResponse findGenreById(Long id);

    List<GenreResponse> findByName (String name);

    List<GenreResponse> findAllGenre();






}
