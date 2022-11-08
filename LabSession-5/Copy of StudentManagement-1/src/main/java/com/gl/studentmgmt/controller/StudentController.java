package com.gl.studentmgmt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.gl.studentmgmt.*;
import com.gl.studentmgmt.entity.Student;
import com.gl.studentmgmt.service.*;




@Controller
@RequestMapping("/home")
public class StudentController  {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/Students-List")
	public String listStudents(Model theModel) {

		System.out.println("request recieved");

		// get student details from db
		List<Student> theStudents = studentService.findAll();
		
		// add to the spring model
		theModel.addAttribute("Students", theStudents);
		
		System.out.println("Checking checking .........!!!!!!!!!");
   
		return "Students-List";
	}
	@RequestMapping("/showFormToAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Student theStudent = new Student();

		theModel.addAttribute("NewStudent", theStudent);

		return "StudentRegistration";
	}
	
	
	 @RequestMapping("/showFormToUpdate")
	 public String showUpdateForm(@RequestParam("studentId") int theId,Model theModel)
	 {
		 //get the Student info
		 Student theStudent = studentService.findById(theId);
		 
		 //Set the Student Details to pre-populate in the form
		 theModel.addAttribute("Student",theStudent);
		 
		 //send over to the update form
		 return "StudentRegistration";
		 
		 
	 }
	 @PostMapping("/save")
	 public String saveStudent(@RequestParam("id")Integer id,
			 				   @RequestParam("firstName")String fname,
			 				   @RequestParam("lastName")String lname,
			 				   @RequestParam("course")String course,
			 				   @RequestParam("country") String country ) {
		 Student student ;//=new Student();
		 if(id!=null && id!=0) {
			 student=studentService.findById(id);
			 student.setFirstName(fname);
			 student.setLastName(lname);
			 student.setCourse(course);
			 student.setCountry(country);
		 }else {
			 student =new Student(fname,lname,course,country);
		 }
		 studentService.save(student);
		 return "redirect:/home/Students-List";
		 
	 
	 }
		
		@RequestMapping("/delete")
		public String deleteStudent(@RequestParam("studentId") int theId) {

			// delete the Book
			studentService.deleteById(theId);

			// redirect to /Books/list
			return "redirect:/student/list";

		}

}
