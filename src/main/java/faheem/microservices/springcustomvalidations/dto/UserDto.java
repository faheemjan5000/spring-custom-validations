package faheem.microservices.springcustomvalidations.dto;


import faheem.microservices.springcustomvalidations.validations.GenderValidation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private int userId;
    @NotNull(message = "username should not be null")
    private String firstName;
    @Email(message = "invalid email id")
    private String email;
    @NotNull
    //@Pattern(regexp = "^\\d{0}$" ,message = "invalid phone number .should be atleast 10 digits")
    private String mobile;
    @GenderValidation
    private String gender;
    @Min(18)
    @Max(60)
    private Integer age;
    @NotBlank
    private String nationality;
}
