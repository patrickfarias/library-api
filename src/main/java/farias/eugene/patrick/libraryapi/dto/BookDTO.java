package farias.eugene.patrick.libraryapi.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    Long id;
    String title;
    String author;
    String isbn;
}
