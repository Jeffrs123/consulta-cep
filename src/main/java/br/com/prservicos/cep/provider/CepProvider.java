package br.com.prservicos.cep.provider;

import br.com.prservicos.cep.model.dto.ResponseCep;

public interface CepProvider {
    ResponseCep consultarCep(String cep);
    ResponseCep consultarCep2(String cep);
}
