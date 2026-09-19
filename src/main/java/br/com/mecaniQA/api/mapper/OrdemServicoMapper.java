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

        return OrdemServico.builder()
                .descricao(dto.getDescricao())
                .cliente(dto.getCliente())
                .veiculo(dto.getVeiculo())
                .status(StatusOrdemServico.ABERTA)
                .build();
    }

    public static OrdemServicoResponseDTO toDTO(OrdemServico salva) {
        if (salva == null) {
            return null;
        }

        return new OrdemServicoResponseDTO(
                salva.getCodigo(),
                salva.getDescricao(),
                salva.getCliente(),
                salva.getVeiculo(),
                salva.getStatus()
        );
    }
}