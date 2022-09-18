package com.greatlearning.studentmanagement.service;

import java.util.List;

import com.greatlearning.studentmanagement.entity.Student;

public interface StudentService {

	public Student getStudentById(int id);

	public List<Student> getAllStudents();

	public void saveStudent(Student student);

	public void delete(int id);

}
