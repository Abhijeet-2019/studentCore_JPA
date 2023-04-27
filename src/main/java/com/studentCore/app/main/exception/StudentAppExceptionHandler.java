package com.studentCore.app.main.exception;


import groovy.util.logging.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;


@ControllerAdvice
@Slf4j
public class StudentAppExceptionHandler {
        @ExceptionHandler({RuntimeException.class})
        public ResponseEntity<String> handleRunTimeException(RuntimeException e) {
                return error(INTERNAL_SERVER_ERROR, e);
        }
        
        
        @ExceptionHandler({RecordNotFoundException.class})
        public ResponseEntity<String> handleRecordNotFoundException(RuntimeException e) {
                return error(INTERNAL_SERVER_ERROR, e);
        }
        
        private ResponseEntity<String> error(HttpStatus status, Exception e) {
                System.out.println(" The error --->"+e.getMessage());
                return ResponseEntity.status(status).body(e.getMessage());
        }
}
