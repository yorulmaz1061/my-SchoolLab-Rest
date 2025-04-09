package com.cydeo.controller;

import com.cydeo.dto.*;
import com.cydeo.service.AddressService;
import com.cydeo.service.ParentService;
import com.cydeo.service.StudentService;
import com.cydeo.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {
    //write a method for teacher and return list of teachers
    private final TeacherService teacherService;
    private final StudentService studentService;
    private final ParentService parentService;
    private final AddressService addressService;

    public SchoolController(TeacherService teacherService, StudentService studentService, ParentService parentService, AddressService addressService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.parentService = parentService;
        this.addressService = addressService;
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
    @GetMapping("/address/{addressId}")
    public ResponseEntity<ResponseWrapper> getAddressById(@PathVariable("addressId") long addressId) throws Exception {
        AddressDTO addressDTO = addressService.findById(addressId);
        ResponseWrapper responseWrapper = new ResponseWrapper("Address "+addressId+" is successfully retrieved", addressDTO);
        return ResponseEntity.status(HttpStatus.OK).body(responseWrapper);
    }
    @PutMapping("/address/{addressId}")
    public AddressDTO updateAddress(@PathVariable("addressId") long addressId, @RequestBody AddressDTO addressDTO) throws Exception {
        addressDTO.setId(addressId);
        AddressDTO updateAddress = addressService.update(addressDTO);
        return updateAddress;

    }


    

}
