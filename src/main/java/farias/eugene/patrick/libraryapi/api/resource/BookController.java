package farias.eugene.patrick.libraryapi.api.resource;

import farias.eugene.patrick.libraryapi.api.dto.BookDTO;
import farias.eugene.patrick.libraryapi.model.entyty.Book;
import farias.eugene.patrick.libraryapi.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService service;

    @Autowired
    private ModelMapper modelMapper;

//    public BookController(BookService service, ModelMapper modelMapper) {
//        this.service = service;
//        this.modelMapper = modelMapper;
//    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO create( @RequestBody BookDTO dto ){

       Book entity  = modelMapper.map(dto, Book.class);

       entity = service.save(entity);

        return modelMapper.map(entity, BookDTO.class);

    }
}
