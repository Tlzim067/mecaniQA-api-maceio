package br.com.mecaniQA.api.controller;

import br.com.mecaniQA.api.model.Servico;
import br.com.mecaniQA.api.repository.ServicoRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/servicos")
public class ServicoController {

    private final ServicoRepository repository;

    public ServicoController() {
        this.repository = ServicoRepository.getInstance();
    }

    @PostMapping
    public ResponseEntity<Servico> criar(@RequestBody Servico servico) {

        LocalDateTime agora = LocalDateTime.now();

        servico.setDataCriacao(agora);
        servico.setDataAtualizacao(agora);

        Servico novoServico = repository.salvar(servico);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(novoServico);
    }

    @GetMapping
    public ResponseEntity<List<Servico>> listar() {

        return ResponseEntity.ok(repository.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servico> buscarPorId(@PathVariable Long id) {

        Servico servico = repository.buscarPorId(id);

        if (servico == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(servico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servico> atualizar(
            @PathVariable Long id,
            @RequestBody Servico dados) {

        Servico servico = repository.atualizar(id, dados);

        if (servico == null) {
            return ResponseEntity.notFound().build();
        }

        servico.setDataAtualizacao(LocalDateTime.now());

        return ResponseEntity.ok(servico);
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