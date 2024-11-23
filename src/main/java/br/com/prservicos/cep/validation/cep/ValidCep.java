package br.com.prservicos.cep.validation.cep;

import br.com.prservicos.cep.validation.cep.impl.CepValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CepValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCep {
    String message() default "CEP inválido. Deve conter apenas 8 dígitos numéricos.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
