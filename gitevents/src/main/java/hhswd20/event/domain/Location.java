package hhswd20.event.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Location {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long locationid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "location")
	@JsonBackReference
	private List<Event> events;
	
	public Location() {}
	
	public Location(String name) {
		super();
		this.name = name;
	}

	public Long getLocationid() {
		return locationid;
	}

	public String getName() {
		return name;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setLocationid(Long locationid) {
		this.locationid = locationid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return "Location [locationid=" + locationid + ", name=" + name + "]";
	}
	

}
