package com.example.CRUD;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentDAO {

    @Autowired
    StudentRepository stuRepository;

	//save students/
    public Student save(Student st) {
        return stuRepository.save(st);
    }

	//get student by id/
    public Student findOne(Integer stId) {
        Optional<Student> student = stuRepository.findById(stId);
        return (student == null) ? null : student.get();
    }

	//delete students/
    public void delete(Student st) {
        stuRepository.delete(st);
    }
}