package com.controller;

import org.springframework.ui.Model;
import com.domain.Student;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.serviceInterface.StudentServiceInterface;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/")
public class StudentController {
    private StudentServiceInterface studentService;
    private ModelAndView modelAndView;

    @GetMapping("home")
    public ModelAndView getHome(){
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @GetMapping("students/{studentId}")
    public ModelAndView getStudentById(@PathVariable(name = "studentId", required = false) Integer studentId, Model model){

        if(studentId != 0){
            Student searchResults = studentService.getStudentByStudentId(studentId);
            model.addAttribute("searchResults", searchResults);
            model.addAttribute("keyword", studentId);
        }
        else {
            model.addAttribute("searchResults", null);
            model.addAttribute("keyword", null);
        }

        modelAndView.setViewName("search");
        return modelAndView;
    }

    @GetMapping("students/form")

    public ModelAndView getForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("editMode", false);

        modelAndView.setViewName("student_form");
        return modelAndView;
    }

    @GetMapping("/students/form/{id}")
    public ModelAndView getFormByStudentId(@PathVariable Integer id, Model model) {
        Student existingStudent = studentService.getStudentByStudentId(id);
        model.addAttribute("student", existingStudent);
        model.addAttribute("editMode", true);

        modelAndView.setViewName("student_form");
        return modelAndView;
    }

    @GetMapping("students")
    public ModelAndView getStudents(Model model){
        List<Student> students = studentService.getStudents();
        model.addAttribute("students", students);

        modelAndView.setViewName("student_list");
        return modelAndView;
    }

    @PutMapping("students")
    public ResponseEntity<String> updateStudent(@ModelAttribute("student") Student student){
        studentService.updateStudent(student);
        return new ResponseEntity<>("Student successfully updated", HttpStatus.OK);
    }

    @PostMapping("students")
    public ResponseEntity<String> addStudent(@ModelAttribute("student") Student student){
        studentService.addStudent(student);
        return new ResponseEntity<>("Student successfully added", HttpStatus.OK);
    }

    @DeleteMapping("students/{studentId}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Integer studentId){
        studentService.deleteStudentByStudentId(studentId);
        return new ResponseEntity<>("Student successfully added", HttpStatus.OK);
    }

}
