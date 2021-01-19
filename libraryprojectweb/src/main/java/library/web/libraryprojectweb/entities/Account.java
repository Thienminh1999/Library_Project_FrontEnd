package library.web.libraryprojectweb.entities;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Account {
    private String username;
    private String password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account() {

    }

    public Account convertToEntity() {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        return account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toJsonString() {
        String jsonString = "";
        try {
            ObjectMapper mapper = new ObjectMapper();
            jsonString = mapper.writeValueAsString(convertToEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    @Override
    public String toString() {
        return "{'password'= '" + password + "'', 'username'='" + username + "''}";
    }

    

}
