package br.com.prservicos.cep.service;

import br.com.prservicos.cep.model.dto.CepResponseDTO;
import br.com.prservicos.cep.model.entity.ConsultLogEntity;
import br.com.prservicos.cep.provider.CepProvider;
import br.com.prservicos.cep.provider.CepProviderFactory;
import br.com.prservicos.cep.repository.ConsultaLogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class CepService {


    private static String CURRENT_PROVIDER = "mockoon"; // Default

    private final CepProviderFactory providerFactory;
    private final ConsultaLogRepository logRepository;


    public CepService(CepProviderFactory providerFactory, ConsultaLogRepository logRepository) {
        this.providerFactory = providerFactory;
        this.logRepository = logRepository;
    }

    public String updateCurrentProvider(String provider) {
        CURRENT_PROVIDER = provider;
        return "Provider atualizado para: " + CURRENT_PROVIDER;
    }

    public CepResponseDTO consultarCep(String cep) {
        CepProvider provider = providerFactory.getProvider(CURRENT_PROVIDER);
        CepResponseDTO cepResponseDTO;
        try {
            cepResponseDTO = provider.consultarCep(cep);
            cepResponseDTO.setFonte(CURRENT_PROVIDER);
            salvarLog(cep, cepResponseDTO.toString());
        } catch (Exception e) {
            salvarLog(cep, "Erro: " + e.getMessage());
            throw e;
        }
        return cepResponseDTO;
    }

    private void salvarLog(String cep, String resposta) {
        try {
            ConsultLogEntity consultLog = new ConsultLogEntity();
            consultLog.setCep(cep);
            consultLog.setResposta(resposta);
            consultLog.setProvider(CURRENT_PROVIDER);
            consultLog.setHorarioConsulta(LocalDateTime.now());
            logRepository.save(consultLog);
        } catch (Exception e) {
            log.error("Error on save consult on database.",e);
        }

    }
}
