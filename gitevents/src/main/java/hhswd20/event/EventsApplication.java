package hhswd20.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hhswd20.event.domain.Event;
import hhswd20.event.domain.EventRepository;
import hhswd20.event.domain.Category;
import hhswd20.event.domain.CategoryRepository;
import hhswd20.event.domain.Location;
import hhswd20.event.domain.LocationRepository;
import hhswd20.event.domain.User;
import hhswd20.event.domain.UserRepository;

@SpringBootApplication
public class EventsApplication {
	
	private static final Logger log = LoggerFactory.getLogger(EventsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EventsApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner event(EventRepository eventRepository, CategoryRepository catRepository, LocationRepository locRepository, UserRepository usRepository) {
		return(args) -> {
			log.info("save an event");
			//name,date,time,description, price, category, location
			Category category1 = new Category("Sports");
			catRepository.save(category1);
			Category category2 = new Category("Music");
			catRepository.save(category2);
			Category category3 = new Category("Food");
			catRepository.save(category3);
			Category category4 = new Category("Family events");
			catRepository.save(category4);
			
			Location location1 = new Location("Narinkkatori");
			locRepository.save(location1);
			Location location2 = new Location("Alppipuisto");
			locRepository.save(location2);
			Location location3 = new Location("Tavastia");
			locRepository.save(location3);
			Location location4 = new Location("Korjaamo");
			locRepository.save(location4);
			Location location5 = new Location("Doesn't have specific location");
			locRepository.save(location5);
			
			eventRepository.save(new Event("Puppy Yoga", "21.05.2020", "Klo 18.30", "Enjoy yoga with cute puppies! You don't have to have puppy to join", 15.95, category1, location2));
			eventRepository.save(new Event("Pilates", "24.05.2020", "Klo 17.00", "Strength and flexibility! Welcome to pilates class", 10.50, category1, location2));
			eventRepository.save(new Event("Restaurant Day", "24.07.2020", "Klo 13.00-18.00", "Restaurant Day represents urban culture at its best. Based on voluntary "
					+ "participation and own initiative, anyone can open a popup restaurant for the day. Your imagination is the limit for your unique restaurant concept and menu.", 0.00, category3, location5));
			eventRepository.save(new Event("Virtual jazz gig", "24.05.2020", "Klo 16.00", "Enjoy jazz virtually! Bands: Jazzers, Fifties, Gentlemen and many more ", 24.95, category2, location5));
			
			//user/password1, admin/password2
			User user1 = new User("user", "$2a$09$Edug0wYYjf4yRZsw6BanmeHfrB/97Fwi.MFn78eLiAMgUuOlnl.ei", "USER");
			User user2 = new User("admin", "$2a$09$WiLyQkmR52Asm7PfHzT51.JAHgNxp4y4gM67790rHChx2DbfvuJTG", "ADMIN");
			usRepository.save(user1);
			usRepository.save(user2);
			
			log.info("fetch all events");
			for (Event event : eventRepository.findAll()) {
				log.info(event.toString());
			}
			
		};
	}

}
