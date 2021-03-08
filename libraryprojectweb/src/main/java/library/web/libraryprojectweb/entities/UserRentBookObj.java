package library.web.libraryprojectweb.entities;

import java.util.List;

public class UserRentBookObj {
    private User user = null;
    private List<BookInfo> listBook = null;
    public UserRentBookObj(User user, List<BookInfo> listBook) {
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
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    
}
