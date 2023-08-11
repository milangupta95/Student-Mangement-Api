package com.milan.studentmanagement.student;
import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class StudentService {
    @Autowired
    private final StudentRepository repo;
    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<Student> getAllStudent() {
        return repo.findAll();
    }

    public void addStudent(Student student) {
        Optional<Student> alreadyStd = repo.findStudentByEmail(student.getEmail());
        if(alreadyStd.isPresent()) {
            throw new IllegalStateException("Student with this email is already associated");
        }
        repo.save(student);
    }

    public void deleteStudent(Long id) {
        boolean b = repo.existsById(id);
        if(b)
            repo.deleteById(id);
        else 
            throw new IllegalStateException("Student Does Not Exists");
    }
    
    @Transactional
    public void updateStudent(Long id, String name, String email) {
        Student stdById = repo.findById(id).orElseThrow(() -> new IllegalStateException("Your Account Not found"));

        if(name != null
         && name.length() > 0 
         && !stdById.getName().equals(name)) {
            stdById.setName(name);
        }

        if(email != null 
        && email.length() > 0 
        && !stdById.getEmail().equals(email)
        && !repo.findStudentByEmail(email).isPresent()) {
            stdById.setEmail(email);
        }
    }

    
}
