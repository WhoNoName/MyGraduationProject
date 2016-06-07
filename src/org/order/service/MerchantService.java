package org.order.service;

import org.order.util.OrderResult;

public interface MerchantService {
	
	public OrderResult loadMerchantByMerchantId(String merchantId);
	
	public OrderResult loadMerchantByScanName(String scanName);
	
	public OrderResult loadMerchantOrderByScore(String typeId);
	
	public OrderResult loadMerchantOrderByTime(String typeId);
	
	public OrderResult loadMerchantOrderBySales(String typeId);
	
	public OrderResult loadMerchantOrderById(String typeId);
	
	public OrderResult loadMerchantByTypeId(String typeId);

	public OrderResult loadAllMerchant();

}
