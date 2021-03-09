package library.web.libraryprojectweb.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import library.web.libraryprojectweb.entities.User;
import library.web.libraryprojectweb.models.DashboardInfo;

@Controller
public class UserController {
	final String LIST_USER = "http://localhost:8080/api/users";
	
	@RequestMapping(value = "/users")
	public String getUsers(Model model) {
		RestTemplate restTemplate = new RestTemplate();
		User[] listUser = restTemplate.getForObject(LIST_USER, User[].class);		
		model.addAttribute("listUser",listUser);
		return "member";
	}
}
