package library.web.libraryprojectweb.entities;

public class ReviewInfo {
	private String reviewID;
    private String userID;
    private String bookID;
    private String content;

    public ReviewInfo(String reviewID, String userID, String bookID, String content) {
        this.reviewID = reviewID;
        this.userID = userID;
        this.bookID = bookID;
        this.content = content;
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
}
