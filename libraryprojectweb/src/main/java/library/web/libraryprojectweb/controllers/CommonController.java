package library.web.libraryprojectweb.controllers;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import javax.servlet.http.HttpServletRequest;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import library.web.libraryprojectweb.Utils.CommonUtil;
import library.web.libraryprojectweb.entities.BeanUserRentBook;
import library.web.libraryprojectweb.entities.MyRunable;
import library.web.libraryprojectweb.entities.NewThread;
import library.web.libraryprojectweb.entities.User;
import library.web.libraryprojectweb.entities.UserRentBook;
import library.web.libraryprojectweb.entities.UserRentBookObj;

@Controller
public class CommonController {
    private boolean threadExists = false;
    final String USER_RENT_BOOK_URL = "http://localhost:8080/api/rent";
    private final String CLEAR_QR_USER_CODE_URL = "http://localhost:8080/api/qrclearuser";
    MyRunable r = null;
    Thread thread = null;
    BeanUserRentBook bean;
    UserRentBook rentbook;

    @GetMapping(value = "/qrcode")
    public void qrcodeexam() {
        String data = "US-000004";
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        try {
            BitMatrix matrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, 200, 200);
            // Write to file image
            String outputFile = "D://user4.png";
            Path path = FileSystems.getDefault().getPath(outputFile);
            MatrixToImageWriter.writeToPath(matrix, "PNG", path);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(value = "/rentbook", method = RequestMethod.GET)
    public ModelAndView toRentPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("rentpage");
        this.bean = new BeanUserRentBook();
        this.rentbook = new UserRentBook();
        bean.addPropertyChangeListener(rentbook);
        if (this.threadExists == false) {
           
            this.r = new MyRunable(bean);
            this.thread = new Thread(this.r);
            this.thread.start();
            this.threadExists = true;
        }
        modelAndView.addObject("rentbook", rentbook);
        if(this.rentbook.getListBook() == null || this.rentbook.getUser() == null){
            modelAndView.addObject("DisableRentBtn", true);
        }else{
            modelAndView.addObject("DisableRentBtn", false);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/userrentbook", method = RequestMethod.POST)
    public ModelAndView forRent(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("rentpage");
        UserRentBook rentbook = (UserRentBook)request.getAttribute("userrentbook");
        UserRentBookObj obj = new UserRentBookObj(rentbook.getUser(), rentbook.getListBook());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = new HttpEntity<String>(CommonUtil.convertToJs(obj), headers);
        UserRentBook result = restTemplate.postForObject(USER_RENT_BOOK_URL, entity, UserRentBook.class);
        this.r.stopThread();
        this.threadExists = false;
        modelAndView.addObject("mess", true);
        modelAndView.addObject("rentbook", this.rentbook);
        return modelAndView;
    }

    @RequestMapping(value = "/clearrentbook")
    public String clearRentBook(){
        
        this.rentbook.setUser(null);
        this.rentbook.setListBook(null);
        RestTemplate restTemplate = new RestTemplate();
        Boolean clearBook = restTemplate.getForObject(CLEAR_QR_USER_CODE_URL, Boolean.class);
        this.r.stopThread();
        this.threadExists = false;
        return "redirect:/rentbook";
    }

    // @RequestMapping(value = "/rentbookauto", method = RequestMethod.GET)
    public static String toRentPagewithouThread() {
        System.out.println("load page");
        return "redirect:/rentbook";
    }

}
