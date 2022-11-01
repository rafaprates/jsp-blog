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

    public static List<Post> listAll() {
        List<Post> posts = new ArrayList<Post>();
        Connection con = Connector.connect();
        try {
            String sql = "SELECT * FROM posts " +
                         "ORDER BY created_at DESC " +
                         "LIMIT 10;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Post p = new Post();
                p.setUserId(rs.getInt("user_id"));
                p.setTitle(rs.getString("title"));
                p.setBody(rs.getString("body"));
                posts.add(p);
            }
        } catch (SQLException e) {
            return posts;
        }
        return posts;
    }
}