package br.com.prservicos.cep.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class ResponseCep {

    @JsonProperty("cep")
    private String cep;
    @JsonProperty("logradouro")
    private String logradouro;
    @JsonProperty("bairro")
    private String bairro;
    @JsonProperty("cidade")
    private String cidade;
    @JsonProperty("estado")
    private String estado;
    @JsonProperty("fonte")
    private String fonte;

}
