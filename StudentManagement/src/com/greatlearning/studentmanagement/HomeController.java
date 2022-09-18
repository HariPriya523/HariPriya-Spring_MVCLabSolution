package com.greatlearning.studentmanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.studentmanagement.entity.Student;
import com.greatlearning.studentmanagement.service.StudentService;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String showPage() {
		return "main-menu";
	}
}
