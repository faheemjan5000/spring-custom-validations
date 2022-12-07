package faheem.microservices.springcustomvalidations.validations;

import faheem.microservices.springcustomvalidations.constants.Gender;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GenderValidator implements ConstraintValidator<GenderValidation, String> {
    public void initialize(GenderValidation constraint) {
    }

    public boolean isValid(String gender, ConstraintValidatorContext context) {
       return gender.equalsIgnoreCase(Gender.F.name())
               || gender.equalsIgnoreCase(Gender.M.name());
    }
}
