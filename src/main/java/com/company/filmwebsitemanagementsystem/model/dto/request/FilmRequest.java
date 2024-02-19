package com.company.filmwebsitemanagementsystem.model.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FilmRequest {
     String name;
     String description;
     LocalDate releaseDate;
     Long userId;
}
