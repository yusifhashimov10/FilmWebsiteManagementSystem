package com.company.filmwebsitemanagementsystem.model.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GenreResponse {
     Long id;
     String name;
     String description;
     boolean active;
     List<FilmResponse> films;

}
