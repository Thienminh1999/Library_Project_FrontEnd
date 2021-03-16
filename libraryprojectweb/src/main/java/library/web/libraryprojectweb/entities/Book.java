package library.web.libraryprojectweb.entities;

import java.util.List;


public class Book {
    private BookInfo book;
    private List<SubCategory> listSubCategory;

    public Book(BookInfo book, List<SubCategory> listSubCategory) {
        this.book = book;
        this.listSubCategory = listSubCategory;
    }

    public BookInfo getBook() {
        return book;
    }

    public void setBook(BookInfo book) {
        this.book = book;
    }

    public List<SubCategory> getListSubCategory() {
        return listSubCategory;
    }

    public void setListSubCategory(List<SubCategory> listSubCategory) {
        this.listSubCategory = listSubCategory;
    }

    public Book() {
    }

    
    
    
}
