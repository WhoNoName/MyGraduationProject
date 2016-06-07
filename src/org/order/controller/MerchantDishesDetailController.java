package org.order.controller;

import javax.annotation.Resource;

import org.order.service.DishesService;
import org.order.service.MerchantService;
import org.order.util.OrderResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * �̼���ϸҳ����������
 * @author ��
 *
 */
@Controller
public class MerchantDishesDetailController {
	
	@Resource(name="merchantService")
	private MerchantService merchantService;
	
	@Resource(name="dishesService")
	private DishesService dishesService;
	
	/**
	 * �̼���ϸҳ�̼���Ϣ����
	 * @param merchantId
	 * @return
	 */
	@RequestMapping("/loadmerchantinfo.do")
	@ResponseBody
	public OrderResult loadMerchantIfo(String merchantId){
		OrderResult or = merchantService.loadMerchantByMerchantId(merchantId);
		System.out.println(or);
		return or;
	}
	
	/**
	 * �̼���ϸҳ��Ʒ��Ϣ����
	 * @param merchantId
	 * @return
	 */
	@RequestMapping("/loaddishesbymerchantid.do")
	@ResponseBody
	public OrderResult loadDishesByMerchantId(String merchantId){
		OrderResult or = dishesService.loadDishesByMerchantId(merchantId);
		System.out.println(or);
		return or;
	}
	
	/**
	 * �̼���ϸҳ��Ʒ��Ϣ���ذ���������
	 * @param merchantId
	 * @return
	 */
	@RequestMapping("/loaddishesbymerchantidorderbysales.do")
	@ResponseBody
	public OrderResult loadDishesByMerchantIdOrderBySales(String merchantId){
		OrderResult or = dishesService.loadDishesByMerchantIdOrderBySales(merchantId);
		System.out.println(or);
		return or;
	}
	
	/**
	 * �̼���ϸҳ��Ʒ��Ϣ���ذ���������
	 * @param merchantId
	 * @return
	 */
	@RequestMapping("/loaddishesbymerchantidorderbyscore.do")
	@ResponseBody
	public OrderResult loadDishesByMerchantIdOrderByScore(String merchantId){
		OrderResult or = dishesService.loadDishesByMerchantIdOrderByScore(merchantId);
		System.out.println(or);
		return or;
	}
	
	/**
	 * �̼���ϸҳ��Ʒ��Ϣ���ذ��۸�����
	 * @param merchantId
	 * @return
	 */
	@RequestMapping("/loaddishesbymerchantidorderbyprice.do")
	@ResponseBody
	public OrderResult loadDishesByMerchantIdOrderByPrice(String merchantId){
		OrderResult or = dishesService.loadDishesByMerchantIdOrderByPrice(merchantId);
		System.out.println(or);
		return or;
	}

}
