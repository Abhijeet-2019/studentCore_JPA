package com.studentCore.app.main.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PASSPORT")
public class Passport  {
        
        @Id
        @Column(name = "PASSPORT_ID")
        private  long passportId;
        
        @Column(name = "PASSPORT_NUMBER")
        private  String passportNumber;
        
        @Column(name = "PASSPORT_CITY")
        private String passportCity;
        
        @JsonIgnore
        @OneToOne(fetch=FetchType.LAZY,mappedBy = "passport")
        @Cascade(org.hibernate.annotations.CascadeType.ALL)
        private Student student;
        
        public long getPassportId() {
                return passportId;
        }
        
        public void setPassportId(long passportId) {
                this.passportId = passportId;
        }
        
        public String getPassportNumber() {
                return passportNumber;
        }
        
        public void setPassportNumber(String passportNumber) {
                this.passportNumber = passportNumber;
        }
        
        public String getPassportCity() {
                return passportCity;
        }
        
        public void setPassportCity(String passportCity) {
                this.passportCity = passportCity;
        }
        
        public Student getStudent() {
                return student;
        }
        
        public void setStudent(Student student) {
                this.student = student;
        }
        
        @Override
        public String toString() {
                return String.format("Passport Number -->"+passportNumber+"Passport City"+passportCity);
                
        }
}
