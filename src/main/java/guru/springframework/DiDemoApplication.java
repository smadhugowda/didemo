package guru.springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import guru.springframework.controllers.MyController;
import guru.springframework.examplebeans.FakeDataSource;
import guru.springframework.examplebeans.FakeJMSSource;

@SpringBootApplication
public class DiDemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);
		
		MyController controller = (MyController) ctx.getBean("myController");
		
		controller.hello();
		
		FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
		
		FakeJMSSource  fakeJMSSource = ctx.getBean(FakeJMSSource.class);
		
		System.out.println(fakeDataSource.getUser());
		
		System.out.println(fakeJMSSource.getUser());
	}

}
