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
                c.setBody(rs.getString("body"));
                comments.add(c);
            }
        } catch (SQLException e) {
            return comments;
        }
        return comments;
    }
}
