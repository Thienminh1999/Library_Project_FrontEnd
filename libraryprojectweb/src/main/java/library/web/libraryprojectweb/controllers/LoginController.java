package library.web.libraryprojectweb.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import library.web.libraryprojectweb.entities.ReviewInfo;
import library.web.libraryprojectweb.entities.User;
import library.web.libraryprojectweb.json.Account;
import library.web.libraryprojectweb.models.DashboardInfo;

@Controller
public class LoginController {
	final String CHECK_LOGIN_URL = "http://localhost:8080/api/checkLogin";
	final String USER_RECENT = "http://localhost:8080/api/getuserrecent";
	final String REVIEW_RECENT = "http://localhost:8080/api/reviewrecent";
	final String DASH_INFO = "http://localhost:8080/api/commoninfo";
	 
	
	@RequestMapping(value = "/home")
	public String getLogin(HttpServletRequest request, Model model) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		Account newAccount = new Account(username, password);
		HttpEntity<String> entity = new HttpEntity<String>(newAccount.toJsonString(), headers);
		Account result = restTemplate.postForObject(CHECK_LOGIN_URL, entity, Account.class);
		if (result != null) {
			User[] listRecentUser = restTemplate.getForObject(USER_RECENT, User[].class);
			ReviewInfo[] listReviewRecent = restTemplate.getForObject(REVIEW_RECENT, ReviewInfo[].class);
			DashboardInfo dash = restTemplate.getForObject(DASH_INFO, DashboardInfo.class);
			
			model.addAttribute("dash", dash);
			model.addAttribute("listRecentUser", listRecentUser);
			model.addAttribute("listReviewRecent", listReviewRecent);
			//System.out.print("\n " + listRecentUser[0].getFullName());
			return "homepage";
		}
		return "redirect:/";

	}

	@RequestMapping(value = "/homes")
	public String getDashBoard( Model model) {
		RestTemplate restTemplate = new RestTemplate();		
		
			User[] listRecentUser = restTemplate.getForObject(USER_RECENT, User[].class);
			ReviewInfo[] listReviewRecent = restTemplate.getForObject(REVIEW_RECENT, ReviewInfo[].class);
			DashboardInfo dash = restTemplate.getForObject(DASH_INFO, DashboardInfo.class);			
			model.addAttribute("dash", dash);
			model.addAttribute("listRecentUser", listRecentUser);
			model.addAttribute("listReviewRecent", listReviewRecent);
			//System.out.print("\n " + listRecentUser[0].getFullName());
			return "homepage";


	}
	
	@GetMapping(value = "/")
	public String welcomepage() {
		return "loginpage";
	}

	// this is changes
	// xyz
	// test merge
}
