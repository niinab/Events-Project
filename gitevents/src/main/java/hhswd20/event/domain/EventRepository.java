package hhswd20.event.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//CrudRepository rajapinnan parametrisointi

public interface EventRepository extends CrudRepository<Event, Long> {
	
	//Metodiesittelyt 
	
	List<Event> findByName(String name);
	List<Event> findByDate(String date);
	List<Event> deleteByName(String name);
	public Event findById(String id);

}