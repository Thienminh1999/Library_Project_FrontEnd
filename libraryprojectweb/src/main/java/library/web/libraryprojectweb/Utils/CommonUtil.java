package library.web.libraryprojectweb.Utils;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import org.springframework.web.client.RestTemplate;

import library.web.libraryprojectweb.entities.Book;
import library.web.libraryprojectweb.entities.BookFormError;
import library.web.libraryprojectweb.entities.BookInfo;
import library.web.libraryprojectweb.entities.SubCategory;

public class CommonUtil {
    private final static String GET_SUBCATEGORY_LIST_URL = "http://localhost:8080/api/subcates";

    public static String convertToJs(Object ob){
        ObjectMapper mapper = new ObjectMapper();
        try {
            // convert user object to json string and return it 
            return mapper.writeValueAsString(ob);
        }
        catch (Exception  e) {
            // catch various errors
            e.printStackTrace();
        }
        return null;
    }

    public static List<SubCategory> strToListSubCate(String str){
        String[] subID = str.split(",");
        List<SubCategory> listSub = new ArrayList<>();
        RestTemplate rest = new RestTemplate();
        SubCategory[] listSubCate = rest.getForObject(GET_SUBCATEGORY_LIST_URL, SubCategory[].class);
        for(int i=0; i<subID.length; i++){
            for(int j = 0; j<listSubCate.length; j++){
                if(subID[i].trim().equals(listSubCate[j].getSubCategoryID().trim())){
                    listSub.add(listSubCate[j]);
                    break;
                }
            }
        }
        return listSub;
    }

    public static String getRandomBookID(){
        String id = "BO-";
        Random random = new Random();
        for(int i = 0; i<6; i++){
            id = id + random.nextInt(9);
        }
        return id;
    }

    public void qrcodeexam() {
        String data = "US-000004";
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        try {
            BitMatrix matrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, 200, 200);
            // Write to file image
            String outputFile = ".//src//main//resources//static//img//" + data + ".png";
            Path path = FileSystems.getDefault().getPath(outputFile);
            MatrixToImageWriter.writeToPath(matrix, "PNG", path);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static BookFormError checkAddBookError(Book book){
        BookFormError error = new BookFormError();
        BookInfo bookinfo = book.getBook();
        if(bookinfo.getBookName().equals("")){
            error.setBookNameError("Book Name must not be empty");
            error.setCheckError(true);
        }
        if(bookinfo.getPublisher().equals("")){
            error.setPublisherError("Publisher must not be empty");
            error.setCheckError(true);
        }
        if(bookinfo.getPublishDate().equals("")){
            error.setPublishDateError("Publish date must not be empty");
            error.setCheckError(true);
        }
        if(bookinfo.getQuantity().equals("")){
            error.setQuantityError("Quantity must not be empty");
            error.setCheckError(true);
        }
        if(bookinfo.getDescription().equals("")){
            error.setDescriptionError("Description must not be empty");
            error.setCheckError(true);
        }
        if(bookinfo.getBookPosition().equals("")){
            error.setBookPositionError("Book position must not be empty");
            error.setCheckError(true);
        }
        if(bookinfo.getCategoryID().equals("")){
            error.setMainCategoryError("Main category must not be empty");
            error.setCheckError(true);
        }
        if(book.getListSubCategory().isEmpty()){
            error.setSubCategoryError("Sub-category must not be empty");
            error.setCheckError(true);
        }
        return error;
    }
}
