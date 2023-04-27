package com.studentCore.app.main.controllers.beans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class StudentRestResponse implements Serializable {
        
        private String              responseStatus;
        private Map<String, Object> studentDetailsMap = new HashMap<>();
        
        public String getResponseStatus() {
                return responseStatus;
        }
        
        public void setResponseStatus(String responseStatus) {
                this.responseStatus = responseStatus;
        }
        
        public Map<String, Object> getStudentDetailsMap() {
                return studentDetailsMap;
        }
}
