package library.web.libraryprojectweb.entities;


public class SubCategory {
	private String subCategoryID;
    private String subCategoryName;
    private String categoryID;

    public SubCategory(String subCategoryID, String subCategoryName, String categoryID) {
        this.subCategoryID = subCategoryID;
        this.subCategoryName = subCategoryName;
        this.categoryID = categoryID;
    }

    public String getSubCategoryID() {
        return subCategoryID;
    }

    public void setSubCategoryID(String subCategoryID) {
        this.subCategoryID = subCategoryID;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public SubCategory() {
    }
}
