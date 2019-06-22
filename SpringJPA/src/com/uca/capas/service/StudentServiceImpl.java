package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Student;
import com.uca.capas.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository sRepo;

	@Override
	public List<Student> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return sRepo.findAll();
	}

	@Override
	public Student findOne(Integer codigo) throws DataAccessException {
		// TODO Auto-generated method stub
		return sRepo.findById(codigo).get();
	}

	@Override
	@Transactional
	public Student saveStudent(Student s) throws DataAccessException {
		// TODO Auto-generated method stub
		return sRepo.save(s);
	}

	@Override
	public List<Student> findBySAge(Integer age) {
		// TODO Auto-generated method stub
		return sRepo.findBySAge(age);
	}

	@Override
	public List<Student> findBySName(String name) {
		// TODO Auto-generated method stub
		return sRepo.findBySName(name);
	}

}
