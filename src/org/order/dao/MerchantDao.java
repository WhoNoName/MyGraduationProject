package org.order.dao;

import java.util.List;

import org.order.entity.Merchant;

public interface MerchantDao {
	
	public Merchant findMerchantByMerchantId(String merchantId);
	
	public List<Merchant> findMerchantByScanner(String userName);
	
	public List<Merchant> findAllMerchantOrderByScore();
	
	public List<Merchant> findMerchantOrderByScore(String typeId);
	
	public List<Merchant> findAllMerchantOrderByTime();
	
	public List<Merchant> findMerchantOrderByTime(String typeId);
	
	public List<Merchant> findAllMerchantOrderBySales();
	
	public List<Merchant> findMerchantOrderBySales(String typeId);
	
	public List<Merchant> findAllMerchantOrderById();
	
	public List<Merchant> findMerchantOrderById(String typeId);
	
	public List<Merchant> findMerchantByTypeId(String typeId);

	public List<Merchant> findAllMerchant();
	
}
