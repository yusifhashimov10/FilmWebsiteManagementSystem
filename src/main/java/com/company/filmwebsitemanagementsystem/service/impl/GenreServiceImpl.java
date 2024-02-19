package com.company.filmwebsitemanagementsystem.service.impl;

import com.company.filmwebsitemanagementsystem.mapper.GenreMapper;
import com.company.filmwebsitemanagementsystem.model.dto.request.GenreRequest;
import com.company.filmwebsitemanagementsystem.model.dto.response.GenreResponse;
import com.company.filmwebsitemanagementsystem.model.entity.Genre;
import com.company.filmwebsitemanagementsystem.model.enums.Exceptions;
import com.company.filmwebsitemanagementsystem.model.exception.ApplicationException;
import com.company.filmwebsitemanagementsystem.repository.GenreRepository;
import com.company.filmwebsitemanagementsystem.service.GenreService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;
    @Override
    public GenreResponse createGenre(GenreRequest request) {
        Genre genre = genreMapper.mapToGenreFromGenreRequest(request);
        Genre savedGenre = genreRepository.save(genre);
        log.info("Genre created successfully!");
        GenreResponse genreResponse = genreMapper.mapToGenreResponseFromGenre(savedGenre);

        return genreResponse;
    }

    @Override
    public GenreResponse updateGenre(Long id, GenreRequest request) {
         Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(Exceptions.GENRE_NOT_FOUND));

       Genre updatedGenre = genreMapper.mapForUpdate(genre, request);

       Genre savedBook = genreRepository.save(updatedGenre);
        return genreMapper.mapToGenreResponseFromGenre(savedBook);
    }

    @Override
    public void deleteGenre(Long id) {
        genreRepository.deleteGenreById(id);

    }

    @Override
    public GenreResponse findGenreById(Long id) {
        Genre genre = genreRepository
                .findById(id)
                .orElseThrow(() -> new ApplicationException(Exceptions.GENRE_NOT_FOUND));
        GenreResponse genreResponse = genreMapper.mapToGenreResponseFromGenre(genre);
        return genreResponse;
    }

    @Override
    public List<GenreResponse> findByName(String name) {
        List<GenreResponse> responseList = null;
        try {
             List<Genre> genreList = genreRepository.findByName(name);
            responseList = genreList.stream()
                    .map(genreMapper::mapToGenreResponseFromGenre)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Genre not Found By Name:" + name);
            e.getMessage();
        }
        return responseList;
    }

    @Override
    public List<GenreResponse> findAllGenre() {
         List<Genre> allGenre = genreRepository.findAll();
        return allGenre.stream()
                .map(genreMapper::mapToGenreResponseFromGenre)
                .collect(Collectors.toList());
    }
}
