package com.example.demo;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpRepository empRepository;

	@Autowired
	DepRepository depRepository; 
	
	@Override
	public List<Employee> getEmp() {
		return empRepository.findAll();
	}

	@Override
	public Employee saveEmp(Employee e,Long depId) {
		
		Optional<Department> dep=depRepository.findById(depId);
		
		if(dep.isPresent()){
			Department d=dep.get();
			e.setDep(d);
		}
		
		return empRepository.save(e);
	}
	
	@Override
	public Employee saveEmp(Employee e) {
		return empRepository.save(e);
	}

	@Override
	public Department saveDep(Department d) {
		return depRepository.save(d);
	}

	@Override
	public List<Department> getAllDep() {
		return depRepository.findAll();
	}

	@Override
	public Department updateDep(Long empId,Department d) {
		return null;
	}

	@Override
	public void deleteEmp(Long empId) {
		 empRepository.deleteById(empId);
	}

	@Override
	public Employee getEmpById(Long empId) {
		return empRepository.findById(empId).get();
	}



}
