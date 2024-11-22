package br.com.prservicos.cep.provider.impl;

import br.com.prservicos.cep.model.dto.ResponseCep;
import br.com.prservicos.cep.provider.CepProvider;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component("mockoon")
public class MockoonCepProvider implements CepProvider {

    private static final String MOCKOON_URL = "http://localhost:3000/api/cep/";

    @Override
    public ResponseCep consultarCep2(String cep) {
        return ResponseCep.builder()
                .cep(cep)
                .logradouro("Rua Central")
                .bairro("República")
                .cidade("São Paulo")
                .estado("SP")
                .fonte("mockoon")
                .build();
    }

    @Override
    public ResponseCep consultarCep(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(MOCKOON_URL + cep, ResponseCep.class);
    }
}
