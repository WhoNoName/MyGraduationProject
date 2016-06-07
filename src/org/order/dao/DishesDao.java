package org.order.dao;

import java.util.List;

import org.order.entity.Dishes;

public interface DishesDao {
	
	public List<Dishes> findDishesByMerchantIdOrderByPrice(String merchantId);	
	
	public List<Dishes> findDishesByMerchantIdOrderByScore(String merchantId);
	
	public List<Dishes> findDishesByMerchantIdOrderBySales(String merchantId);
	
	public List<Dishes> findDishesByMerchantId(String merchantId);
	
	public Dishes findDishesByRandomNum(int randomNum);
	
	public List<Dishes> findDishesByDishesName(String scanName);
	
	public List<Dishes> findDishesByTypeId(String typeId);

	public List<Dishes> findAllOrderById();
}
