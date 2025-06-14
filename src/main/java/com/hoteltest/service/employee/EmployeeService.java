package com.hoteltest.service.employee;

import com.hoteltest.model.Employee;
import com.hoteltest.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }
    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }
    @Override
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }
    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}
