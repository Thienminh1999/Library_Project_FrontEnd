package library.web.libraryprojectweb.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import library.web.libraryprojectweb.entities.User;

@Controller
public class UserController {
	final String LIST_USER = "http://localhost:8080/api/users";
	
	@RequestMapping(value = "/users")
	public ModelAndView getUsers(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("member");
		RestTemplate restTemplate = new RestTemplate();
		
		System.out.println("\n1");
		
		User[] listUser = restTemplate.getForObject(LIST_USER, User[].class);
		
		System.out.println(((User)listUser[1]).getUserID());
		
		model.addObject(listUser);
		return model;
	}
}
