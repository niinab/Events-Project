package hhswd20.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hhswd20.event.domain.Category;
import hhswd20.event.domain.CategoryRepository;
import hhswd20.event.domain.Event;
import hhswd20.event.domain.EventRepository;
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
			Category category1 = new Category("Urheilu");
			catRepository.save(category1);
			Category category2 = new Category("Musiikki");
			catRepository.save(category2);
			Category category3 = new Category("Ruoka");
			catRepository.save(category3);
			Category category4 = new Category("Koko perheen tapahtumat");
			catRepository.save(category4);
			
			Location location1 = new Location("Narinkkatori");
			locRepository.save(location1);
			Location location2 = new Location("Alppipuisto");
			locRepository.save(location2);
			Location location3 = new Location("Tavastia");
			locRepository.save(location3);
			Location location4 = new Location("Korjaamo");
			locRepository.save(location4);
			
			eventRepository.save(new Event("Koira Jooga", "21.05.2020", "Klo 18.30", "Tule joogaamaan koirien kanssa! Oma koira ei pakollinen", 15.95, category1, location2));
			eventRepository.save(new Event("Pilates", "24.05.2020", "Klo 17.00", "Pilates notkistaa ja lisää liikkuvuutta. Tule mukaan rentouttavaan Pilatekseen!", 10.50, category1, location2));
			eventRepository.save(new Event("Ravintolapäivä", "24.07.2020", "Klo 13.00-18.00", "Ravintolapäivässä tarjolla uusia ja vanhoja makuja. Tule herkuttelemaan", 0.00, category3, location4));
			
			//user/password1, admin/password2
			User user1 = new User("user", "$2a$09$7FiG7wiRHqA86mg1ADbNueP/7KkJFRCkhE86cU.b8KCIN/atfm42q", "USER");
			User user2 = new User("admin", "$2a$09$1lY26O9z.zfK2W8qxDbFyOg2sUFeWOpqZS/Lf3f.K2aP9PJpOFG.e", "ADMIN");
			usRepository.save(user1);
			usRepository.save(user2);
			
			log.info("fetch all events");
			for (Event event : eventRepository.findAll()) {
				log.info(event.toString());
			}
			
		};
	}

}
