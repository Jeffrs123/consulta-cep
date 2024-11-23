package br.com.prservicos.cep.validation.cep.impl;

import br.com.prservicos.cep.validation.cep.ValidCep;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CepValidator implements ConstraintValidator<ValidCep, String> {
    @Override
    public boolean isValid(String cep, ConstraintValidatorContext constraintValidatorContext) {
        return cep != null && cep.matches("\\d{8}");
    }
}
