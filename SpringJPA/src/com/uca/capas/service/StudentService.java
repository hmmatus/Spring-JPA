package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Student;

public interface StudentService {
	
	public List<Student> findAll() throws DataAccessException;
	
	public Student findOne(Integer codigo) throws DataAccessException;
	
	public Student saveStudent(Student s) throws DataAccessException;
	
	public List<Student> findBySAge(Integer age);
	
	public List<Student> findBySName(String name);

}
