package com.example.demo;

import java.util.List;


public interface  EmpService {

	public List<Employee> getEmp();

	public Employee getEmpById(Long empId);

	public Employee saveEmp(Employee e,Long depId);

	public Employee saveEmp(Employee e);
	
	public void deleteEmp(Long empId);

	public Department saveDep(Department d);
	
	public List<Department> getAllDep();
	
	public Department updateDep(Long empId,Department d);


}