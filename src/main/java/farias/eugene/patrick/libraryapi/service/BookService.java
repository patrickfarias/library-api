package farias.eugene.patrick.libraryapi.service;

import farias.eugene.patrick.libraryapi.model.entity.Book;
import org.springframework.stereotype.Service;


public interface BookService {
    Book save(Book any);
}
