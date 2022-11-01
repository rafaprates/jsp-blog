package com.blog.DAO;

import com.blog.Entities.Post;
import com.blog.Utils.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDAO {
    public static String save(Post p){
        Connection con = Connector.connect();
        if(con != null){
            String sql = "INSERT INTO posts (user_id, title, body)" +
                    "values(?,?,?)";
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, p.getUserId());
                ps.setString(2, p.getTitle());
                ps.setString(3,p.getBody());
                ps.execute();
            } catch (SQLException e) {
                return  "Erro: " + e.getMessage();
            }
            return "Registro inserido com sucesso";
        }
        return "erro de conexão";
    }
}