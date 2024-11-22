package br.com.prservicos.cep.service;

import br.com.prservicos.cep.model.dto.ResponseCep;
import br.com.prservicos.cep.provider.CepProvider;
import br.com.prservicos.cep.provider.CepProviderFactory;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public class CepService {

    private final CepProviderFactory providerFactory;

    private String currentProvider = "mockoon"; // Default

    public CepService(CepProviderFactory providerFactory) {
        this.providerFactory = providerFactory;
    }

    public String updateCurrentProvider(String provider) {
        this.currentProvider = provider;
        return "Provider atualizado para: " + this.currentProvider;
    }

    public ResponseCep consultarCep(String cep) {
        CepProvider provider = providerFactory.getProvider(currentProvider);
        ResponseCep responseCep = provider.consultarCep2(cep);
        return responseCep;
    }
}
