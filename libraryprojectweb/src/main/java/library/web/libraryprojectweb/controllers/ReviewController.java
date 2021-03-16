package library.web.libraryprojectweb.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import library.web.libraryprojectweb.json.Review;

@Controller
public class ReviewController {
	final String LIST_REVIEW = "http://localhost:8080/api/morereviewinfo";
	final String REVIEW = "http://localhost:8080/api/review";
	final String DELETE_REVIEW = "http://localhost:8080/api/deletereview";

	
	@RequestMapping(value = "/reviews")
	public String getReviews(Model model) {
		RestTemplate restTemplate = new RestTemplate();
		Review listReview[] = restTemplate.getForObject(LIST_REVIEW, Review[].class);		
		if(listReview.length > 0) {
			model.addAttribute("listReview",listReview);
			return "review";
			
		}
		else {
			return "review";
		}
		//System.out.println("\n demo: " + listReview[0].getContent());		
		
	}
	
	@RequestMapping(value = "/reviews/{reviewID}")
	public String deleteReview(@ModelAttribute("reviewID") String txtReviewID) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		System.out.println("test: " + txtReviewID);
		HttpEntity<String> entity = new HttpEntity<String>(txtReviewID, headers);
		restTemplate.postForObject(DELETE_REVIEW, entity, Review.class);
		
		return "forward:/reviews";
		
	}

}
