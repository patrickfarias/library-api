package farias.eugene.patrick.libraryapi.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import farias.eugene.patrick.libraryapi.api.dto.BookDTO;
import farias.eugene.patrick.libraryapi.api.resource.BookController;
import farias.eugene.patrick.libraryapi.model.entyty.Book;
import farias.eugene.patrick.libraryapi.service.BookService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test") // ativa o profile de teste
@WebMvcTest(controllers = BookController.class) // Testa o comportamento do controller
@AutoConfigureMockMvc // Configura um Objeto para estar fazendo as requisicoes
public class BookControllerTest {

   static String BOOK_API = "/api/books";

    @Autowired
    MockMvc mvc; // Mock das requisicoes da nossa API

    @MockBean
    BookService service;

    @Test
    @DisplayName("Deve criar um livro com sucesso.")
    public void createBookTest() throws Exception {

        BookDTO dto = createNewBook();

        Book savedBook = Book.builder().id(10l).author("Artur").title("As aventuras").isbn("001").build();

        // Simula o comportamento do service, forcando o retorno esperado.
        BDDMockito.given(service.save(Mockito.any(Book.class))).willReturn(savedBook);

        String json = new ObjectMapper().writeValueAsString(dto);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post(BOOK_API)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);

        mvc
                .perform(request)
                .andExpect( status().isCreated() )
                .andExpect( jsonPath("id").value(10l) )
                .andExpect( jsonPath("title").value(dto.getTitle()) )
                .andExpect( jsonPath("author").value(dto.getAuthor()) )
                .andExpect( jsonPath("isbn").value(dto.getIsbn()) )
        ;
    }

    @Test
    @DisplayName("Deve lancar erro de validacao quando nao houver dados suficientes para criacao de um livro")
    public void createInvalidBookTest(){

    }

    private BookDTO createNewBook() {
        return BookDTO.builder().author("Artur").title("As aventuras").isbn("001").build();
    }

}