package com.naveen.springbootcouchbasekafka.repository;

import java.util.List;

import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import com.naveen.springbootcouchbasekafka.model.Student;

@Repository
@ViewIndexed(designDoc = "student", viewName = "all")
public interface StudentRepository extends CouchbaseRepository<Student, Long> {

	List<Student> findAll();
}
