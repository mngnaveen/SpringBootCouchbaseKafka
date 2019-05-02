package com.naveen.springbootcouchbasekafka.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naveen.springbootcouchbasekafka.model.Student;
import com.naveen.springbootcouchbasekafka.serviceImpl.StudentServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path = "/api/v1/students")
public class StudentController {

	private static final Logger log = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private StudentServiceImpl studentServiceImpl;

	@GetMapping("/{studentId}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long studentId) {
		Optional<Student> student = studentServiceImpl.getStudentById(studentId);
		if (!student.isPresent()) {
			log.error("Id " + studentId + " is not existed");
			ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(student.get());
	}

	@PostMapping()
	public Student createStudent(@Valid @RequestBody Student student) {
		return studentServiceImpl.create(student);
	}

	@GetMapping()
	public ResponseEntity<List<Student>> getAllStudents() {
		return ResponseEntity.ok(studentServiceImpl.getAllStudents());
	}

	@PutMapping("/{studentId}")
	public ResponseEntity<Student> updateStudentById(@PathVariable Long studentId, @RequestBody Student std) {
		if (!studentServiceImpl.getStudentById(studentId).isPresent()) {
			log.error("Id " + studentId + " is not existed");
			ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(studentServiceImpl.create(std));
	}

	@DeleteMapping("/{studentId}")
	public ResponseEntity<Student> deleteStudentById(@PathVariable Long studentId) {
		if (!studentServiceImpl.getStudentById(studentId).isPresent()) {
			log.error("Id " + studentId + " is not existed");
			ResponseEntity.badRequest().build();
		}
		studentServiceImpl.deleteById(studentId);
		return ResponseEntity.ok().build();
	}
}
