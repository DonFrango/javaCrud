package teacherWebApp.teacherapp.controller;

import teacherWebApp.teacherapp.exception.StudentException;
import teacherWebApp.teacherapp.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import teacherWebApp.teacherapp.service.StudentService;

import java.util.List;

@Controller
public class StudentController {
    @Autowired private StudentService stService;

    @GetMapping("/students")
    public String showStudentList(Model model) {
        List<Student> listStudents = stService.listAll();
        model.addAttribute("listStudents", listStudents);

        return "students";
    }

    @GetMapping("/students/new")
    public String showNewForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("pageTitle", "Add New Student");
        return "student_form";
    }

    @PostMapping("/students/save")
    public String saveStudent(Student student, RedirectAttributes ra) {
        stService.save(student);
        ra.addFlashAttribute("message", "The student has been saved successfully.");
        return "redirect:/students"; // Redirect to the listing page after successful save
    }

    @GetMapping("/students/edit/{id}")
    public String showStudentEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Student student = stService.get(id);
            model.addAttribute("student", student);
            model.addAttribute("pageTitle", "Edit Students (ID: " + id + ")");

            return "student_form";
        } catch (StudentException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/students";
        }
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            stService.delete(id);
            ra.addFlashAttribute("message", "The student with id " + id + " has been deleted.");
        } catch (StudentException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/students";
    }
}