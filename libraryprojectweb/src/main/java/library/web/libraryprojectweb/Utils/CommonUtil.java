package library.web.libraryprojectweb.Utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CommonUtil {
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
}
