package hhswd20.event;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hhswd20.event.domain.Category;
import hhswd20.event.domain.Event;
import hhswd20.event.domain.EventRepository;
import hhswd20.event.domain.Location;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EventRepositoryTest {
	
	@Autowired
	private EventRepository eventRepository;
	
	//Etsi tietyllä nimellä ja päivämäärällä testi
	@Test
	public void findByNameShouldReturnEvent() {
		List<Event> events = eventRepository.findByName("Pilates");
		assertThat(events).hasSize(1);
		assertThat(events.get(0).getDate()).isEqualTo("24.05.2020");
	}
	
	//Luo uusi tapahtuma testi
/**	@Test
	public void createNewEvent() {
		Event event = new Event("Testievent", "26.05.2020", "klo 18.00", 16.95, new Category("Test"), new Location("Testilokaatio"));
		eventRepository.save(event);
		assertThat(event.getId()).isNotNull();
	} */
	
	//Poista tapahtuma
	@Test
	public void deleteEvent() {
		List<Event> events = eventRepository.deleteByName("Puppy Yoga");
		assertThat(events).hasSize(1);
		assertThat(events.get(0).getDate()).isEqualTo("21.05.2020");
	}
	

}
