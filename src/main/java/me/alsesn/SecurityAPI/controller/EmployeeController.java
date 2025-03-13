package me.alsesn.SecurityAPI.controller;

import me.alsesn.SecurityAPI.entity.Employee;
import me.alsesn.SecurityAPI.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class EmployeeController {
    private EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        List<Employee> employees = service.findAll();
        model.addAttribute("employees", employees);

        return "list_employees";
    }
}