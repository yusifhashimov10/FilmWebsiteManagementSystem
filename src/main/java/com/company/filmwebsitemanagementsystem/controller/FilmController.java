package com.company.filmwebsitemanagementsystem.controller;

import com.company.filmwebsitemanagementsystem.model.dto.request.FilmRequest;
import com.company.filmwebsitemanagementsystem.model.dto.response.FilmResponse;
import com.company.filmwebsitemanagementsystem.service.FilmService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/film")
public class FilmController {
    private final FilmService filmService;

    @PostMapping()
    @Operation(summary = "Create Film")
    public ResponseEntity<FilmResponse> createFilm(@RequestBody FilmRequest request) {
        FilmResponse response = filmService.createFilm(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    @Operation(summary = "Find Film by Id")
    public ResponseEntity<FilmResponse> findFilmById(@PathVariable long id) {
        FilmResponse response = filmService.findFilmById(id);
        return ResponseEntity.ok(response);

    }

    @GetMapping("name/{name}")
    @Operation(summary = "Find Film by Name")
    public ResponseEntity<List<FilmResponse>> findByName(@PathVariable String name) {
        List<FilmResponse> response = filmService.findByName(name);
        return ResponseEntity.ok(response);
    }

    @GetMapping("all")
    @Operation(summary = "Find All Film ")
    public ResponseEntity<List<FilmResponse>> findAllFilm() {
         List<FilmResponse> all = filmService.findAllFilm();
        return ResponseEntity.ok(all);

    }

    @PutMapping("{id}")
    @Operation(summary = "Update Film")
    public ResponseEntity<FilmResponse> updateFilm(@RequestBody FilmRequest request,
                                                     @PathVariable long id) {
         FilmResponse filmResponse = filmService.updateFilm(id, request);
        return ResponseEntity.ok(filmResponse);

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Film")
    public ResponseEntity<Void> deleteFilm(@PathVariable long id){
        filmService.deleteFilm(id);
        return ResponseEntity.noContent().build();
    }
}
