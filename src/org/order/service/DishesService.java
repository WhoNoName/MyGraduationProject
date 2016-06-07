package org.order.service;

import org.order.util.OrderResult;

public interface DishesService {
	
	public OrderResult loadDishesByMerchantIdOrderByPrice(String merchantId);
	
	public OrderResult loadDishesByMerchantIdOrderByScore(String merchantId);
	
	public OrderResult loadDishesByMerchantIdOrderBySales(String merchantId);
	
	public OrderResult loadDishesByMerchantId(String merchantId);
	
	public OrderResult loadDishesByRandomNum(String randomNum);
	
	public OrderResult loadDishesByScanName(String scanName);
	
	public OrderResult loadDishesByTypeId(String typeId);

	public OrderResult loadDishes();
}
