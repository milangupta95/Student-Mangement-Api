package com.milan.studentmanagement.student;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequestMapping(path = "/api/v1/student")
@RestController

@Service

public class StudentController {
    private final StudentService stdserv;

    @Autowired
    public StudentController(StudentService stdserv) {
        this.stdserv = stdserv;
    }
    
    @GetMapping
    public List<Student> getAllStudent() {
        return stdserv.getAllStudent();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student stdent) {
        stdserv.addStudent(stdent);
    }
    
    @DeleteMapping (path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id) {
        stdserv.deleteStudent(id);
    }

    @PutMapping (path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long id,
    @RequestParam(required = false) String name,
    @RequestParam(required =  false) String email) {
      stdserv.updateStudent(id,name,email);
    }
}
