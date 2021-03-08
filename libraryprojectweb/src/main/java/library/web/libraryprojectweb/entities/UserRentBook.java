package library.web.libraryprojectweb.entities;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class UserRentBook implements PropertyChangeListener, Serializable {
    private static User user = null;
    private static List<BookInfo> listBook = null;

    public UserRentBook() {
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        UserRentBook.user = user;
    }

    public static List<BookInfo> getListBook() {
        return listBook;
    }

    public static void setListBook(List<BookInfo> listBook) {
        UserRentBook.listBook = listBook;
    }

    public static void addToList(BookInfo bookinfo) {
        System.out.println("/n addToList");
        if (listBook == null) {
            listBook = new ArrayList<>();
        }
        listBook.add(bookinfo);
       // return listBook;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("object in propertyChange is:" + evt.getNewValue().toString());
        String object = evt.getNewValue().toString();
        if(object.contains("User")){
             this.setUser((User)evt.getNewValue());
        }else{
            this.setListBook((List<BookInfo>)evt.getNewValue());
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

    

   

    

   

    

   
    
    
}
