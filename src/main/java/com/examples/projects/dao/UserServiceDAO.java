package com.examples.projects.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.examples.projects.model.Users;

@Repository
public class UserServiceDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Users> getUsersList() {
		String sqlQuery = "SELECT ID, NAME, EMAILID FROM USERS";
		Collection<Map<String, Object>> rows = jdbcTemplate.queryForList(sqlQuery);
		List<Users> usersList = new ArrayList<>();
		rows.stream().map((row) -> {
			Users user = new Users();
			user.setId(String.valueOf(row.get("ID")));
			user.setName((String) row.get("NAME"));
			user.setEmailid((String) row.get("EMAILID"));
			return user;
		}).forEach((userObj) -> {
			usersList.add(userObj);
		});
		return usersList;
	}
}
