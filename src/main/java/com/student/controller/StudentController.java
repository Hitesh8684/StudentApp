package com.student.controller;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.student.model.Student;
import com.student.repository.StudentRepository;

@Controller
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;
	
	@RequestMapping("/")
	public String index(Model model) {
		ArrayList<Student> studentList = new ArrayList<Student>(); 
		studentRepository.findAll().forEach(studentList :: add);
		model.addAttribute("studentList", studentList);
		return "index";
	}
	
	@RequestMapping("/newStudent")
	public String newStudent() {
		
		return "newstudent";
	}
	
	@PostMapping("/add")
	public String saveStudent(HttpServletRequest req) {
		String name=req.getParameter("name");
		String stream = req.getParameter("stream");
		String id = req.getParameter("idtest");
		System.out.println("Id is ..."+id);
		if(id != "" && id != null) {
			System.out.println("In update .."+id);
			Student student1 = studentRepository.getOne(Long.parseLong(id));
			if(name != null) {
			student1.setName(name);
			}if(stream != null) {
			student1.setStream(stream);
			}
			studentRepository.save(student1);
		}else {
			System.out.println("I am  here ..");
		Student student = new Student();
		student.setName(name);
		student.setStream(stream);
		studentRepository.save(student);
		}
		return "success";
		
	}
	
	@GetMapping("/update/{id}")
	public String updateStudent(@PathVariable Long id, Model model) {
		
		Student student = studentRepository.getOne(id);
		
		model.addAttribute("student", student);
		
		return "newstudent";
		
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		
		studentRepository.deleteById(id);
		
		
		
		return "delete";
		
	}

}
