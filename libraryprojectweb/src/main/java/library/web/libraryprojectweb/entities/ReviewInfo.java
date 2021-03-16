package library.web.libraryprojectweb.entities;

import java.sql.Date;


public class ReviewInfo {
   
    private String reviewID;
    private String userID;
    private String bookID;
    private String content;
    private Date createWhen;
    private String modifiedBy;

    public ReviewInfo(String reviewID, String userID, String bookID, String content, Date createWhen, String modifiedBy) {
        this.reviewID = reviewID;
        this.userID = userID;
        this.bookID = bookID;
        this.content = content;
        this.createWhen = createWhen;
        this.modifiedBy = modifiedBy;
    }

    public ReviewInfo(String reviewID, String userID, String bookID, String content, Date createWhen) {
        this.reviewID = reviewID;
        this.userID = userID;
        this.bookID = bookID;
        this.content = content;
        this.createWhen = createWhen;
       
    }

    public String getReviewID() {
        return reviewID;
    }

    public void setReviewID(String reviewID) {
        this.reviewID = reviewID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ReviewInfo() {
    }

    public Date getCreateWhen() {
        return createWhen;
    }

    public void setCreateWhen(Date createWhen) {
        this.createWhen = createWhen;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
