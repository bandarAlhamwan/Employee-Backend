package bandar.employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bandar.employee.Entity.Employee;
import bandar.employee.Exception.ResourceNotFoundException;
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
	
	@PostMapping("employee")
	public Employee save(@RequestBody Employee employee) {
		return employeeRepo.save(employee);
	}
	
	@GetMapping("employee/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {
		return employeeRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
	}
	
	@PutMapping("employee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeRepo.save(employee),HttpStatus.OK);
	}
	
	@DeleteMapping("employee/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long id){
		employeeRepo.deleteById(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
}
