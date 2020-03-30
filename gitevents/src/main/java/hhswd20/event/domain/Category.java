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
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long categoryid;
	private String name; 
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	@JsonBackReference
	private List<Event> events;
	
	public Category() {}
	
	public Category(String name) {
		super();
		this.name = name;
	}

	public Long getCategoryid() {
		return categoryid;
	}

	public String getName() {
		return name;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return "Category [categoryid=" + categoryid + ", name=" + name + "]";
	}

}
