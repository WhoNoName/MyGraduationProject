package org.order.controller;

import javax.annotation.Resource;

import org.order.service.DishesService;
import org.order.service.MerchantService;
import org.order.util.OrderResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商家明细页二级控制器
 * @author 佳
 *
 */
@Controller
public class MerchantDishesDetailController {
	
	@Resource(name="merchantService")
	private MerchantService merchantService;
	
	@Resource(name="dishesService")
	private DishesService dishesService;
	
	/**
	 * 商家明细页商家信息加载
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
	 * 商家明细页菜品信息加载
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
	 * 商家明细页菜品信息加载按销量排序
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
	 * 商家明细页菜品信息加载按评分排序
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
	 * 商家明细页菜品信息加载按价格排序
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
