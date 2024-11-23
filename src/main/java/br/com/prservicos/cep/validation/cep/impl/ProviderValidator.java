package br.com.prservicos.cep.validation.cep.impl;

import br.com.prservicos.cep.validation.cep.ValidProvider;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;

public class ProviderValidator implements ConstraintValidator<ValidProvider, String> {

    private static final Set<String> VALID_PROVIDERS = Set.of("mockoon", "publicapi");

    @Override
    public boolean isValid(String provider, ConstraintValidatorContext context) {
        if (provider != null && VALID_PROVIDERS.contains(provider.toLowerCase()))
            return true;

        throw new IllegalArgumentException("Fonte de CEP não suportada. Escolher entre: mockoon e publicapi");
    }
}
