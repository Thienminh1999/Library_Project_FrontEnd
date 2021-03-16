package library.web.libraryprojectweb.json;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import library.web.libraryprojectweb.entities.BookInfo;
import library.web.libraryprojectweb.entities.User;

public class UserRentBook {
	private User user;
	private List<BookInfo> listBook;
	
	public UserRentBook() {
    }
	
	public UserRentBook convertToEntity() {
		UserRentBook userrentbook = new UserRentBook();
		userrentbook.setUser(user);
		userrentbook.setListBook(listBook);
        return userrentbook;
    }

    public UserRentBook(User user, List<BookInfo> listBook) {
        this.user = user;
        this.listBook = listBook;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<BookInfo> getListBook() {
        return listBook;
    }

    public void setListBook(List<BookInfo> listBook) {
        this.listBook = listBook;
    }
    
    public String toJsonString() {
        String jsonString = "";
        try {
            ObjectMapper mapper = new ObjectMapper();
            jsonString = mapper.writeValueAsString(convertToEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
