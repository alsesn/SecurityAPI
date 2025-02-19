package me.alsesn.SecurityAPI.controller;

import me.alsesn.SecurityAPI.entity.Employee;
import me.alsesn.SecurityAPI.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/empls")
    public List<Employee> findAll() {
        return service.findAll();
    }

    @GetMapping("/empls/{id}")
    public Employee findById(@PathVariable int id) {
        Employee employee = service.findById(id);
        if (employee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee with id " + id + " not found");
        } else {
            return employee;
        }
    }

    @PostMapping("/empls")
    public Employee addEmployee(@RequestBody Employee employee) {
        return service.save(employee);
    }

    @PutMapping("/empls")
    public Employee updateEmployee(@RequestBody Employee employee) {
        Employee updateEmployee = service.save(employee);
        return updateEmployee;
    }

    @DeleteMapping("/empls/{id}")
    public String deleteById(@PathVariable int id ) {
        Employee employee = service.findById(id);
        if (employee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee with id " + id + " not found");
        } else {
            service.deleteById(id);
        }
        return "Deleted " + employee.toString();
    }
}