package bd.c9;

import bd.c9.controllers.AppController;
import bd.c9.controllers.ClientController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class C9Application implements CommandLineRunner {
	@Autowired
	private AppController appController;

	public static void main(String[] args) {
		SpringApplication.run(C9Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		appController.startApp();
	}
}
