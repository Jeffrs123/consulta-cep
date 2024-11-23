package br.com.prservicos.cep.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;


@Builder
public class ConsultLogDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("cep")
    private String cep;

    @JsonProperty("resposta")
    private String resposta;

    @JsonProperty("provider")
    private String provider;

    @JsonProperty("horarioConsulta")
    private LocalDateTime horarioConsulta;
}
