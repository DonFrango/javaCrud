package teacherWebApp.teacherapp.controller;

import teacherWebApp.teacherapp.exception.TeacherException;

import teacherWebApp.teacherapp.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import teacherWebApp.teacherapp.service.StudentService;
import teacherWebApp.teacherapp.service.TeacherService;
import java.util.List;

@Controller
public class TeacherController {
    @Autowired private TeacherService tService;

    @GetMapping("/teachers")
    public String showTeacherList(Model model) {
        List<Teacher> listTeachers = tService.listAll();
        model.addAttribute("listTeachers", listTeachers);

        return "teachers";
    }

    @GetMapping("/teachers/new")
    public String showTeacherNewForm(Model model) {
        model.addAttribute("teacher", new Teacher());
        model.addAttribute("pageTitle", "Add New Teacher");
        return "teacher_form";
    }

    @PostMapping("/teachers/save")
    public String saveTeacher(Teacher teacher, RedirectAttributes ra) {
        tService.save(teacher);
        ra.addFlashAttribute("message", "The teacher has been saved successfully.");
        return "redirect:/teachers";
    }

    @GetMapping("/teachers/edit/{id}")
    public String showTeachersEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Teacher teacher = tService.get(id);
            model.addAttribute("teacher", teacher);
            model.addAttribute("pageTitle", "Edit Teacher (ID: " + id + ")");

            return "teacher_form";
        } catch (TeacherException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/teachers";
        }
    }

    @GetMapping("/teachers/delete/{id}")
    public String deleteTeacher(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            tService.delete(id);
            ra.addFlashAttribute("message", "The teacher with id " + id + " has been deleted.");
        } catch (TeacherException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/teachers";
    }
}