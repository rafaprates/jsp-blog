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

    public static List<Post> listAllLimitBy(int limit) {
        List<Post> posts = new ArrayList<Post>();
        Connection con = Connector.connect();
        try {
            String sql = "SELECT * FROM posts " +
                         "ORDER BY created_at DESC " +
                         "LIMIT ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, limit);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Post p = new Post();
                p.setId(rs.getInt("post_id"));
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

    public static Post getById(String postId) {
        Post p = new Post();
        Connection con = Connector.connect();
        try {
            String sql = "SELECT * FROM posts WHERE post_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, postId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p.setId(rs.getInt("post_id"));
                p.setUserId(rs.getInt("user_id"));
                p.setTitle(rs.getString("title"));
                p.setBody(rs.getString("body"));
            }
        } catch (SQLException e) {
            return p;
        }
        return p;
    }

    public static List<Post> listAll() {
        List<Post> posts = new ArrayList<Post>();
        Connection con = Connector.connect();
        try {
            String sql = "SELECT * FROM posts " +
                    "ORDER BY created_at DESC;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Post p = new Post();
                p.setId(rs.getInt("post_id"));
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

    public static void updatePost(Post p) {
        Connection con = Connector.connect();
        try {
            String sql = "UPDATE posts SET title = ?, body = ? " +
                         "WHERE post_id = ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p.getTitle());
            ps.setString(2, p.getBody());
            ps.setInt(3, p.getId());
            ps.execute();
        } catch (SQLException e) {
            return;
        }
    }

    public static String delete(String postId) {
        Connection con = Connector.connect();
        try {
            String sql = "DELETE FROM posts WHERE post_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, postId);
            ps.execute();
        } catch (SQLException e) {
            return e.getMessage();
        }
        return "Post com id " + postId + "deletado com sucesso.";
    }
}