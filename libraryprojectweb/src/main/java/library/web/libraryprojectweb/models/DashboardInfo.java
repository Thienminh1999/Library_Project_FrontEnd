package library.web.libraryprojectweb.models;

import java.util.List;

import library.web.libraryprojectweb.entities.ReviewInfo;
import library.web.libraryprojectweb.entities.User;

public class DashboardInfo {
	private int memberQuantity;
	private int bookQuantity;
	private int reviewQuantity;
	private int rentingQuantity;

	private List<User> listUserRecent;
	private List<ReviewInfo> listRecentReview;

	public DashboardInfo() {
	}

	public DashboardInfo(int memberQuantity, int bookQuantity, int reviewQuantity, int rentingQuantity,
			List<User> listUserRecent, List<ReviewInfo> listRecentReview) {
		this.memberQuantity = memberQuantity;
		this.bookQuantity = bookQuantity;
		this.reviewQuantity = reviewQuantity;
		this.rentingQuantity = rentingQuantity;
		this.listUserRecent = listUserRecent;
		this.listRecentReview = listRecentReview;
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

	public List<User> getListUserRecent() {
		return listUserRecent;
	}

	public void setListUserRecent(List<User> listUserRecent) {
		this.listUserRecent = listUserRecent;
	}

	public List<ReviewInfo> getListRecentReview() {
		return listRecentReview;
	}

	public void setListRecentReview(List<ReviewInfo> listRecentReview) {
		this.listRecentReview = listRecentReview;
	}
}
