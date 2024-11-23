package br.com.prservicos.cep.validation.cep;

import br.com.prservicos.cep.validation.cep.impl.ProviderValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ProviderValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidProvider {
    String message() default "Provider inválido.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
