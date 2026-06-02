package cl.blockbuster.resenias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableFeignClients
public class ReseniasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReseniasApplication.class, args);
		System.out.println("Funcionando - resenias");
	}

}
