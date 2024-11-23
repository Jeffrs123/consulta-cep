package br.com.prservicos.cep.service;

import br.com.prservicos.cep.model.dto.CepResponseDTO;
import br.com.prservicos.cep.model.dto.ConsultLogDTO;
import br.com.prservicos.cep.repository.ConsultaLogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AdmService {

    private final ConsultaLogRepository logRepository;


    public AdmService(ConsultaLogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public Page<ConsultLogDTO> listLogs(Pageable pageable) {
        return logRepository.findAll(pageable).map(consultLogEntity -> ConsultLogDTO.builder()
                .id(consultLogEntity.getId())
                .cep(consultLogEntity.getCep())
                .resposta(consultLogEntity.getResposta())
                .provider(consultLogEntity.getProvider())
                .horarioConsulta(consultLogEntity.getHorarioConsulta())
                .build());
    }
}
