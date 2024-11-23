package br.com.prservicos.cep.repository;

import br.com.prservicos.cep.model.entity.ConsultLogEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  ConsultaLogRepository extends JpaRepository<ConsultLogEntity, Long> {
    Page<ConsultLogEntity> findAll(Pageable pageable);
}
