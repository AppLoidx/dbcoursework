package com.itmoprofessionals.dbcoursework.view;

import com.itmoprofessionals.dbcoursework.domain.employee.Employee;
import com.itmoprofessionals.dbcoursework.repo.employee.EmployeeRepo;
import com.itmoprofessionals.dbcoursework.util.IdUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/employee/{employee-uuid}")
public class EmployeeView {

    private final EmployeeRepo employeeRepo;

    public EmployeeView(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @GetMapping
    public String employee(@PathVariable("employee-uuid") String employeeUuid, Model model) {
        Optional<Employee> employee = this.employeeRepo.findById(IdUtil.parse(employeeUuid));

        if (employee.isPresent()) {
            model.addAttribute("employee", employee.get());
            return "employee";
        } else {
            return "404";
        }

    }
}
