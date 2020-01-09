package spring.demo3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.demo3.config.AppConfig;
import spring.demo3.config.service.AuthorService;
import spring.demo3.config.service.BookService;

public class Main {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		AuthorService service1 = ctx.getBean(AuthorService.class);
		BookService service2 = ctx.getBean(BookService.class);
	}

}
