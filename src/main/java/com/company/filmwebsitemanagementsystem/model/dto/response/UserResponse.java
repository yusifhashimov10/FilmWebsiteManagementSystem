package com.company.filmwebsitemanagementsystem.model.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
     Long id;
     String name;
     String surname;
     LocalDate signUpDate;
     String email;
     boolean active;
     List<FilmResponse> filmList;
}
