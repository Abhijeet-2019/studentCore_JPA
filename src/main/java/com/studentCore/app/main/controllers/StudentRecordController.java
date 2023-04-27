package com.studentCore.app.main.controllers;


import com.studentCore.app.main.Entity.Student;
import com.studentCore.app.main.controllers.beans.StudentRestResponse;
import com.studentCore.app.main.services.StudentRecordDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@ConfigurationPropertiesScan
@RestController
@RequestMapping("/studentRecords")
@CrossOrigin
@Scope("prototype")
public class StudentRecordController {
        
        @Autowired
        StudentRecordDetailsService studentRecordDetailsService;
        
        
        @GetMapping(value = "/findAllStudents")
        public StudentRestResponse findAllStudents(){
                return studentRecordDetailsService.fetchAllStudent();
        }
        
        
        @CrossOrigin
        @RequestMapping(
                value = "/fetchAll", method = RequestMethod.GET)
        public StudentRestResponse findAllStudent() {
                return studentRecordDetailsService.fetchAllStudent();
        }
        
        @CrossOrigin
        @RequestMapping(
                value = "/fetchAllStudentWithoutPassport", method = RequestMethod.GET)
        public StudentRestResponse fetchAllStudentWithoutPassport() {
                return studentRecordDetailsService.fetchAllStudentWithoutPassport();
        }
        
        @CrossOrigin
        @RequestMapping(
                value = "/fetchAllStudentWithPassport", method = RequestMethod.GET)
        public StudentRestResponse fetchAllStudentWithPassport() {
                return studentRecordDetailsService.fetchAllStudentWithPassport();
        }
        
        @CrossOrigin
        @RequestMapping(value = "/fetchByName", method = RequestMethod.GET)
        public StudentRestResponse findByName(@RequestParam(value = "name") String name) {
                return studentRecordDetailsService.findStudentDetailsByName(name);
        }
        
        @CrossOrigin
        @RequestMapping(value = "/fetchById", method = RequestMethod.GET)
        public StudentRestResponse fetchById(@RequestParam(value = "id") long id) {
                return studentRecordDetailsService.findStudentById(id);
        }
}
