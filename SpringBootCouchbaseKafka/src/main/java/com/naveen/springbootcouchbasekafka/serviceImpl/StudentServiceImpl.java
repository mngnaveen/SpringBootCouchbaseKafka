package com.naveen.springbootcouchbasekafka.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naveen.springbootcouchbasekafka.model.Student;
import com.naveen.springbootcouchbasekafka.repository.StudentRepository;
import com.naveen.springbootcouchbasekafka.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Optional<Student> getStudentById(Long id) {
		return studentRepository.findById(id);
	}

	@Override
	public Student create(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteById(Long id) {
		studentRepository.deleteById(id);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

}
