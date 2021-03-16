package library.web.libraryprojectweb.entities;

import java.sql.Date;

public class BookInfo {
    private String bookID;
    private String bookName;
    private String publisher;
    private String publishDate;
    private String quantity;
    private String description;
    private String bookPosition;
    private Date createdDate;
    private Date modifiedDate;
    private String createdBy;
    private String modifiedBy;
    private String BookImg;
    private String categoryID;
    private Boolean enable;

    public BookInfo(String bookID, String bookName, String publisher, String publishDate, String quantity,
            String description, String bookPosition, Date createdDate, Date modifiedDate, String createdBy,
            String modifiedBy, String bookImg, String categoryID, Boolean enable) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.quantity = quantity;
        this.description = description;
        this.bookPosition = bookPosition;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.BookImg = bookImg;
        this.categoryID = categoryID;
        this.enable = enable;
    }

    public BookInfo(String bookID, String bookName, String publisher, String publishDate, String quantity,
            String description, String bookPosition, String categoryID) {
                long millis = System.currentTimeMillis();
                Date CreatedDate = new Date(millis);
        this.bookID = bookID;
        this.bookName = bookName;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.quantity = quantity;
        this.description = description;
        this.bookPosition = bookPosition;
        this.categoryID = categoryID;
        this.createdDate = CreatedDate;
        this.createdBy = "admin";
        this.enable = true;
    }

    

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public BookInfo() {
        long millis = System.currentTimeMillis();
        Date CreatedDate = new Date(millis);
        this.createdDate = CreatedDate;
        this.createdBy = "admin";
        this.enable = true;
    }

    public String getBookImg() {
        return BookImg;
    }

    public void setBookImg(String bookImg) {
        BookImg = bookImg;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    
    
}
