package faheem.microservices.springcustomvalidations.validations;

import faheem.microservices.springcustomvalidations.constants.EmployeeTypes;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
                                                       //<annotation name , type of the filed to be validate>
public class EmployeeTypeValidator implements ConstraintValidator<ValidateEmployeeType, String> {
    public void initialize(ValidateEmployeeType constraint) {
    }

    public boolean isValid(String employeeType, ConstraintValidatorContext context) {

        return employeeType.equalsIgnoreCase(EmployeeTypes.PERMANENT.name())
                || employeeType.equalsIgnoreCase(EmployeeTypes.VENDOR.name());
    }
}
