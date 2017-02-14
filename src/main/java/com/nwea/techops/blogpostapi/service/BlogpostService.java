package com.nwea.techops.blogpostapi.service;


import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwea.techops.blogpostapi.dao.BlogpostApiDAO;
import com.nwea.techops.blogpostapi.model.BlogpostModel;

@Service
public class BlogpostService {

	@Autowired
	BlogpostApiDAO blogspotDAO;
	
	public void postBlogData(BlogpostModel blogpostModel)throws SQLException
	{
		blogspotDAO.insertPosts(blogpostModel);
	}
	
	public List<BlogpostModel> getBlogData()throws SQLException
	{
		return blogspotDAO.getPosts();
	}
	
}
