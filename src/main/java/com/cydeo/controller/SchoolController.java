package com.cydeo.controller;

import com.cydeo.dto.ParentDTO;
import com.cydeo.dto.ResponseWrapper;
import com.cydeo.dto.StudentDTO;
import com.cydeo.dto.TeacherDTO;
import com.cydeo.service.ParentService;
import com.cydeo.service.StudentService;
import com.cydeo.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {
    //write a method for teacher and return list of teachers
    private final TeacherService teacherService;
    private final StudentService studentService;
    private final ParentService parentService;

    public SchoolController(TeacherService teacherService, StudentService studentService, ParentService parentService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.parentService = parentService;
    }

   @GetMapping("/teachers")
    public List<TeacherDTO> getTeachers() {
        return teacherService.findAll();
   }
    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper> getStudents() {
        List<StudentDTO> students = studentService.findAll();
        return ResponseEntity
                .ok(new ResponseWrapper("students are successfully retrieved", students));
    }
    @GetMapping("/parents")
    public ResponseEntity<ResponseWrapper> getParents() {
        List<ParentDTO> parentDTOS= parentService.findAll();

        ResponseWrapper responseWrapper = new ResponseWrapper("parents are successfully retrieved", parentDTOS);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .header("Parent","Returned")
                .body(responseWrapper);
    }
    

}
