package br.com.prservicos.cep.provider.impl;

import br.com.prservicos.cep.model.dto.CepResponseDTO;
import br.com.prservicos.cep.provider.CepProvider;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component("publicapi")
public class PublicApiCepProvider implements CepProvider {

    private static final String API_URL = "https://viacep.com.br/ws/";

    @Override
    public CepResponseDTO consultarCep2(String cep) {
        return CepResponseDTO.builder()
                .cep(cep)
                .logradouro("Rua Central")
                .bairro("República")
                .cidade("São Paulo")
                .estado("SP")
                .fonte("publicapi")
                .build();
    }

    @Override
    public CepResponseDTO consultarCep(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(API_URL + cep + "/json/", CepResponseDTO.class);
    }
}
