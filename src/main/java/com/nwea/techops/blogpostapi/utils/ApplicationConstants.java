package com.nwea.techops.blogpostapi.utils;

public class ApplicationConstants {
	
	public static String GET_POSTS_QUERY = "SELECT * FROM posts";
	public static String CREATE_TABLE_QUERY = "CREATE TABLE posts(post_id INTEGER PRIMARY KEY AUTOINCREMENT,title character varying(500),body character varying(5000));";
	
	public static String INSERT_POST_QUERY = "INSERT INTO POSTS(title,body) values (:title,:body)";

}
