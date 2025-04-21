package service;

import dao.UserDAO;
import model.User;

import java.sql.SQLException;

public class UserService {
    public static Integer saveUser(User user){
        try{
            if(UserDAO.isExists(user.getEmail())){
                return 0;
            }else{
                return UserDAO.saveUser((user));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
