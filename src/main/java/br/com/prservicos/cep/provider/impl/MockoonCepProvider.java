package br.com.prservicos.cep.provider.impl;

import br.com.prservicos.cep.model.dto.CepResponseDTO;
import br.com.prservicos.cep.provider.CepProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component("mockoon")
public class MockoonCepProvider implements CepProvider {

    private static final String MOCKOON_URL = "http://localhost:3000/api/cep/";

    @Override
    public CepResponseDTO consultarCep2(String cep) {

        return CepResponseDTO.builder()
                .cep(cep)
                .logradouro("Rua Central")
                .bairro("República")
                .cidade("São Paulo")
                .estado("SP")
                .fonte("mockoon")
                .build();
    }

    @Override
    public CepResponseDTO consultarCep(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        String jsonResponse = restTemplate.getForObject(MOCKOON_URL + cep, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            CepResponseDTO cepResponseDTO = objectMapper.readValue(jsonResponse, CepResponseDTO.class);
            return cepResponseDTO;
        } catch (Exception e) {
            System.out.println("Erro ao deserializar a resposta JSON: " + e.getMessage());
            return null;
        }
    }
}
