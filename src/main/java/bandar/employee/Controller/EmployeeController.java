package bandar.employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bandar.employee.Entity.Employee;
import bandar.employee.Repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("*")
public class EmployeeController {

	@Autowired EmployeeRepository employeeRepo;
	
	@GetMapping("employee")
	public List<Employee> getEmployee(){
		return employeeRepo.findAll();
	}
}
