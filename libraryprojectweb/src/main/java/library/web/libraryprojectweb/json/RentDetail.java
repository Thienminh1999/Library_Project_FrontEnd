package library.web.libraryprojectweb.json;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;


public class RentDetail {
	private String rentDetailID;
	private List<Book> listBook;
	
	public RentDetail() {

	}
	
	public RentDetail convertToEntity() {
		RentDetail rentdetail = new RentDetail();
		rentdetail.setRentDetailID(rentDetailID);
		rentdetail.setListBook(listBook);
        return rentdetail;
    }

	public RentDetail(String rentDetailID, List<Book> listBook) {
        this.rentDetailID = rentDetailID;
        this.listBook = listBook;
    }

    public String getRentDetailID() {
        return rentDetailID;
    }

    public void setRentDetailID(String rentDetailID) {
        this.rentDetailID = rentDetailID;
    }

    public List<Book> getListBook() {
        return listBook;
    }

    public void setListBook(List<Book> listBook) {
        this.listBook = listBook;
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
