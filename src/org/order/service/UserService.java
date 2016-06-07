package org.order.service;

import org.order.util.OrderResult;

public interface UserService {
	
	public OrderResult saveUser(String user_name,
			String password, String dishes_address, String phone_num);

	public OrderResult checkRegistUserPhone(String userPhone);

	public OrderResult checkRegistUserName(String userName);

	public OrderResult userLogin(String name, String password);

	public OrderResult checkIndexUserLoad(String userId);

}
