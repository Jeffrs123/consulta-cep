package br.com.prservicos.cep.controller;

import br.com.prservicos.cep.model.dto.CepResponseDTO;
import br.com.prservicos.cep.service.CepService;
import br.com.prservicos.cep.validation.cep.ValidCep;
import br.com.prservicos.cep.validation.cep.ValidProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cep")
public class CepController {

    private final CepService cepService;

    public CepController(CepService cepService) {
        this.cepService = cepService;
    }

    @GetMapping(value = "/{cep}", produces = "application/json")
    public ResponseEntity<CepResponseDTO> consultarCep(@PathVariable @ValidCep String cep) {
        CepResponseDTO cepResponseDTO =  cepService.consultarCep(cep);
        return ResponseEntity.ok(cepResponseDTO);
    }

    @PostMapping("/set-provider")
    public String setProvider(@RequestParam @ValidProvider String provider) {
        return cepService.updateCurrentProvider(provider);
    }
}
