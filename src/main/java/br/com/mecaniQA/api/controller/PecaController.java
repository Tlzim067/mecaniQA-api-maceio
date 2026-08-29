package br.com.mecaniQA.api.controller;

import br.com.mecaniQA.api.model.Peca;
import br.com.mecaniQA.api.repository.PecaRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/pecas")
public class PecaController {

    private final PecaRepository repository;

    public PecaController() {
        this.repository = PecaRepository.getInstance();
    }

    @PostMapping
    public ResponseEntity<Peca> criar(@RequestBody Peca peca) {

        LocalDateTime agora = LocalDateTime.now();

        peca.setDataCadastro(agora);
        peca.setDataAtualizacao(agora);

        Peca novaPeca = repository.salvar(peca);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(novaPeca);
    }

    @GetMapping
    public ResponseEntity<List<Peca>> listar() {

        return ResponseEntity.ok(repository.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Peca> buscarPorId(@PathVariable Long id) {

        Peca peca = repository.buscarPorId(id);

        if (peca == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(peca);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Peca> atualizar(
            @PathVariable Long id,
            @RequestBody Peca dados) {

        Peca peca = repository.atualizar(id, dados);

        if (peca == null) {
            return ResponseEntity.notFound().build();
        }

        peca.setDataAtualizacao(LocalDateTime.now());

        return ResponseEntity.ok(peca);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {

        boolean excluido = repository.excluir(id);

        if (!excluido) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}