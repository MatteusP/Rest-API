package APIRest.springbootpostgres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootPostgresApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPostgresApplication.class, args);
	}

	@GetMapping("/")
	public String index(){
		return "olá Mundo";
	}

}
