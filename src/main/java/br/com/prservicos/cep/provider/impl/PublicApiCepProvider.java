package br.com.prservicos.cep.provider.impl;

import br.com.prservicos.cep.model.dto.ResponseCep;
import br.com.prservicos.cep.provider.CepProvider;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component("publicApi")
public class PublicApiCepProvider implements CepProvider {

    private static final String API_URL = "https://viacep.com.br/ws/";

    @Override
    public ResponseCep consultarCep2(String cep) {
        return ResponseCep.builder()
                .cep(cep)
                .logradouro("Rua Central")
                .bairro("República")
                .cidade("São Paulo")
                .estado("SP")
                .fonte("publicApi")
                .build();
    }

    @Override
    public ResponseCep consultarCep(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(API_URL + cep + "/json/", ResponseCep.class);
    }
}
