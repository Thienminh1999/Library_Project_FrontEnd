package library.web.libraryprojectweb.entities;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties.Lettuce.Cluster.Refresh;

import library.web.libraryprojectweb.controllers.CommonController;

public class BeanUserRentBook{
    private User user;
    private List<BookInfo> listBook;

    // private List<PropertyChangeListener> listener = new
    // ArrayList<PropertyChangeListener>();
    private PropertyChangeSupport changeSupport;

    public BeanUserRentBook() {
        changeSupport = new PropertyChangeSupport(this);
    }

    public BeanUserRentBook(User user, List<BookInfo> listBook) {
        this.user = user;
        this.listBook = listBook;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        changeSupport.firePropertyChange("user", this.user, user);
        this.user = user;
        System.out.print("In setUser :" + this.user.getFullName());
    }

    public List<BookInfo> getListBook() {
        return listBook;
    }

    public void setListBook(List<BookInfo> listBook) {
        changeSupport.firePropertyChange("listBook", this.listBook, listBook);
        this.listBook = listBook;
        System.out.print("In setListBook :" + this.user.getFullName());
    }

    public List<BookInfo> addToList(BookInfo bookinfo) {
        List<BookInfo> oldList = this.listBook;
        System.out.println("AddToBeanList");
        if (listBook== null) {
            listBook= new ArrayList<>();
        }
        listBook.add(bookinfo);
        changeSupport.firePropertyChange("listBook", oldList, this.listBook);
        //this.setListBook(listBookObj);
        return this.listBook;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    // @Override
    // public void propertyChange(PropertyChangeEvent evt) {
    //     //this.setUser((User)evt.getNewValue());

    // }

}
