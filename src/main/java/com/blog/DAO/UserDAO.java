package com.blog.DAO;

import com.blog.Entities.User;
import com.blog.Utils.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public static String save(User u){
        Connection con = Connector.connect();


        if (con != null){
            User existingUser = getByUsername(u.getUsername());
            if (existingUser.getUsername() != null) {
                return "userAlreadyExists";
            }

            String sql = "INSERT INTO users (username, passcode) " +
                         "VALUES (?,?)";
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, u.getUsername());
                ps.setString(2, u.getPasscode());
                ps.execute();
            } catch (SQLException e) {
                return  "Erro: " + e.getMessage();
            }
            return "Registro inserido com sucesso";
        }
        return "erro de conexão";
    }

    public static User getByUsername(String username) {
        User u = new User();
        Connection con = Connector.connect();
        try {
            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                u.setUserId(rs.getInt("user_id"));
                u.setUsername(rs.getString("username"));
                u.setPasscode(rs.getString("passcode"));
                u.setPrivilege(rs.getInt("privilege"));
            }
        } catch (SQLException e) {
            return u;
        }
        return u;
    }
}
