package faheem.microservices.springcustomvalidations.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME) //when to run this validation
@Documented
@Constraint(validatedBy = EmployeeTypeValidator.class) //class to validate
public @interface ValidateEmployeeType {

    public String message()  default "invalid employee type! it should be either permanent or vandor";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
