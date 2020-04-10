package com.example.demo;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/emp/")
public class EmpController {

    private static final Logger log = LoggerFactory.getLogger(EmpController.class);

	
    @Autowired
	EmpService service; 	
	
	@GetMapping("/getEmp")
	public List<Employee> getEmp() {
		return service.getEmp();
	}
	
	@GetMapping("/getEmp/{empId}")
	public Employee getEmpById(@PathVariable (value = "empId") Long empId) {
		
		Employee e= service.getEmpById(empId);
		System.out.println("getEmpById==>	"+ e.toString());
		return e;
	}
	
	@PostMapping("/dep/{depId}/emp")
	public Employee saveEmp(@Valid @RequestBody Employee e,@PathVariable (value = "depId") Long depId) {
		System.out.println("Employee==>	"+e.toString());
		return service.saveEmp(e,depId);
	}
	
	@DeleteMapping("/deleteEmp/{empId}")
	public void deleteEmp(@PathVariable (value = "empId") Long empId) {
		 service.deleteEmp(empId);
	}
	
	@PostMapping("/saveEmp")
	public Employee saveEmp(@Valid @RequestBody Employee e) {
		return service.saveEmp(e);
	}
	
	@PostMapping("/saveDep")
	public Department saveDep(@Valid @RequestBody Department d) {
		return service.saveDep(d);
	}
	
	@GetMapping("/getAllDep")
	public List<Department> getAllDep() {
		return service.getAllDep();
	}
	
	
	@PostMapping("/emp/{empId}/dep")
	public Department updateDep(@Valid @RequestBody Department d,@PathVariable (value = "empId") Long empId) {
		return service.updateDep(empId, d);
	}
	
	
	
	
}
