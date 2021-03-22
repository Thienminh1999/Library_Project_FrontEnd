package library.web.libraryprojectweb.controllers;

import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import library.web.libraryprojectweb.Utils.CommonUtil;
import library.web.libraryprojectweb.entities.Author;
import library.web.libraryprojectweb.entities.Book;
import library.web.libraryprojectweb.entities.BookFormError;
import library.web.libraryprojectweb.entities.BookInfo;
import library.web.libraryprojectweb.entities.BookUpdateModel;
import library.web.libraryprojectweb.entities.Category;
import library.web.libraryprojectweb.entities.SubCategory;
import library.web.libraryprojectweb.entities.ZXingHelper;

@Controller
public class BookController {
    private final String GET_SUBCATEGORY_LIST_URL = "http://localhost:8080/api/subcates";
    private final String GET_MAIN_CATEGORY_LIST_URL = "http://localhost:8080/api/category";
    private final String POST_CREATE_BOOK_URL = "http://localhost:8080/api/createBook";
    private final String GET_ALL_BOOK_URL = "http://localhost:8080/api/books";
    private final String GET_BOOK_BY_ID_URL = "http://localhost:8080/api/bookbyid";
    private final String GET_MAIN_CATEGORY_BY_ID_URL = "http://localhost:8080/api/maincate";
    private final String UPDATE_A_BOOK_URL = "http://localhost:8080/api/book";
    private final String DISABLE_A_BOOK_URL = "http://localhost:8080/api/disablebook";
    private final String FIND_BOOK_BY_NAME_URL = "http://localhost:8080/api/findbook";
    private final String GET_ALL_AUTHOR_URL = "http://localhost:8080/api/authors";

    @RequestMapping(value = "/createBookPage")
    public ModelAndView toCreateBook() {
        ModelAndView model = new ModelAndView("addbook");
        RestTemplate rest = new RestTemplate();
        SubCategory[] listSubCate = rest.getForObject(GET_SUBCATEGORY_LIST_URL, SubCategory[].class);
        Category[] listCate = rest.getForObject(GET_MAIN_CATEGORY_LIST_URL, Category[].class);
        Author[] listAuthor = rest.getForObject(GET_ALL_AUTHOR_URL, Author[].class);
         model.addObject("listAuthor", listAuthor);
        model.addObject("SubCateList", listSubCate);
        model.addObject("MainCateList", listCate);
       
        model.addObject("bookinfo", new BookInfo());
        return model;
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public ModelAndView addABook(@ModelAttribute("bookinfo") BookInfo bookinfo, HttpServletRequest request,
            @RequestParam String btnSaveUpdate) {

        ModelAndView model = new ModelAndView("addbook");
        RestTemplate rest = new RestTemplate();
        if (btnSaveUpdate.equals("update")) {
            System.out.println("bookid: " + bookinfo.getBookID());
            BookUpdateModel updateModel = new BookUpdateModel(bookinfo.getBookID(), bookinfo.getBookName(),
                    bookinfo.getQuantity(), bookinfo.getDescription(), bookinfo.getBookPosition());
            rest.put(UPDATE_A_BOOK_URL, updateModel);
            model.addObject("messUpdate", true);
            model.addObject("bookinfo", bookinfo);
            model.addObject("update", true);
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            String listSubCateID = request.getParameter("listSubCateHidden");
            List<SubCategory> listSubCate = CommonUtil.strToListSubCate(listSubCateID);
            String bookID = CommonUtil.getRandomBookID();
            bookinfo.setBookID(bookID);
            bookinfo.setCategoryID(bookinfo.getCategoryID().trim());
            Book book = new Book(bookinfo, listSubCate);
            System.out.println("size: " + listSubCate.size());
            BookFormError error = CommonUtil.checkAddBookError(book);
            if (error.getCheckError()) {
                model.addObject("bookinfo", bookinfo);
                model.addObject("errorForm", error);
                SubCategory[] listSubCat = rest.getForObject(GET_SUBCATEGORY_LIST_URL, SubCategory[].class);
                Category[] listCate = rest.getForObject(GET_MAIN_CATEGORY_LIST_URL, Category[].class);
                Author[] listAuthor = rest.getForObject(GET_ALL_AUTHOR_URL, Author[].class);
                model.addObject("listAuthor", listAuthor);
                model.addObject("SubCateList", listSubCat);
                model.addObject("MainCateList", listCate);
                return model;
            }
            HttpEntity<String> entity = new HttpEntity<String>(CommonUtil.convertToJs(book), headers);
            Book result = rest.postForObject(POST_CREATE_BOOK_URL, entity, Book.class);
            if (result != null) {
                model.addObject("mess", true);
                model.addObject("bookinfo", bookinfo);
                byte[] img = ZXingHelper.getQRCodeImage(bookinfo.getBookID(), 200, 200);
                model.addObject("img", "data:image/png;base64," + Base64.getEncoder().encodeToString(img));
            }
        }
        return model;
    }

    @RequestMapping(value = "/bookdetail/{bookid}")
    public String toBookDetail(@ModelAttribute("bookid") String txtBookID, Model model) {

        System.out.println("bookid2: " + txtBookID);
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(txtBookID, headers);
        Book book = rest.postForObject(GET_BOOK_BY_ID_URL, entity, Book.class);
        HttpEntity<String> entity2 = new HttpEntity<String>(book.getBook().getCategoryID(), headers);
        Category cate = rest.postForObject(GET_MAIN_CATEGORY_BY_ID_URL, entity2, Category.class);
        model.addAttribute("book", book);
        model.addAttribute("MainCateName", cate.getCategoryName());
        model.addAttribute("listSubCate", book.getListSubCategory());
        model.addAttribute("bookid", txtBookID);
        model.addAttribute("enable", book.getBook().getEnable());
        return "bookdetail";
    }

    @RequestMapping(value = "/managebook")
    public ModelAndView toManagerbook() {
        ModelAndView model = new ModelAndView("book");
        RestTemplate rest = new RestTemplate();
        Book[] listBook = rest.getForObject(GET_ALL_BOOK_URL, Book[].class);
        if (listBook.length == 0) {
            model.addObject("listBook", null);
        } else {
            model.addObject("listBook", listBook);
        }

        return model;
    }

    @RequestMapping(value = "/BookAction")
    public String getActionBook(@RequestParam String btnActionBook) {
        if (btnActionBook.equals("edit")) {
            System.out.println("in action book");
            return "forward:/toEditBookPage";
        }
        return "forward:/toUnavailablebook";
    }

    @RequestMapping(value = "/toEditBookPage")
    public ModelAndView toEditBookPage(HttpServletRequest request) {
        ModelAndView model = new ModelAndView("addbook");
        String bookid = request.getParameter("txtBookID");
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(bookid, headers);
        Book book = rest.postForObject(GET_BOOK_BY_ID_URL, entity, Book.class);

        SubCategory[] listSubCate = rest.getForObject(GET_SUBCATEGORY_LIST_URL, SubCategory[].class);
        Category[] listCate = rest.getForObject(GET_MAIN_CATEGORY_LIST_URL, Category[].class);
        Author[] listAuthor = rest.getForObject(GET_ALL_AUTHOR_URL, Author[].class);
        model.addObject("listAuthor", listAuthor);
        model.addObject("SubCateList", listSubCate);
        model.addObject("MainCateList", listCate);
        model.addObject("bookinfo", book.getBook());
        model.addObject("update", true);
        return model;
    }

    @RequestMapping(value = "/toEditBook/{bookid}")
    public ModelAndView toEditBook(@ModelAttribute("bookid") String txtBookID) {
        ModelAndView model = new ModelAndView("addbook");
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(txtBookID, headers);
        Book book = rest.postForObject(GET_BOOK_BY_ID_URL, entity, Book.class);

        SubCategory[] listSubCate = rest.getForObject(GET_SUBCATEGORY_LIST_URL, SubCategory[].class);
        Category[] listCate = rest.getForObject(GET_MAIN_CATEGORY_LIST_URL, Category[].class);
        Author[] listAuthor = rest.getForObject(GET_ALL_AUTHOR_URL, Author[].class);
        model.addObject("listAuthor", listAuthor);
        model.addObject("SubCateList", listSubCate);
        model.addObject("MainCateList", listCate);
        model.addObject("bookinfo", book.getBook());
        model.addObject("update", true);
        return model;
    }

    @RequestMapping(value = "/disablebook", method = RequestMethod.POST)
    public String disableBook(HttpServletRequest request) {
        String alert = (String) request.getParameter("alert");
        if (alert.equals("OK")) {
            String txtBookID = request.getParameter("txtBookID");
            RestTemplate rest = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<String>(txtBookID, headers);
            BookInfo bookinfo = rest.postForObject(DISABLE_A_BOOK_URL, entity, BookInfo.class);
            return "forward:/managebook";
        } else {
            return  "forward:/managebook";
        }
    }

    @RequestMapping(value = "/searchbook")
    public ModelAndView searchBook(HttpServletRequest request) {
        ModelAndView model = new ModelAndView("book");
        String searchValue = request.getParameter("txtSearchValue");
        if (searchValue.equals("")) {
            model.addObject("listSearchNull", true);
            model.addObject("searchValue", searchValue);
            return model;
        }
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(searchValue, headers);
        Book[] listBook = rest.postForObject(FIND_BOOK_BY_NAME_URL, entity, Book[].class);
        if (listBook.length > 0) {
            model.addObject("listBook", listBook);
        } else {
            model.addObject("listSearchNull", true);
            model.addObject("searchValue", searchValue);
        }
        return model;
    }

}
