package faheem.microservices.springcustomvalidations.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import faheem.microservices.springcustomvalidations.validations.ValidateEmployeeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private int employeeId;
    @NotBlank(message ="first name should not be empty or null")
    private String firstName;
    @NotBlank(message = "lastName should not be blank")
    private String lastName;
    @NotEmpty(message = "department shouldn't be emtpy")
    @NotNull(message = "department shouldn't be empty")
    private String department;
    @Past(message = "invalid date entered")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dob;
    @Email(message = "invalid email id")
    private String email;
    @ValidateEmployeeType
    private String employeeType; //permanent , vendor , contractual

}
