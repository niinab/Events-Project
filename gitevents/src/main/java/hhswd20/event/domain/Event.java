package hhswd20.event.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Event {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String date;
	private String time;
	private String description;
	private Double price;
	
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "categoryid")
	private Category category;
	
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "locationid")
	private Location location;
	
	public Event() {}
	
	public Event(String name, String date, String time, String description, Double price, Category category, Location location) {
		super();
		this.name = name;
		this.date = date;
		this.time = time;
		this.description = description;
		this.price = price;
		this.category = category;
		this.location = location;
	}


	public Long getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getDate() {
		return date;
	}


	public String getTime() {
		return time;
	}

	public String getDescription() {
		return description;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public Location getLocation() {
		return location;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public void setTime(String time) {
		this.time = time;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		if (this.category != null)
			return "Event [id=" + id + ", name=" + name +", date=" + date +", time=" + time + ", description=" + description + ", price=" + price
					+ " category=" + this.getCategory() + ", location =" + this.getLocation() + "]";
		else 
			return "Event [id=" + id + ", name=" + name +", date=" + date + ", time=" + time + ", description=" + description + ", price=" + price
					+ "]";
	}

}
