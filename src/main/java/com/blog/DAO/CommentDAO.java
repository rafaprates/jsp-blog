package com.blog.DAO;

import com.blog.Entities.Comment;
import com.blog.Utils.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDAO {

    public static String save(Comment c){
        Connection con = Connector.connect();
        if (con != null){
            String sql = "INSERT INTO comments (post_id, user_id, body) " +
                         "VALUES (?,?,?)";
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, c.getPostId());
                ps.setInt(2, c.getUserId());
                ps.setString(3, c.getBody());
                ps.execute();
            } catch (SQLException e) {
                return  "Erro: " + e.getMessage();
            }
            return "Registro inserido com sucesso";
        }
        return "erro de conexão";
    }

    public static List<Comment> listAll() {
        List<Comment> comments = new ArrayList<Comment>();
        Connection con = Connector.connect();
        try {
            String sql = "SELECT * FROM comments;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Comment c = new Comment();
                c.setCommentId(rs.getInt("comment_id"));
                c.setPostId(rs.getInt("post_id"));
                c.setUserId(rs.getInt("user_id"));
                c.setBody(rs.getString("body"));
                c.setApproved(rs.getInt("approved"));
                comments.add(c);
            }
        } catch (SQLException e) {
            return comments;
        }
        return comments;
    }

    public static List<Comment> listAllUnapproved() {
        List<Comment> unapprovedComments = new ArrayList<Comment>();
        Connection con = Connector.connect();
        try {
            String sql = "SELECT * FROM comments " +
                         "WHERE approved = 0;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Comment c = new Comment();
                c.setCommentId(rs.getInt("comment_id"));
                c.setPostId(rs.getInt("post_id"));
                c.setUserId(rs.getInt("user_id"));
                c.setBody(rs.getString("body"));
                c.setApproved(rs.getInt("approved"));
                unapprovedComments.add(c);
            }
        } catch (SQLException e) {
            return unapprovedComments;
        }
        return unapprovedComments;
    }

    public static List<Comment> listAllApprovedByPostId(String postId) {
        List<Comment> approvedComments = new ArrayList<Comment>();
        Connection con = Connector.connect();
        try {
            String sql = "SELECT * FROM comments " +
                    "WHERE approved = ? AND post_id = ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, 1);
            ps.setString(2, postId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Comment c = new Comment();
                c.setCommentId(rs.getInt("comment_id"));
                c.setPostId(rs.getInt("post_id"));
                c.setUserId(rs.getInt("user_id"));
                c.setBody(rs.getString("body"));
                c.setApproved(rs.getInt("approved"));
                approvedComments.add(c);
            }
        } catch (SQLException e) {
            return approvedComments;
        }
        return approvedComments;
    }
    public static void approveComment(String commentId) {
        Connection con = Connector.connect();
        try {
            String sql = "UPDATE comments SET approved = 1 " +
                         "WHERE comment_id = ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, commentId);
            ps.execute();
        } catch (SQLException e) {
            return;
        }
    }


    public static List<Comment> listAllFromPost(String postId) {
        List<Comment> comments = new ArrayList<Comment>();
        Connection con = Connector.connect();
        try {
            String sql = "SELECT * FROM comments " +
                         "WHERE post_id = ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, postId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Comment c = new Comment();
                c.setUserId(rs.getInt("user_id"));
                c.setApproved(rs.getInt("approved"));
                c.setBody(rs.getString("body"));
                comments.add(c);
            }
        } catch (SQLException e) {
            return comments;
        }
        return comments;
    }

    public static String delete(String commentId) {
        Connection con = Connector.connect();
        try {
            String sql = "DELETE FROM comments WHERE comment_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, commentId);
            ps.execute();
        } catch (SQLException e) {
            return e.getMessage();
        }
        return "Comment com id " + commentId + " deletado com sucesso.";
    }
}
