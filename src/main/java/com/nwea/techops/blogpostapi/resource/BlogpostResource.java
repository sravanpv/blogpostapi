package com.nwea.techops.blogpostapi.resource;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nwea.techops.blogpostapi.model.BlogpostModel;
import com.nwea.techops.blogpostapi.service.BlogpostService;

@RestController
public class BlogpostResource {
	
	@Autowired
	BlogpostService blogpostService;
	
	@RequestMapping(value="/post", method= RequestMethod.POST)
	public @ResponseBody void postBlog(@RequestBody BlogpostModel blogpostData)throws SQLException{
		 blogpostService.postBlogData(blogpostData);
	}
	
	@RequestMapping(value="/posts", method= RequestMethod.GET)
	public @ResponseBody  List<BlogpostModel> getBlogPosts()throws SQLException{
		return blogpostService.getBlogData();
	}

}
