package org.order.dao;

import java.util.List;

import org.order.entity.User;

public interface UserDao {
	
	public Integer saveUser(User user);
	
	public User findByUserId(String userId);

	public User findUserByName(String userName);
	
	public User findByPhoneNum(String phoneNum);
}
