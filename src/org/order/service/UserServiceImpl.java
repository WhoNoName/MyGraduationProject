package org.order.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.order.dao.UserDao;
import org.order.entity.Dishes;
import org.order.entity.User;
import org.order.util.OrderResult;
import org.order.util.OrderUtil;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserDao userDao;

	@Override
	public OrderResult userLogin(String name,String password) {
		OrderResult or = new OrderResult();
		User user1 = userDao.findUserByName(name);
		User user2 = userDao.findByPhoneNum(name);
		if(user1 != null && user2 == null){
			if(user1.getPassword().equals(password)){
				or.setData(new User(user1.getUserId(),user1.getUser_name()));
				or.setMsg("成功");
				or.setStatus(0);
				return or;			
			} else {
				or.setMsg("用户名密码错误");
				or.setStatus(1);
				return or;
			}
		} else if(user2 != null && user1 == null){
			if(user2.getPassword().equals(password)){
				or.setData(new User(user2.getUserId(),user2.getUser_name()));
				or.setMsg("成功");
				or.setStatus(0);
				return or;			
			} else {
				or.setMsg("用户名密码错误");
				or.setStatus(1);
				return or;
			}
		} else {
			or.setMsg("用户名密码错误");
			or.setStatus(1);
			return or;
		}

	
		
	}

	@Override
	public OrderResult checkIndexUserLoad(String userId) {
		OrderResult or = new OrderResult();
		User user = userDao.findByUserId(userId);
		if(user != null){
			or.setData(user.getUser_name());
			or.setStatus(0);
			return or;
		}else{
			or.setMsg("显示失败");
			or.setStatus(1);
			return or;
		}
	}

	@Override
	public OrderResult checkRegistUserPhone(String userPhone) {
		OrderResult or = new OrderResult();
		User user = userDao.findByPhoneNum(userPhone);
		if(user != null){
			or.setMsg("该号码已注册");
			or.setStatus(1);
			return or;		
		}
		or.setMsg("该号码可注册");
		or.setStatus(0);
		return or;	
	}

	@Override
	public OrderResult checkRegistUserName(String userName) {
		OrderResult or = new OrderResult();
		User user = userDao.findUserByName(userName);
		if(user != null){
			or.setMsg("该用户名已占用");
			or.setStatus(1);
			return or;		
		}
		or.setMsg("该用户名可注册");
		or.setStatus(0);
		return or;	
		
	}

	@Override
	public OrderResult saveUser(String user_name,
			String password, String dishes_address, String phone_num) {
		OrderResult or = new OrderResult();
		User user = new User();
   
		String userId = OrderUtil.createId();
		System.out.println(userId);
		user.setUserId(userId);
		user.setUser_name(user_name);
		user.setDishes_address(dishes_address);
		user.setPassword(password);
		user.setUser_permission(2);
		user.setPhone_num(phone_num);
		user.setUser_create_time(new Date());
		
		Integer xx = userDao.saveUser(user);
		if(xx != 0){
			or.setMsg("注册成功");
			or.setStatus(0);
			return or;	
		}
		or.setMsg("注册失败");
		or.setStatus(1);
		return or;	
	}




}
