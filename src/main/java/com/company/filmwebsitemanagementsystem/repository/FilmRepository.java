package com.company.filmwebsitemanagementsystem.repository;

import com.company.filmwebsitemanagementsystem.model.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FilmRepository extends JpaRepository<Film,Long> {
    List<Film> findByNameAndActiveTrue(String name);

    @Modifying
    @Query("update Film set active = false where id=:id")
    void deleteFilmById(long id);
}

