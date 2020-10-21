package com.example.CRUD;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Service
@RequestMapping("/school")
class StudentController {

    @Autowired
    StudentDAO stuDAO;

    /*save student to db*/
    @PostMapping("/student")
    public ResponseEntity<Student> createStudent(@Validated @RequestBody Student st)  {
        return ResponseEntity.ok(stuDAO.save(st));
    }

    /*get an student from db*/
    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable(value = "id") Integer stId) {
        Student st = stuDAO.findOne(stId);
        if(st == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(st);
        }
    }

    /*update Student*/
    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Integer stId , @Validated @RequestBody Student newSt) {

        Student st = stuDAO.findOne(stId);
        if(st == null) {
            return ResponseEntity.notFound().build();
        } else {
            st.setName(newSt.getName());
            st.setRoll_no(newSt.getRoll_no());

            Student updatedStudent = stuDAO.save(st);
            return ResponseEntity.ok(updatedStudent);
        }

    }


    /*Delete Student*/
    @DeleteMapping("/student/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable(value = "id") Integer stId) {
        Student st = stuDAO.findOne(stId);
        if(st == null) {
            return ResponseEntity.notFound().build();
        } else {
            stuDAO.delete(st);
            return ResponseEntity.ok().build();
        }

    }
}
