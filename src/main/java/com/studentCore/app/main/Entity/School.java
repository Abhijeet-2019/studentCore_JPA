package com.studentCore.app.main.Entity;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "SCHOOL")
public class School {
        
        @Id
        @Column(name = "SCHOOL_ID")
        private long schoolId;
        
        @Column(name="SCHOOL_NAME")
        private String schoolName;
        
        @Column(name="SCHOOL_CITY")
        private String schoolCity;
        
        @OneToMany(fetch = FetchType.LAZY,mappedBy = "school")
                @Cascade(org.hibernate.annotations.CascadeType.ALL)     
        private List<Student> students = new ArrayList<>();
        
        public String getSchoolCity() {
                return schoolCity;
        }
        
        public void setSchoolCity(String schoolCity) {
                this.schoolCity = schoolCity;
        }
        
        public String getSchoolName() {
                return schoolName;
        }
        
        public void setSchoolName(String schoolName) {
                this.schoolName = schoolName;
        }
        
        public long getSchoolId() {
                return schoolId;
        }
        
        public void setSchoolId(long schoolId) {
                this.schoolId = schoolId;
        }
        
        @Override
        public String toString() {
                return  String.format("School Name -->"+schoolName+"--City-->"+schoolCity);
        }
        
        public void addStudents(Student student) {
                this.students.add(student);
        }
        
}
