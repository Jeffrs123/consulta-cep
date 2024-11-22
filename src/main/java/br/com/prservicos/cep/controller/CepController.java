package br.com.prservicos.cep.controller;

import br.com.prservicos.cep.model.dto.ResponseCep;
import br.com.prservicos.cep.service.CepService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cep")
public class CepController {

    private final CepService cepService;

    public CepController(CepService cepService) {
        this.cepService = cepService;
    }


    @GetMapping("/old/{cep}")
    public String consultarCep2(@PathVariable String cep) {
        return "cepService.consultarCep(cep)";
    }
    @GetMapping(value = "/{cep}", produces = "application/json")
    public ResponseEntity<ResponseCep> consultarCep(@PathVariable /*@ValidCep*/ String cep) {
        ResponseCep responseCep =  cepService.consultarCep(cep);
        return ResponseEntity.ok(responseCep);
    }

    @PostMapping("/set-provider")
    public String setProvider(@RequestParam /*@ValidProvider*/ String provider) {
        return cepService.updateCurrentProvider(provider);
    }
}
