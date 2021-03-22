package library.web.libraryprojectweb.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import library.web.libraryprojectweb.entities.RentDetail;
import library.web.libraryprojectweb.entities.User;

@Controller
public class RentController {

    private final String GET_LIST_RENT_DETAIL_BY_EMAIL =  "http://localhost:8080/api/rentinfos";
    private final String GET_USER_BY_EMAIL =  "http://localhost:8080/api/getuser";
    
    @RequestMapping(value = "/toUserRentDetail")
    public String toUserRentDetail(){
        return "rentbook";
    }

    @RequestMapping(value = "/searchRentDetail")
    public String searchUserRentDetail(HttpServletRequest request, Model model){
        String email =(String)request.getParameter("txtSearchvalueRent");
        System.out.println("Email: " + email);
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(email, headers);
        RentDetail[] listRentDetail = rest.postForObject(GET_LIST_RENT_DETAIL_BY_EMAIL, entity, RentDetail[].class);
        
        User user = rest.postForObject(GET_USER_BY_EMAIL, entity, User.class);
        model.addAttribute("listRent", listRentDetail);
        model.addAttribute("user", user);
        return "rentbook";
    }

    @RequestMapping(value = "/userrentdetail/{txtEmail}")
    public String searchUserRentDetail(@ModelAttribute("txtEmail") String txtEmail, Model model){
        
        System.out.println("Email: " + txtEmail);
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(txtEmail, headers);
        RentDetail[] listRentDetail = rest.postForObject(GET_LIST_RENT_DETAIL_BY_EMAIL, entity, RentDetail[].class);
        if(listRentDetail.length==0){
            model.addAttribute("checkListRent", false);
        }
        User user = rest.postForObject(GET_USER_BY_EMAIL, entity, User.class);
        model.addAttribute("listRent", listRentDetail);
        model.addAttribute("user", user);
        return "rentbook";
    }


}
