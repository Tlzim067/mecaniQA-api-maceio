package br.com.mecaniQA.api.service;

import org.springframework.stereotype.Service;

import br.com.mecaniQA.api.dto.OrdemServicoRequestDTO;
import br.com.mecaniQA.api.dto.OrdemServicoResponseDTO;
import br.com.mecaniQA.api.model.OrdemServico; // <-- Import correto do model
import br.com.mecaniQA.api.mapper.OrdemServicoMapper;
import br.com.mecaniQA.api.model.StatusOrdemServico;
import br.com.mecaniQA.api.repository.OrdemServicoRepository;

@Service
public class OrdemServicoService {

    private final OrdemServicoRepository repository;

    public OrdemServicoService(OrdemServicoRepository repository) {
        this.repository = repository;
    }

    // US01 - Criar OS
    public OrdemServicoResponseDTO criar(OrdemServicoRequestDTO dto) {
        OrdemServico os = OrdemServicoMapper.toEntity(dto);
        OrdemServico salva = repository.salvar(os);
        return OrdemServicoMapper.toDTO(salva);
    }

    // US02 - Modificar Status da OS
    public OrdemServicoResponseDTO atualizarStatus(Long id, StatusOrdemServico novoStatus) {
        // CORRIGIDO: alterado de br.com.mecaniQA.api.mapper.OrdemServico para OrdemServico
        OrdemServico os = repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Ordem de Serviço não encontrada"));
        os.setStatus(novoStatus);
        repository.salvar(os);
        return OrdemServicoMapper.toDTO(os);
    }
}