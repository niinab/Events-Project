package hhswd20.event.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hhswd20.event.domain.CategoryRepository;
import hhswd20.event.domain.Event;
import hhswd20.event.domain.EventRepository;
import hhswd20.event.domain.LocationRepository;

@Controller
public class EventController {
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired 
	private CategoryRepository catRepository;
	
	@Autowired 
	private LocationRepository locRepository;
	
	@RequestMapping(value = "/allevents", method = RequestMethod.GET)
	public String getAllEvents(Model model) {
		List<Event> events = (List<Event>) eventRepository.findAll();
		model.addAttribute("events", events);
		return "eventlist";
	}
	
	//REST service to get all events 
	@RequestMapping(value = "/events", method = RequestMethod.GET)
	public @ResponseBody List<Event> eventListRest() {
		return (List<Event>) eventRepository.findAll();
	}
	
	//REST service events by id
	@RequestMapping(value = "/events/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Event> findBookRest(@PathVariable("id") Long eventId) {
		return eventRepository.findById(eventId);
	}
		
	
	@RequestMapping(value = "/newevent", method = RequestMethod.GET)
	public String getNewEventForm(Model model) {
		model.addAttribute("event", new Event());
		model.addAttribute("categories", catRepository.findAll());
		model.addAttribute("locations", locRepository.findAll());
		return "eventform";
	}
	
	//Name validointi
	@PostMapping("/newevent")
	public String checkEventName(@Valid Event event, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "validform";
		}
		return "allevents";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveEvent(@ModelAttribute Event event) {
		eventRepository.save(event);
		return "redirect:/allevents";
		
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteEvent(@PathVariable("id") Long eventId) {
		eventRepository.deleteById(eventId);
		return "redirect:../allevents";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/editevent/{id}")
	public String getNewEventForm(@PathVariable("id") Long eventId, Model model) {
		model.addAttribute("event", eventRepository.findById(eventId));
		model.addAttribute("events", eventRepository.findAll());
		model.addAttribute("categories", catRepository.findAll());
		model.addAttribute("locations", locRepository.findAll());
		return "editevent";
	}
}


