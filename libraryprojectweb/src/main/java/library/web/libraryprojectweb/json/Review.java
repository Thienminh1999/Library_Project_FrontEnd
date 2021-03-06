package library.web.libraryprojectweb.json;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Review {
	private String reviewID;
    private String userID;
    private String bookID;
    private String content;
    
	public Review() {
		
	}
	
	public Review(String reviewID, String userID, String bookID, String content) {
		this.reviewID = reviewID;
		this.userID = userID;
		this.bookID = bookID;
		this.content = content;
	}
    
    public Review convertToEntity() {
    	Review review = new Review();
    	review.setReviewID(reviewID);
    	review.setUserID(userID);
    	review.setBookID(bookID);
    	review.setContent(content);
    	return review;
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
