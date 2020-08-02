package farias.eugene.patrick.libraryapi.service.impl;

import farias.eugene.patrick.libraryapi.model.entyty.Book;
import farias.eugene.patrick.libraryapi.model.repository.BookRepository;
import farias.eugene.patrick.libraryapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl  implements BookService {

    @Autowired
    private BookRepository repository;

    public BookServiceImpl(BookRepository repository) {

        this.repository = repository;
    }

    @Override
    public Book save(Book book) {

    return repository.save(book);

   }
}
