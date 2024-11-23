package br.com.prservicos.cep.controller;

import br.com.prservicos.cep.model.dto.ConsultLogDTO;
import br.com.prservicos.cep.service.AdmService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/adm")
public class AdmController {

    private final AdmService admService;

    public AdmController(AdmService admService) {
        this.admService = admService;
    }

    @GetMapping(value = "/list-logs", produces = "application/json")
    public ResponseEntity<Page<ConsultLogDTO>> consultarCep(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ConsultLogDTO> consultLogDTOPage = admService.listLogs(pageable);
        return ResponseEntity.ok(consultLogDTOPage);
    }
}
