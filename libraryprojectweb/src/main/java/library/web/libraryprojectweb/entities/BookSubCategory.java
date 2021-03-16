package library.web.libraryprojectweb.entities;


public class BookSubCategory {
	private String bookID;
	   
    private String subCategoryID;

    public BookSubCategory(String bookID, String subCategoryID) {
        this.bookID = bookID;
        this.subCategoryID = subCategoryID;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getSubCategoryID() {
        return subCategoryID;
    }

    public void setSubCategoryID(String subCategoryID) {
        this.subCategoryID = subCategoryID;
    }

    public BookSubCategory() {
    }
}
