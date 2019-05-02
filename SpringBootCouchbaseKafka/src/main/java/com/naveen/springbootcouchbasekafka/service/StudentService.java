package com.naveen.springbootcouchbasekafka.service;

import java.util.List;
import java.util.Optional;

import com.naveen.springbootcouchbasekafka.model.Student;

public interface StudentService {

	Optional<Student> getStudentById(Long id);

	Student create(Student student);

	void deleteById(Long id);

	List<Student> getAllStudents();

}
