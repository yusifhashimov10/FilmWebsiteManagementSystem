package com.company.filmwebsitemanagementsystem.model.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@Getter
public enum Exceptions {
    GENRE_NOT_FOUND(HttpStatus.NOT_FOUND,"Genre not found!" ),
    FILM_NOT_FOUND(HttpStatus.NOT_FOUND,"Film not found!" ),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND,"User not found!" );

    private final HttpStatus status;
    private final String message;
    private final LocalDateTime time= LocalDateTime.now().withNano(0);

    Exceptions(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
