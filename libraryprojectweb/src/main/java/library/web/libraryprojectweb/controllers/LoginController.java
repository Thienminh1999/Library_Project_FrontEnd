package library.web.libraryprojectweb.controllers;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import library.web.libraryprojectweb.entities.Account;

@Controller
public class LoginController {
    final String CHECK_LOGIN_URL = "http://localhost:8080/api/checkLogin";


  @RequestMapping(value = "/login")
  public String getLogin(HttpServletRequest request) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    RestTemplate restTemplate = new RestTemplate();
    String username = (String)request.getParameter("username");
    String password = (String)request.getParameter("password");
    Account newAccount = new Account(username, password);
    HttpEntity<String> entity =  new HttpEntity<String>(newAccount.toJsonString(), headers);
    Account result = restTemplate.postForObject(CHECK_LOGIN_URL, entity, Account.class);
    if (result != null) {
      return "homepage";
    }
    return "error";
  }

  @GetMapping(value = "/")
  public String welcomepage() {
    return "loginpage";
  }


  //this is changes
  //test merge
}

