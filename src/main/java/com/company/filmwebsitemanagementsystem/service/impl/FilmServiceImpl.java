package com.company.filmwebsitemanagementsystem.service.impl;

import com.company.filmwebsitemanagementsystem.mapper.FilmMapper;
import com.company.filmwebsitemanagementsystem.model.dto.request.FilmRequest;
import com.company.filmwebsitemanagementsystem.model.dto.response.FilmResponse;
import com.company.filmwebsitemanagementsystem.model.entity.Film;
import com.company.filmwebsitemanagementsystem.model.enums.Exceptions;
import com.company.filmwebsitemanagementsystem.model.exception.ApplicationException;
import com.company.filmwebsitemanagementsystem.repository.FilmRepository;
import com.company.filmwebsitemanagementsystem.service.FilmService;
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
public class FilmServiceImpl implements FilmService {
    private final FilmRepository filmRepository;
    private final FilmMapper filmMapper;
    @Override
    public FilmResponse createFilm(FilmRequest request) {
        Film film = filmMapper.mapToFilmFromFilmRequest(request);
        Film savedFilm = filmRepository.save(film);
        log.info("Film created successfully!");
        FilmResponse filmResponse = filmMapper.mapToFilmResponseFromFilm(savedFilm);

        return filmResponse;
    }

    @Override
    public FilmResponse updateFilm(Long id, FilmRequest request) {
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(Exceptions.FILM_NOT_FOUND));

        Film updatedFilm = filmMapper.mapForUpdate(film, request);

        Film savedFilm = filmRepository.save(updatedFilm);
        return filmMapper.mapToFilmResponseFromFilm(savedFilm);
    }

    @Override
    public void deleteFilm(Long id) {
        filmRepository.deleteFilmById(id);
    }

    @Override
    public FilmResponse findFilmById(Long id) {
        Film film = filmRepository
                .findById(id)
                .orElseThrow(() -> new ApplicationException(Exceptions.FILM_NOT_FOUND));
        FilmResponse filmResponse = filmMapper.mapToFilmResponseFromFilm(film);
        return filmResponse;
    }

    @Override
    public List<FilmResponse> findByName(String name) {
        List<FilmResponse> responseList = null;
        try {
            List<Film> filmList = filmRepository.findByName(name);
            responseList = filmList.stream()
                    .map(filmMapper::mapToFilmResponseFromFilm)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Film not Found By Name:" + name);
            e.getMessage();
        }
        return responseList;
    }

    @Override
    public List<FilmResponse> findAllFilm() {
        List<Film> allFilm = filmRepository.findAll();
        return allFilm.stream()
                .map(filmMapper::mapToFilmResponseFromFilm)
                .collect(Collectors.toList());
    }
}
