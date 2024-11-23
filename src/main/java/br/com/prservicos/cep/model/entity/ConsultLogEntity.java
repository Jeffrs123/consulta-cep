package br.com.prservicos.cep.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class ConsultLogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cep;

    @Column(length = 1000)
    private String resposta;

    private String provider;

    private LocalDateTime horarioConsulta;
}
