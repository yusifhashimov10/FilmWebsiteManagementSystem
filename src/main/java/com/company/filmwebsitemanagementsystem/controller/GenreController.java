package com.company.filmwebsitemanagementsystem.controller;

import com.company.filmwebsitemanagementsystem.model.dto.request.GenreRequest;
import com.company.filmwebsitemanagementsystem.model.dto.response.GenreResponse;
import com.company.filmwebsitemanagementsystem.service.GenreService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/genre")
public class GenreController {
    private final GenreService genreService;

    @PostMapping()
    @Operation(summary = "Create Genre")
    public ResponseEntity<GenreResponse> createGenre(@RequestBody GenreRequest request) {
        GenreResponse response = genreService.createGenre(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    @Operation(summary = "Find Genre by Id")
    public ResponseEntity<GenreResponse> findGenreById(@PathVariable long id) {
        GenreResponse response = genreService.findGenreById(id);
        return ResponseEntity.ok(response);

    }

    @GetMapping("name/{name}")
    @Operation(summary = "Find Genre By Name")
    public ResponseEntity<List<GenreResponse>> findByName(@PathVariable String name) {
         List<GenreResponse> response = genreService.findByName(name);
        return ResponseEntity.ok(response);
    }

    @GetMapping("all")
    @Operation(summary = "Find All Genre ")
    public ResponseEntity<List<GenreResponse>> findAllGenre() {
         List<GenreResponse> all = genreService.findAllGenre();
        return ResponseEntity.ok(all);

    }

    @PutMapping("{id}")
    @Operation(summary = "Update Genre")
    public ResponseEntity<GenreResponse> updateGenre(@RequestBody GenreRequest request,
                                              @PathVariable long id) {
         GenreResponse genreResponse = genreService.updateGenre(id, request);
        return ResponseEntity.ok(genreResponse);

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Genre")
    public ResponseEntity<Void> deleteGenre(@PathVariable long id){
        genreService.deleteGenre(id);
        return ResponseEntity.noContent().build();
    }
}
