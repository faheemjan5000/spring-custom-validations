package faheem.microservices.springcustomvalidations.service;

import faheem.microservices.springcustomvalidations.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class EmployeeService {

    public Employee addEmployee(Employee employee){
        employee.setEmployeeId(new Random().nextInt(10));
        return employee;
    }
}
