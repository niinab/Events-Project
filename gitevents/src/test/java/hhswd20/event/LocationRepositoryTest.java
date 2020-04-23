/**package hhswd20.event;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hhswd20.event.domain.Location;
import hhswd20.event.domain.LocationRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LocationRepositoryTest {
	
	@Autowired
	private LocationRepository locRepository;
	
	@Test
	public void findByNameShouldReturnLocation() {
		List<Location> location = locRepository.findByName("Alppipuisto");
		assertThat(location).hasSize(1);	
	}
	
	@Test
	public void deleteLocation () {
		List<Location> location = locRepository.deleteByName("Korjaamo");
		assertThat(location).hasSize(1);
	}

}*/
