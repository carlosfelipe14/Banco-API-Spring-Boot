package com.practica.banco.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TipoDocValidator.class)
public @interface ValidTipoDoc {

    public String message() default "must be any of enum CI, PASAPORTE or DOC_EXTRANJERO";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
