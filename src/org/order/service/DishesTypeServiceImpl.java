package org.order.service;

import java.util.List;

import javax.annotation.Resource;

import org.order.dao.DishesTypeDao;
import org.order.entity.DishesType;
import org.order.util.OrderResult;
import org.springframework.stereotype.Service;

@Service("dishesTypeService")
public class DishesTypeServiceImpl implements DishesTypeService {

	@Resource
	private DishesTypeDao dishesTypeDao;
	
	@Override
	public OrderResult loadAllDishesType() {
		OrderResult or = new OrderResult();
		List<DishesType> list = dishesTypeDao.findAllDishesType();
		if(list.size() != 0){
			or.setData(list);
			or.setStatus(0);
			or.setMsg("���ز�Ʒ���ͳɹ�");
		} else {
			or.setStatus(1);
			or.setMsg("���ز�Ʒ����ʧ��");
		}
		return or;
	}

}
