package faheem.microservices.springcustomvalidations.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.TYPE_PARAMETER})
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = GenderValidator.class)
public @interface GenderValidation {

    public String message()  default "Gender should be M or F";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
