package dao;

import db.MyConnection;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public static boolean isExists(String email)throws SQLException {
        Connection connection = MyConnection.getConnection();
        PreparedStatement ps =connection.prepareStatement("select email from users");
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            String em = rs.getString(1);
            if (em.equals(email));
            return true;
        }
        return false;
    }
    public static int saveUser(User user)throws SQLException{
        Connection connection = MyConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement("INSERT INTO users (name, email) VALUES (?, ?)");
        ps.setString(1,user.getName());
        ps.setString(2,user.getEmail());
        int i = ps.executeUpdate();
        return i;
    }
}
