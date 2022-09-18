package com.greatlearning.studentmanagement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.studentmanagement.entity.Student;
import com.greatlearning.studentmanagement.service.StudentService;

@Controller
@RequestMapping("/studmgmt/student")
public class StudentController {

	@Autowired
	public StudentService studentService;

	@RequestMapping("/list")
	public String studentList(Model model) {

		List<Student> studentList = studentService.getAllStudents();
		model.addAttribute("studentModel",studentList);
		return "student-main-view";
	}

	@RequestMapping("/add")
	public String addStudent(Model model) {

		Student student = new Student();
		model.addAttribute("student",student);
		return "add-student-view";
	}

	@RequestMapping("/save")
	public String saveStudent(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("department") String department, @RequestParam("country") String country) {
		Student student;
		if(id!=0) {
			student = studentService.getStudentById(id);
		}else {
	    student = new Student();
		}
		student.setName(name);
		student.setDepartment(department);
		student.setCountry(country);
		studentService.saveStudent(student);
		return "redirect:/studmgmt/student/list";
	}

	@RequestMapping("/update")
	public String updateStudent(@RequestParam("id") int id, Model model) {

		Student student = studentService.getStudentById(id);
		model.addAttribute("student", student);
		return "add-student-view";
	}
	
	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam("id") int id, Model model) {
		studentService.delete(id);
		return "redirect:/studmgmt/student/list"; 
	}
	
}
