package library.web.libraryprojectweb.entities;

public class SubCategory {

    private String subCategoryID;
    private String subCategoryName;

    public SubCategory(String subCategoryID, String subCategoryName) {
        this.subCategoryID = subCategoryID;
        this.subCategoryName = subCategoryName;

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

    public SubCategory() {
    }

}
