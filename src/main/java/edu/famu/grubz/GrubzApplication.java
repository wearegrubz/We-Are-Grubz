package edu.famu.grubz;
import edu.famu.grubz.models.parse.Group;
import edu.famu.grubz.models.parse.User;
import io.github.cdimascio.dotenv.Dotenv;
import org.parse4j.Parse;
import org.parse4j.util.ParseRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GrubzApplication {
	public static void main(String[] args) {
		ParseRegistry.registerSubclass(Group.class);
		ParseRegistry.registerSubclass(User.class);
		Dotenv dotenv = Dotenv.configure().filename(".env").load();
		Parse.initialize(dotenv.get("PARSE_APP_ID"), dotenv.get("PARSE_REST_ID"));
		Parse.initializeAsRoot(dotenv.get("PARSE_APP_ID"), dotenv.get("PARSE_MASTER_KEY"));
		SpringApplication.run(GrubzApplication.class, args);
	}
}
