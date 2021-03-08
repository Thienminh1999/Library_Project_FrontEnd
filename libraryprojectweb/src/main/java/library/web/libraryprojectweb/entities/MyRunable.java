package library.web.libraryprojectweb.entities;
import org.springframework.web.client.RestTemplate;
public class MyRunable implements Runnable {
    private BeanUserRentBook bean;
    public static boolean running = true;
    private User user = null;
    private BookInfo book = null;
    private boolean checkUser = true;
    private final String CHECK_QR_USER_CODE_URL = "http://localhost:8080/api/getqruserinfo";
    private final String CHECK_QR_BOOK_CODE_URL = "http://localhost:8080/api/getqrbookinfo";
    private final String CLEAR_QR_BOOK_CODE_URL = "http://localhost:8080/api/qrclearbook";

    public MyRunable(BeanUserRentBook bean) {
        this.bean = bean;
        this.running = true;
    }

    public static void stopThread(){
        MyRunable.running = false;
    }

    public void cleanAll(){
        user = null;
        book = null;
    }

    @Override
    public void run() {
       int i = 0;
       while (running) {
           System.out.println(" New Thread is running..." + i++);

           RestTemplate restTemplate = new RestTemplate();
           if(checkUser){
                user = restTemplate.getForObject(CHECK_QR_USER_CODE_URL, User.class);
           }
           book = restTemplate.getForObject(CHECK_QR_BOOK_CODE_URL, BookInfo.class);

           if (user != null && checkUser == true) {   
               bean.setUser(user);
               checkUser = false;
           }
           if (book != null) {
               bean.addToList(book);
               Boolean clearBook = restTemplate.getForObject(CLEAR_QR_BOOK_CODE_URL, Boolean.class);
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
