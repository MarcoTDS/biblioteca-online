
package br.edu.ifpr.biblioteca_spring.exception;

import java.util.NoSuchElementException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public String handleNotFound(Exception ex, Model model) {
        model.addAttribute("mensagem", "Recurso não encontrado.");
        return "error/404";
    }

    @ExceptionHandler(Exception.class)
    public String handleGeneric(Exception ex, Model model) {
        model.addAttribute("mensagem", "Erro inesperado: " + ex.getMessage());
        return "error/500";
    }
}
