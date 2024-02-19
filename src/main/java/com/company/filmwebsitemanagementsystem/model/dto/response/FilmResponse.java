package com.company.filmwebsitemanagementsystem.model.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FilmResponse {
     Long id;
     String name;
     String description;
     LocalDate releaseDate;
     boolean active;
     Long userId;
     Long genreId;
}
