package farias.eugene.patrick.libraryapi.api.exception;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.BindingResult;

@Getter
@Setter
public class ApiErrors {

    List<String> errors;

    public ApiErrors(BindingResult bindingResult){
        this.errors = new ArrayList<>();

        // getAllErrors pega todos os erros que aconteceram na validacao
        bindingResult.getAllErrors().forEach( error -> this.errors.add(error.getDefaultMessage()) );
    }


}
