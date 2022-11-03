DROP DATABASE IF EXISTS blog;
CREATE DATABASE blog;
USE blog;

CREATE TABLE IF NOT EXISTS users (
	user_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    username VARCHAR(64) NOT NULL,
    passcode VARCHAR(64) NOT NULL,
    privilege INT NOT NULL DEFAULT 1
);

CREATE TABLE IF NOT EXISTS posts (
	post_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    title VARCHAR(128) NOT NULL,
    body VARCHAR(4096) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE IF NOT EXISTS comments (
	comment_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    post_id INT NOT NULL,
    user_id INT NOT NULL,
    body VARCHAR(1024),
    approved INT DEFAULT (0),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (post_id) REFERENCES posts(post_id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);