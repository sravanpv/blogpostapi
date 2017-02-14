package com.nwea.techops.blogpostapi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.nwea.techops.blogpostapi.model.BlogpostModel;
import com.nwea.techops.blogpostapi.utils.ApplicationConstants;

@Component
public class BlogpostApiDAO {

	@Autowired
	@Qualifier("blogspotNamedJdbcTemplate")
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	@Qualifier("blogspotJdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@PostConstruct
	private void createTable() {
		jdbcTemplate.execute(ApplicationConstants.CREATE_TABLE_QUERY);
	}

	public List<BlogpostModel> getPosts() throws SQLException, DataAccessException {
		List<BlogpostModel> postList = null;
		postList = namedParameterJdbcTemplate.query(
				ApplicationConstants.GET_POSTS_QUERY,
				new ResultSetExtractor<List<BlogpostModel>>() {
					@Override
					public List<BlogpostModel> extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						List<BlogpostModel> postList = new ArrayList<BlogpostModel>();
						BlogpostModel post = null;
						while (rs.next()) {
							post = new BlogpostModel();
							post.setBody(rs.getString("body"));
							post.setTitle(rs.getString("title"));
							postList.add(post);
						}
						return postList;
					}
				});
		return postList;
	}
	
	public void insertPosts(BlogpostModel model) throws SQLException, DataAccessException {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("title", model.getTitle());
		paramMap.put("body", model.getBody());
		namedParameterJdbcTemplate.update(ApplicationConstants.INSERT_POST_QUERY, paramMap);
		
	}
	
	
}
