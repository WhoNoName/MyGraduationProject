package org.order.service;

import java.util.List;

import javax.annotation.Resource;

import org.order.dao.MerchantDao;
import org.order.entity.Dishes;
import org.order.entity.Merchant;
import org.order.util.OrderResult;
import org.springframework.stereotype.Service;

@Service("merchantService")
public class MerchantServiceImpl implements MerchantService {
	
	@Resource
	private MerchantDao merchantDao;

	@Override
	public OrderResult loadAllMerchant() {
		OrderResult or = new OrderResult();
		List<Merchant> list = merchantDao.findAllMerchant();
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
	public OrderResult loadMerchantByTypeId(String typeId) {
		List<Merchant> list;
		if(typeId.equals("tp0")){
			list = merchantDao.findAllMerchant();
		}else{
			list = merchantDao.findMerchantByTypeId(typeId);
			
		}
		OrderResult or = new OrderResult();
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
	public OrderResult loadMerchantOrderById(String typeId) {
		List<Merchant> list;
		if("tp0".equals(typeId)){
			list = merchantDao.findAllMerchantOrderById();
		}else{
			list = merchantDao.findMerchantOrderById(typeId);
			
		}
		OrderResult or = new OrderResult();
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
	public OrderResult loadMerchantOrderBySales(String typeId) {
		List<Merchant> list;
		if("tp0".equals(typeId)){
			list = merchantDao.findAllMerchantOrderBySales();
		}else{
			list = merchantDao.findMerchantOrderBySales(typeId);
			
		}
		OrderResult or = new OrderResult();
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
	public OrderResult loadMerchantOrderByTime(String typeId) {
		List<Merchant> list;
		if("tp0".equals(typeId)){
			list = merchantDao.findAllMerchantOrderByTime();
		}else{
			list = merchantDao.findMerchantOrderByTime(typeId);
		}
		OrderResult or = new OrderResult();
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
	public OrderResult loadMerchantOrderByScore(String typeId) {
		List<Merchant> list;
		if("tp0".equals(typeId)){
			list = merchantDao.findAllMerchantOrderByScore();
		}else{
			list = merchantDao.findMerchantOrderByScore(typeId);
		}
		OrderResult or = new OrderResult();
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
	public OrderResult loadMerchantByScanName(String scanName) {
		List<Merchant> list = merchantDao.findMerchantByScanner(scanName);
		OrderResult or = new OrderResult();
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
	public OrderResult loadMerchantByMerchantId(String merchantId) {
		Merchant merchant = merchantDao.findMerchantByMerchantId(merchantId);
		OrderResult or = new OrderResult();
		if(merchant != null){
			or.setData(merchant);
			or.setMsg("加载成功");
			or.setStatus(0);
			return or;
		}
		or.setMsg("加载失败");
		or.setStatus(1);
		return or;
	}

}
