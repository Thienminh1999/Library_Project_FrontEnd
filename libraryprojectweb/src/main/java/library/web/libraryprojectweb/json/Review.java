package library.web.libraryprojectweb.json;

import java.sql.Date;

import library.web.libraryprojectweb.entities.ReviewInfo;


public class Review {
	private String reviewID;
    private String userID;
    private String bookID;
    private String content;
    private Date createWhen;
    private String modifiedBy;
    private String fullNameUser;
    private String bookName;

    public Review() {
    }

    public Review(String reviewID, String userID, String bookID, String content, Date createWhen, String modifiedBy,
            String fullNameUser, String bookName) {
        this.reviewID = reviewID;
        this.userID = userID;
        this.bookID = bookID;
        this.content = content;
        this.createWhen = createWhen;
        this.modifiedBy = modifiedBy;
        this.fullNameUser = fullNameUser;
        this.bookName = bookName;
    }

    public Review(ReviewInfo reviewinfo, String Fullname, String BookName){
        this.reviewID = reviewinfo.getReviewID();
        this.userID = reviewinfo.getUserID();
        this.bookID = reviewinfo.getBookID();
        this.content = reviewinfo.getContent();
        this.createWhen = reviewinfo.getCreateWhen();
        this.modifiedBy = reviewinfo.getModifiedBy();
        this.fullNameUser = Fullname;
        this.bookName = BookName;
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

    public String getFullNameUser() {
        return fullNameUser;
    }

    public void setFullNameUser(String fullNameUser) {
        this.fullNameUser = fullNameUser;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

}
