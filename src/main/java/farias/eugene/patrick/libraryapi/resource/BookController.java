package farias.eugene.patrick.libraryapi.resource;

import farias.eugene.patrick.libraryapi.dto.BookDTO;
import farias.eugene.patrick.libraryapi.model.entity.Book;
import farias.eugene.patrick.libraryapi.service.BookService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
//@RequiredArgsConstructor
public class BookController {

    private final BookService service;
    private ModelMapper modelMapper;

    public BookController(BookService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO create( @RequestBody BookDTO dto ){

       Book entity  = modelMapper.map(dto, Book.class);

       entity = service.save(entity);

        return modelMapper.map(entity, BookDTO.class);

    }
}
