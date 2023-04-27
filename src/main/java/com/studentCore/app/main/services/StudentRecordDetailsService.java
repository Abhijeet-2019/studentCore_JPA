package com.studentCore.app.main.services;

import com.studentCore.app.main.Entity.Passport;
import com.studentCore.app.main.Entity.School;
import com.studentCore.app.main.Entity.Student;
import com.studentCore.app.main.controllers.beans.StudentRestResponse;
import com.studentCore.app.main.exception.RecordNotFoundException;
import com.studentCore.app.main.repositories.SchoolRepository;
import com.studentCore.app.main.repositories.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class StudentRecordDetailsService {
        
        private Logger log = LoggerFactory.getLogger(this.getClass());
        
        @Autowired
        private SchoolRepository schoolRepository;
        
        @Autowired
        private StudentRepository studentRepository;
        
        
        @Autowired
        private Environment environment;
        
        @Transactional
        public StudentRestResponse fetchAllSchoolDetails() {
                List<School> allDetails = schoolRepository.findAll();
                allDetails.stream().forEach(school -> {
                        log.info("The details {}", school.toString());
                });
                
                StudentRestResponse restResponse = createResponse(allDetails);
                return restResponse;
        }
        
        @Transactional
        public StudentRestResponse fetchAllStudent() {
                List<Student> allStudents = studentRepository.findAll();
                allStudents.stream().forEach(student -> {
                        log.info("All Student Details-->" + student);
                        Passport passport = student.getPassport();
                        log.info("The Passport details " + passport);
                });
                StudentRestResponse restResponse = createResponse(allStudents);
                return restResponse;
                
        }
        
        
        public StudentRestResponse fetchAllStudentWithoutPassport() {
                List<Student> allStudents = studentRepository.fetchStudentWithoutPassport();
                allStudents.stream().forEach(student -> {
                        log.info("All Student Details-->" + student);
                        Passport passport = student.getPassport();
                        log.info("The Passport details " + student.getPassport());
                });
                StudentRestResponse restResponse = createResponse(allStudents);
                return restResponse;
        }
        
        public StudentRestResponse fetchAllStudentWithPassport() {
                List<Student> allStudents = studentRepository.fetchStudentWithPassport();
                allStudents.stream().forEach(student -> {
                        log.info("All Student Details-->" + student);
                        Passport passport = student.getPassport();
                        log.info("The Passport details " + passport);
                });
                StudentRestResponse restResponse = createResponse(allStudents);
                return restResponse;
        }
        
        public StudentRestResponse
        findStudentDetailsByName(String name) {
                List<Student> nameDetails = studentRepository.findBystudentName(name);
                StudentRestResponse restResponse = createResponse(nameDetails);
                return restResponse;
        }
        
        /**
         * Fetch the details of a Student
         *
         * @param id:
         *
         * @return
         */
        public StudentRestResponse findStudentById(long id) {
                StudentRestResponse restResponse = new StudentRestResponse();
                Optional<Student> studentIdOptional = studentRepository.findById(id);
                if (studentIdOptional.isPresent()) {
                        log.info("Returning the details for student with id ->", id);
                         restResponse = createResponse(studentIdOptional.get());
                }
                return restResponse;
        }
        
        public StudentRestResponse createResponse(Object responseData) {
                StudentRestResponse restResponse = new StudentRestResponse();
                Map<String, Object> studentDetailsMap = new HashMap<>();
                studentDetailsMap.put("port", environment.getProperty("local.server.port"));
                restResponse.setResponseStatus("SUCCESS");
                if(null == responseData){
                        throw new RecordNotFoundException("No record found");
                }
                studentDetailsMap.put("data", responseData);
                restResponse.getStudentDetailsMap().putAll(studentDetailsMap);
                return restResponse;
        }
        
}
