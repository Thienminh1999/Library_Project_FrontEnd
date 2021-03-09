package library.web.libraryprojectweb.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import library.web.libraryprojectweb.entities.User;
import library.web.libraryprojectweb.json.Review;

public class ReviewController {
	final String LIST_REVIEW = "http://localhost:8080/api/reviews";
	
	@RequestMapping(value = "/allreview")
	public String getUsers(Model model) {
		RestTemplate restTemplate = new RestTemplate();
		Review[] listReview = restTemplate.getForObject(LIST_REVIEW, Review[].class);		
		model.addAttribute("listReview",listReview);
		return "review";
	}
}
