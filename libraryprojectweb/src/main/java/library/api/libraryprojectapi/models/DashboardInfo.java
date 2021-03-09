package library.api.libraryprojectapi.models;

public class DashboardInfo {
	private int memberQuantity;
    private int bookQuantity;
    private int reviewQuantity;
    private int rentingQuantity;

    public DashboardInfo() {
    }

    public DashboardInfo(int memberQuantity, int bookQuantity, int reviewQuantity, int rentingQuantity) {
        this.memberQuantity = memberQuantity;
        this.bookQuantity = bookQuantity;
        this.reviewQuantity = reviewQuantity;
        this.rentingQuantity = rentingQuantity;
      
    }

    public int getMemberQuantity() {
        return memberQuantity;
    }

    public void setMemberQuantity(int memberQuantity) {
        this.memberQuantity = memberQuantity;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public int getReviewQuantity() {
        return reviewQuantity;
    }

    public void setReviewQuantity(int reviewQuantity) {
        this.reviewQuantity = reviewQuantity;
    }

    public int getRentingQuantity() {
        return rentingQuantity;
    }

    public void setRentingQuantity(int rentingQuantity) {
        this.rentingQuantity = rentingQuantity;
    }
}
