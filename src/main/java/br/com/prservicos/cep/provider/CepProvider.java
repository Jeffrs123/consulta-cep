package br.com.prservicos.cep.provider;

import br.com.prservicos.cep.model.dto.CepResponseDTO;

public interface CepProvider {
    CepResponseDTO consultarCep(String cep);
    CepResponseDTO consultarCep2(String cep);
}
