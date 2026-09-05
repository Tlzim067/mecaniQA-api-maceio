package br.com.mecaniQA.api.controller;

import br.com.mecaniQA.api.dto.OrdemServicoRequestDTO;
import br.com.mecaniQA.api.dto.OrdemServicoResponseDTO;
import br.com.mecaniQA.api.model.StatusOrdemServico;
import br.com.mecaniQA.api.service.OrdemServicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ordens-servico")
public class OrdemServicoController {

    private final OrdemServicoService service;

    public OrdemServicoController(OrdemServicoService service) {
        this.service = service;
    }

    // US01: POST /api/ordens-servico - Criar uma nova Ordem de Serviço
    @PostMapping
    public ResponseEntity<OrdemServicoResponseDTO> criarOS(@RequestBody OrdemServicoRequestDTO dto) {
        OrdemServicoResponseDTO response = service.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // US02: PATCH /api/ordens-servico/{id}/status - Modificar status da Ordem de Serviço
    @PatchMapping("/{id}/status")
    public ResponseEntity<OrdemServicoResponseDTO> atualizarStatus(
            @PathVariable Long id,
            @RequestParam StatusOrdemServico status) {
        OrdemServicoResponseDTO response = service.atualizarStatus(id, status);
        return ResponseEntity.ok(response);
    }
}