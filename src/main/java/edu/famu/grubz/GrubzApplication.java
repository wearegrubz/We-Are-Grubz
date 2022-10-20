package edu.famu.grubz;
import io.github.cdimascio.dotenv.Dotenv;
import org.parse4j.Parse;
import org.parse4j.util.ParseRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GrubzApplication {
	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().filename("env").load();
		Parse.initialize(dotenv.get("PARSE_APP_ID"), dotenv.get("PARSE_REST_ID"));
		SpringApplication.run(GrubzApplication.class, args);
	}
}
