package library.web.libraryprojectweb.entities;

public class BookUpdateModel {
    private String bookId;
    private String bookName;
    private String quantity;
    private String description;
    private String bookPosition;

    public BookUpdateModel() {
    }

    public BookUpdateModel(String bookId, String bookName, String quantity, String description, String bookPosition) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.quantity = quantity;
        this.description = description;
        this.bookPosition = bookPosition;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBookPosition() {
        return bookPosition;
    }

    public void setBookPosition(String bookPosition) {
        this.bookPosition = bookPosition;
    }

   

   
}
