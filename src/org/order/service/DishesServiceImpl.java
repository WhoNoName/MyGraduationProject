package org.order.service;

import java.util.List;

import javax.annotation.Resource;

import org.order.dao.DishesDao;
import org.order.entity.Dishes;
import org.order.util.OrderResult;
import org.springframework.stereotype.Service;

@Service("dishesService")
public class DishesServiceImpl implements DishesService {
	
	@Resource
	private DishesDao dishesDao;
	
	@Override
	public OrderResult loadDishes() {
		OrderResult or = new OrderResult();
		List<Dishes> list = dishesDao.findAllOrderById();
		if(list.size() != 0){
			or.setData(list);
			or.setMsg("加载成功");
			or.setStatus(0);
			return or;
		}
		or.setMsg("加载失败");
		or.setStatus(1);
		return or;
	}

	@Override
	public OrderResult loadDishesByTypeId(String typeId) {
		OrderResult or = new OrderResult();
		List<Dishes> list = dishesDao.findDishesByTypeId(typeId);
		if(list.size() != 0){
			or.setData(list);
			or.setMsg("加载成功");
			or.setStatus(0);
			return or;
		}
		or.setMsg("加载失败");
		or.setStatus(1);
		return or;
	}

	@Override
	public OrderResult loadDishesByScanName(String scanName) {
		System.out.println(scanName);
		OrderResult or = new OrderResult();
		List<Dishes> list = dishesDao.findDishesByDishesName(scanName);
		if(list.size() != 0){
			or.setData(list);
			or.setMsg("加载成功");
			or.setStatus(0);
			System.out.println(or);
			return or;
		}
		or.setMsg("加载失败");
		or.setStatus(2);
		System.out.println(or);
		return or;
	}

	@Override
	public OrderResult loadDishesByRandomNum(String randomNum) {
		OrderResult or = new OrderResult();
		int ran = Integer.parseInt(randomNum);
		Dishes dishes = dishesDao.findDishesByRandomNum(ran);
		if(dishes != null){
			or.setData(dishes);
			or.setMsg("加载成功");
			or.setStatus(0);
			System.out.println(or);
			return or;
		}
		or.setMsg("加载失败");
		or.setStatus(2);
		System.out.println(or);
		return or;

	}

	@Override
	public OrderResult loadDishesByMerchantIdOrderByScore(String merchantId) {
		OrderResult or = new OrderResult();
		List<Dishes> list = dishesDao.findDishesByMerchantIdOrderByScore(merchantId);
		if(list.size() != 0){
			or.setData(list);
			or.setMsg("加载成功");
			or.setStatus(0);
			return or;
		}
		or.setMsg("加载失败");
		or.setStatus(1);
		return or;
	}

	@Override
	public OrderResult loadDishesByMerchantIdOrderBySales(String merchantId) {
		OrderResult or = new OrderResult();
		List<Dishes> list = dishesDao.findDishesByMerchantIdOrderBySales(merchantId);
		if(list.size() != 0){
			or.setData(list);
			or.setMsg("加载成功");
			or.setStatus(0);
			return or;
		}
		or.setMsg("加载失败");
		or.setStatus(1);
		return or;
	}

	@Override
	public OrderResult loadDishesByMerchantId(String merchantId) {
		OrderResult or = new OrderResult();
		List<Dishes> list = dishesDao.findDishesByMerchantId(merchantId);
		if(list.size() != 0){
			or.setData(list);
			or.setMsg("加载成功");
			or.setStatus(0);
			return or;
		}
		or.setMsg("加载失败");
		or.setStatus(1);
		return or;
	}

	@Override
	public OrderResult loadDishesByMerchantIdOrderByPrice(String merchantId) {
		OrderResult or = new OrderResult();
		List<Dishes> list = dishesDao.findDishesByMerchantIdOrderByPrice(merchantId);
		if(list.size() != 0){
			or.setData(list);
			or.setMsg("加载成功");
			or.setStatus(0);
			return or;
		}
		or.setMsg("加载失败");
		or.setStatus(1);
		return or;
	}

}
