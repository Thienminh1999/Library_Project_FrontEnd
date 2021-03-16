package library.web.libraryprojectweb.json;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import library.web.libraryprojectweb.entities.BookInfo;
import library.web.libraryprojectweb.entities.SubCategory;

public class Book {
	private BookInfo book;
	private List<SubCategory> listSubCategory;

	public Book() {

	}

	public Book convertToEntity() {
		Book book = new Book();
		book.setBook(getBook());
		book.setListSubCategory(listSubCategory);
		return book;
	}
	
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
