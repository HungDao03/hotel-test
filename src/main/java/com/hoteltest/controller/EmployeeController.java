package com.hoteltest.controller;

import com.hoteltest.model.Employee;
import com.hoteltest.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/employees")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "admin/employees/list"; //
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "admin/employees/create"; // ✔ Tạo mới nhân viên
    }

    @PostMapping("/create")
    public String createEmployee(@ModelAttribute("emp loyee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/admin/employees"; // ✔ Quay lại danh sách nhân viên
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "admin/employees/edit"; // ✔ Sửa thông tin nhân viên
    }

    @PostMapping("/edit")
    public String editEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/admin/employees"; // ✔ sau khi sửa thì về danh sách
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteById(id);
        return "redirect:/admin/employees";
    }
}
