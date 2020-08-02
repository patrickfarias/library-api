package farias.eugene.patrick.libraryapi.model.repository;

import farias.eugene.patrick.libraryapi.model.entyty.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository  extends JpaRepository<Book, Long> {

}
