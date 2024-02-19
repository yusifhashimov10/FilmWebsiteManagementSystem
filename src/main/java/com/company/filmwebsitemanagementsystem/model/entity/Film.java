package com.company.filmwebsitemanagementsystem.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String description;
    LocalDate releaseDate;
    boolean active;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    Genre genre;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

}
