package br.com.mecaniQA.api.controller;

import br.com.mecaniQA.api.exception.RecursoNaoEncontradoException;
import br.com.mecaniQA.api.model.Peca;
import br.com.mecaniQA.api.repository.PecaRepositoryJdbc;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pecas")
public class PecaController {

    private final PecaRepositoryJdbc pecaRepository = new PecaRepositoryJdbc();

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        try {
            Peca peca = pecaRepository.buscarPorId(id);
            if (peca == null) {
                throw new RecursoNaoEncontradoException("Peça com ID " + id + " não encontrada.");
            }
            return ResponseEntity.ok(peca);
            
        } catch (RecursoNaoEncontradoException e) {
            // Tratamento manual exigido pela OAT 3 (Sem @ExceptionHandler)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno: " + e.getMessage());
        }
    }
}