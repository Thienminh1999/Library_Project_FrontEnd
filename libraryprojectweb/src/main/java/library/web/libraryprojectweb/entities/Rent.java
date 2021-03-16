package library.web.libraryprojectweb.entities;

import java.sql.Date;


public class Rent {
	private String rentID;
    private Date rentDate;
    private Date returnDate;
    private String userID;
    private String StatusID;

    public Rent(String rentID, Date rentDate, Date returnDate, String userID, String statusID) {
        this.rentID = rentID;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.userID = userID;
        StatusID = statusID;
    }

    public String getRentID() {
        return rentID;
    }

    public void setRentID(String rentID) {
        this.rentID = rentID;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getStatusID() {
        return StatusID;
    }

    public void setStatusID(String statusID) {
        StatusID = statusID;
    }

    public Rent() {
    }
}
