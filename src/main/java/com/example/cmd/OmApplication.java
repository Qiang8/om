package com.example.cmd;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import com.example.cmd.pojo.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class OmApplication {
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(OmApplication.class, args);
		ObjectMapper mapper = context.getBean(ObjectMapper.class);
		Student  stu = new Student();
		stu.setAge(22);
		stu.setName("Daniel");
		
		try {
	             System.out.println(mapper.writeValueAsString(stu));
	      } catch (JsonProcessingException e) {
	             e.printStackTrace();
	      }
	      
	      String json = "{\"name\":\"Daniel\",\"age\":22}";
	      
	      try {
	             Student p2 = mapper.readValue(json, Student.class);
	             System.out.println(p2);
	      } catch (IOException e) {
	             e.printStackTrace();
	      }
	}
	
	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
	
	
}
