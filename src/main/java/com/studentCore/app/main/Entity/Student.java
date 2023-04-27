package com.studentCore.app.main.Entity;


import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Table(name = "STUDENT")
public class Student {
        
        @Id
        @Column(name = "STUDENT_ID")
        private long studentId;
        
        @Column(name = "STUDENT_NAME")
        private String studentName;
        
        @Column(name = "STUDENT_GENDER")
        private String studentGender;
        
        @ManyToOne
        @JoinColumn(name = "SCHOOL_ID")
        @Fetch(FetchMode.JOIN)
        private School school;
        
        
        /* This is the Owning side that tells each
         *  Student has a particular Passport.
         */
        @OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name ="PASSPORT_ID")
        @Fetch(FetchMode.JOIN)
        private Passport passport;
        
        public long getStudentId() {
                return studentId;
        }
        
        public void setStudentId(long studentId) {
                this.studentId = studentId;
        }
        
        public String getStudentName() {
                return studentName;
        }
        
        public void setStudentName(String studentName) {
                this.studentName = studentName;
        }
        
        public String getStudentGender() {
                return studentGender;
        }
        
        public void setStudentGender(String studentGender) {
                this.studentGender = studentGender;
        }
        
        public School getSchool() {
                return school;
        }
        
        public void setSchool(School school) {
                this.school = school;
        }
        
        @Override
        public String toString() {
                return String.format("Student Details name-->" + studentName);
        }
        
        public Passport getPassport() {
                return passport;
        }
        
        public void setPassport(Passport passport) {
                this.passport = passport;
        }
}
