package com.blog.Entities;

public class Comment {
    private int commentId;
    private int userId;
    private int postId;
    private String body;
    private int approved;

    public Comment() {
    }

    public Comment(int commentId, int userId, int postId, String body, int approved) {
        this.commentId = commentId;
        this.userId = userId;
        this.postId = postId;
        this.body = body;
        this.approved = approved;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isApproved() {
        if (approved == 0) {
            return false;
        } else {
            return true;
        }
    }

    public void setApproved(int approved) {
        this.approved = approved;
    }
}