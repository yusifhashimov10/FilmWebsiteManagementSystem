package com.company.filmwebsitemanagementsystem.model.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExceptionResponse {

    String message;
    Integer status;

    @Builder.Default
    LocalDateTime time= LocalDateTime.now().withNano(0);
}
