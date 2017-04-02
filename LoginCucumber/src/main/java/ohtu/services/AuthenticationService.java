package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import ohtu.data_access.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {

    private UserDao userDao;

    @Autowired
    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));
        System.out.println(password);
        return true;
    }

    private boolean invalid(String username, String password) {
        System.out.println("Entered invalid");
        int sameNames = 0;

        for (User u : userDao.listAll()) {
            if (u.getUsername().equals(username)) {
                sameNames++;
            }
        }

        if ((getSpecialCharacterCount(password) == 0) || (username.length() < 3) || (password.length() < 8) || (sameNames > 0)) {
            return true;
        } else {
            return false;
        }
        

    }

    public int getSpecialCharacterCount(String s) {
        System.out.println("entered gscc");
        int count = 0;

        for (Character c : s.toCharArray()) {
            if ((int) c > 32 && (int) c < 65) {
                count++;
            }
        }
        return count;

    }

}
