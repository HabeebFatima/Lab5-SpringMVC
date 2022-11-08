package com.gl.studentmgmt.service;
 import com.gl.studentmgmt.entity.*;

import java.util.List;
import java.util.List.*;

public interface StudentService {
	public List<Student> findAll();
	
	public Student findById(int theid);
	
	public void save(Student theStudent);
	
	public void deleteById(int theId);
	

}
