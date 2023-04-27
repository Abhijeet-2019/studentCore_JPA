package com.studentCore.app.main;


import brave.sampler.Sampler;
import com.studentCore.app.main.services.StudentRecordDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan("com.studentCore.app.main")
@SpringBootApplication
//@EnableDiscoveryClient

public class StudentAppMain  {
        
        private Logger log = LoggerFactory.getLogger(this.getClass());
        @Autowired
        StudentRecordDetailsService schoolDetailsService;
        
        public static void main(String[] args) {
                SpringApplication.run(StudentAppMain.class);
        }
//
//        @Bean
//        public Sampler defaultSampler()
//        {
//                return Sampler.ALWAYS_SAMPLE;
//        }
        
        
}
