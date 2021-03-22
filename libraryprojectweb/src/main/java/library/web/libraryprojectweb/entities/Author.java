package library.web.libraryprojectweb.entities;




public class Author {
    private String authorID;
    private String authorName;
    private String authorImage;
    public Author() {
    }
    public Author(String authorID, String authorName, String authorImg) {
        this.authorID = authorID;
        this.authorName = authorName;
        this.authorImage = authorImg;
    }
    public String getAuthorID() {
        return authorID;
    }
    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public String getAuthorImg() {
        return authorImage;
    }
    public void setAuthorImg(String authorImg) {
        this.authorImage = authorImg;
    }

    
}
