package library.web.libraryprojectweb.entities;

public class RentDetailInfo {
	private String rentID;
    private String bookID;

    public RentDetailInfo(String rentID, String bookID) {
        this.rentID = rentID;
        this.bookID = bookID;
    }

    public String getRentID() {
        return rentID;
    }

    public void setRentID(String rentID) {
        this.rentID = rentID;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }
}
