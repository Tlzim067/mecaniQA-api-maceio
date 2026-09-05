package br.com.mecaniQA.api.mapper;

import br.com.mecaniQA.api.dto.OrdemServicoRequestDTO;
import br.com.mecaniQA.api.dto.OrdemServicoResponseDTO;
import br.com.mecaniQA.api.model.OrdemServico;
import br.com.mecaniQA.api.model.StatusOrdemServico;

public class OrdemServicoMapper {

   public static OrdemServico toEntity(OrdemServicoRequestDTO dto) {
    if (dto == null) {
        return null;
    }

    return new OrdemServico(
            null,
            dto.getDescricao(),
            dto.getCliente(),
            dto.getVeiculo(),
            StatusOrdemServico.ABERTA
    );
}

    public static OrdemServicoResponseDTO toDTO(OrdemServico salva) {
        if (salva == null) return null;
        return new OrdemServicoResponseDTO(
                salva.getId(),
                salva.getDescricao(),
                salva.getCliente(),
                salva.getVeiculo(),
                salva.getStatus()
        );
    }
}