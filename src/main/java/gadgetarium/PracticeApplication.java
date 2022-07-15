package gadgetarium;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
		System.out.println("Welcome colleagues, project name is Gadgetarium!");
	}

	@GetMapping("/")
	public String greetingPage(){
		return "<h1>Welcome to Gadgetarium application!!!<h1/>";
	}
}
