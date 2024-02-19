package com.company.filmwebsitemanagementsystem.repository;

import com.company.filmwebsitemanagementsystem.model.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    List<Genre> findByNameAndActiveTrue(String name);

    @Modifying
    @Query("update Genre set active = false where id=:id")
    void deleteGenreById(long id);
}
