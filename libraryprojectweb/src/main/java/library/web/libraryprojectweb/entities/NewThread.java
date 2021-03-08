package library.web.libraryprojectweb.entities;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.ser.std.StdArraySerializers.BooleanArraySerializer;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import library.web.libraryprojectweb.controllers.CommonController;

public class NewThread extends Thread {
    private final String CHECK_QR_USER_CODE_URL = "http://localhost:8080/api/getqruserinfo";
    private final String CHECK_QR_BOOK_CODE_URL = "http://localhost:8080/api/getqrbookinfo";
    private boolean running = true;
    private User user = null;
    private BookInfo book = null;
    private Boolean checkObj = false;

    public BeanUserRentBook test = new BeanUserRentBook();

    public boolean isRunning(){
        return this.running;
    }

    public BeanUserRentBook getBean() {
        return this.test;
    }

    public void run() {
        // long startTime = System.currentTimeMillis();
        int i = 0;
        // UserRentBook test = new UserRentBook();
        // BeanUserRentBook test = new BeanUserRentBook();
        while (running) {
            System.out.println(this.getName() + ": New Thread is running..." + i++);

            RestTemplate restTemplate = new RestTemplate();
            user = restTemplate.getForObject(CHECK_QR_USER_CODE_URL, User.class);
            book = restTemplate.getForObject(CHECK_QR_BOOK_CODE_URL, BookInfo.class);

            if (user != null) {
                System.out.println("User: " + user.getFullName());
                test.setUser(user);
                CommonController.toRentPagewithouThread();
            }
            if (book != null) {
                System.out.println("Book: " + book.toString());
                test.addToList(book);
            }

          
            try {
                //Wait for one sec so it doesn't print too fast
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
    }
}
