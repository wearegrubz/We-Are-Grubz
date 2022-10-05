package edu.famu.booking;
import edu.famu.booking.models.parse.Hotel;
import edu.famu.booking.models.parse.Room;
import edu.famu.booking.models.parse.User;
import io.github.cdimascio.dotenv.Dotenv;
import org.parse4j.Parse;
import org.parse4j.util.ParseRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class BookingApplication {
	public static void main(String[] args) {
		ParseRegistry.registerSubclass(Hotel.class);
		ParseRegistry.registerSubclass(Room.class);
		ParseRegistry.registerSubclass(User.class);
		Dotenv dotenv = Dotenv.configure().filename("env").load();
		Parse.initialize(dotenv.get("PARSE_APP_ID"), dotenv.get("PARSE_REST_ID"));
		SpringApplication.run(BookingApplication.class, args);
	}
}
