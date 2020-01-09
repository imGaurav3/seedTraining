package spring.demo2;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.demo2.config.AppConfig;
import spring.demo2.config.model.Student;
import spring.demo2.config.service.StudentService;

public class Main {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		StudentService service = ctx.getBean(StudentService.class);
		List<Student> students = service.findAll();
		
		for(Student student : students) {
			System.out.println(student);
		}
	}

}
