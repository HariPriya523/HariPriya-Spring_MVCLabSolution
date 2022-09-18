package com.greatlearning.studentmanagement.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.studentmanagement.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	SessionFactory sessionFactory;
	Session session;
	
	@Autowired
	public StudentServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			this.session = sessionFactory.getCurrentSession();
		}catch(Exception e) {
			this.session = sessionFactory.openSession();
		}
	}
	@Override
	public Student getStudentById(int id) {
		Student student = new Student();
		Transaction tx = session.beginTransaction();
		student = session.get(Student.class, id);
		tx.commit();
		return student;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Student> getAllStudents() {
		
		List<Student> students = (List<Student>)session.createQuery("from Student").list();
		return students;
	}
	
	@Override
	public void saveStudent(Student student) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(student);
		tx.commit();
		
	}

	@Override
	public void delete(int id) {
		session.beginTransaction();
		Student student = session.get(Student.class, id);
		session.delete(student);
		session.getTransaction().commit();
	}
}
