package library.web.libraryprojectweb.entities;

public class BookFormError {
    
    private String bookNameError;
    private String publisherError;
    private String publishDateError;
    private String quantityError;
    private String descriptionError;
    private String bookPositionError;
    private String mainCategoryError;
    private String subCategoryError;
    private Boolean checkError = false;
    public BookFormError() {
    }
    public String getBookNameError() {
        return bookNameError;
    }
    public void setBookNameError(String bookNameError) {
        this.bookNameError = bookNameError;
    }
    public String getPublisherError() {
        return publisherError;
    }
    public void setPublisherError(String publisherError) {
        this.publisherError = publisherError;
    }
    public String getPublishDateError() {
        return publishDateError;
    }
    public void setPublishDateError(String publishDateError) {
        this.publishDateError = publishDateError;
    }
    public String getQuantityError() {
        return quantityError;
    }
    public void setQuantityError(String quantityError) {
        this.quantityError = quantityError;
    }
    public String getDescriptionError() {
        return descriptionError;
    }
    public void setDescriptionError(String descriptionError) {
        this.descriptionError = descriptionError;
    }
    public String getBookPositionError() {
        return bookPositionError;
    }
    public void setBookPositionError(String bookPositionError) {
        this.bookPositionError = bookPositionError;
    }
    public String getMainCategoryError() {
        return mainCategoryError;
    }
    public void setMainCategoryError(String mainCategoryError) {
        this.mainCategoryError = mainCategoryError;
    }
    public String getSubCategoryError() {
        return subCategoryError;
    }
    public void setSubCategoryError(String subCategoryError) {
        this.subCategoryError = subCategoryError;
    }
    public Boolean getCheckError() {
        return checkError;
    }
    public void setCheckError(Boolean checkError) {
        this.checkError = checkError;
    }
    
}
