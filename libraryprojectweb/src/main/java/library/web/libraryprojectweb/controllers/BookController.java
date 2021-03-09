package library.web.libraryprojectweb.controllers;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import library.web.libraryprojectweb.json.Book;

@Controller
public class BookController {
	final String LIST_BOOK = "http://localhost:8080/api/books";

	@RequestMapping(value = "/books")
	public String getBooks(Model model) {
		RestTemplate restTemplate = new RestTemplate();
		
		System.out.println("\n1");
		
		Book[] listBook = restTemplate.getForObject(LIST_BOOK, Book[].class);
		
		System.out.println(((Book)listBook[1]).getBook().getBookName());
		
		model.addAttribute("listBook", listBook);
		return "book";
	}
	
}
