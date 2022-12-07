package faheem.microservices.springcustomvalidations.controller;

import faheem.microservices.springcustomvalidations.model.Employee;
import faheem.microservices.springcustomvalidations.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.midi.Soundbank;
import javax.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody @Valid Employee employee){
    Employee employee1 = employeeService.addEmployee(employee);
     System.out.println(employee1);
     return employee1;
    }
}
