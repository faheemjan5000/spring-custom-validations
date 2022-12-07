package faheem.microservices.springcustomvalidations.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import faheem.microservices.springcustomvalidations.validations.ValidateEmployeeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String firstName;
    private String email;
    private String mobile;
    private String gender;
    private Integer age;
    private String nationality;
}
