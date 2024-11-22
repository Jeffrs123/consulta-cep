package br.com.prservicos.cep.provider;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CepProviderFactory {

    private final Map<String, CepProvider> providers;

    public CepProviderFactory(Map<String, CepProvider> providers) {
        this.providers = providers;
    }

    public CepProvider getProvider(String source) {
        CepProvider provider = providers.get(source);
        if (provider == null) {
            throw new IllegalArgumentException("Fonte de CEP não suportada: " + source);
        }
        return provider;
    }
}
