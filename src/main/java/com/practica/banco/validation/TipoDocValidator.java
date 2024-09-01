package com.practica.banco.validation;

import com.practica.banco.dtos.TipoDoc;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TipoDocValidator implements ConstraintValidator<ValidTipoDoc, TipoDoc> {

    @Override
    public boolean isValid(TipoDoc value, ConstraintValidatorContext constraintValidatorContext) {
        return value != null && (value == TipoDoc.CI || value == TipoDoc.PASAPORTE || value == TipoDoc.DOC_EXTRANJERO);
    }
}
