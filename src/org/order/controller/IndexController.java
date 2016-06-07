package org.order.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.entity.Dishes;
import org.order.entity.Merchant;
import org.order.service.DishesService;
import org.order.service.DishesTypeService;
import org.order.service.MerchantService;
import org.order.service.UserService;
import org.order.util.OrderResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ��ҳ����������
 * @author 
 *
 */
@Controller
public class IndexController {
	
	@Resource(name="dishesService")
	private DishesService dishesService;
	
	@Resource(name="dishesTypeService")
	private DishesTypeService dishesTypeService;
	
	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="merchantService")
	private MerchantService merchantService;
	
	/**
	 * ��ҳ��ת
	 * @return
	 */
	@RequestMapping("/toIndex.do")
	public String toIndex() {
		System.out.println("toIndex����");
		return "index";
	}
	
	/**
	 * ��¼ҳ��ת
	 * @return
	 */
	@RequestMapping("/toLogin.do")
	public String toLogin() {
		System.out.println("toLogin����");
		return "login";
	}
	
	/**
	 * �̼���ϸҳ��ת
	 * @return
	 */
	@RequestMapping("/toMerchantDishesDetail.do")
	
	public String toMerchantDishesDetail(HttpServletRequest req, HttpServletResponse res) {
		String merchantId = req.getParameter("id");
		System.out.println(merchantId);
		System.out.println("toMerchantDishesDetail����");
		return "merchantDishesDetail";
	}
	
	/**
	 * ��ɶcontroller
	 * @param randomNum
	 * @return
	 */
	@RequestMapping("/showrandomdetails.do")
	@ResponseBody
	public OrderResult showIndexRandomDetails(String randomNum) {
		System.out.println(randomNum);
		OrderResult or = dishesService.loadDishesByRandomNum(randomNum);
		System.out.println(or);
		return or;
	}

	/**
	 * ����ҳ���̼�
	 * @param typeId
	 * @return
	 */
	@RequestMapping("/loaddishestable.do")
	@ResponseBody
	public OrderResult loadDishesTable(){
		
		OrderResult or = merchantService.loadAllMerchant();
		return or;
	}

	/**
	 * ������������
	 * @return
	 */
	@RequestMapping("/loaddishestype.do")
	@ResponseBody
	public OrderResult loadDishesTypeOption(){
		OrderResult or = dishesTypeService.loadAllDishesType();
		return or;
	}
	
	/**
	 * �����ͼ���
	 * @param typeId
	 * @return
	 */
	@RequestMapping("/loaddishesbytypeid.do")
	@ResponseBody
	public OrderResult loadDishesByTypeId(String typeId){
		OrderResult or = merchantService.loadMerchantByTypeId(typeId);
		return or;
	}
	
	/**
	 * ����������
	 * @param scanName
	 * @return
	 */
	@RequestMapping("/loaddishesbyscanname.do")
	@ResponseBody
	public OrderResult loadMerchantByScannerName(String scanName){
		System.out.println(scanName);
		OrderResult or = merchantService.loadMerchantByScanName(scanName);
		System.out.println(or);
		return or;
	}
	
	/**
	 * ��id����
	 * @return
	 */
	@RequestMapping("/loaddishesbyselectbtn1.do")
	@ResponseBody
	public OrderResult loadMerchantOrderById(String typeId){
		System.out.println(typeId);
		OrderResult or = merchantService.loadMerchantOrderById(typeId);
		System.out.println(or);
		return or;
	}
	
	/**
	 * ����������
	 * @param typeId
	 * @return
	 */
	@RequestMapping("/loaddishesbyselectbtn2.do")
	@ResponseBody
	public OrderResult loadMerchantOrderBySales(String typeId){
		System.out.println(typeId);
		OrderResult or = merchantService.loadMerchantOrderBySales(typeId);
		System.out.println(or);
		return or;
	}
	
	/**
	 * ���Ͳ�ʱ������
	 * @param typeId
	 * @return
	 */
	@RequestMapping("/loaddishesbyselectbtn3.do")
	@ResponseBody
	public OrderResult loadMerchantOrderByTime(String typeId){
		System.out.println(typeId);
		OrderResult or = merchantService.loadMerchantOrderByTime(typeId);
		System.out.println(or);
		return or;
	}
	
	/**
	 * ����������
	 * @param typeId
	 * @return
	 */
	@RequestMapping("/loaddishesbyselectbtn4.do")
	@ResponseBody
	public OrderResult loadMerchantOrderByScore(String typeId){
		System.out.println(typeId);
		OrderResult or = merchantService.loadMerchantOrderByScore(typeId);
		System.out.println(or);
		return or;
	}
	
	/**
	 * ��¼��ʾ��
	 * @param userId
	 * @return
	 */
	@RequestMapping("/checkLoadUser.do")
	@ResponseBody
	public OrderResult loadIndexUserName(String userId){
		OrderResult or = userService.checkIndexUserLoad(userId);
		return or;
	}
	
}
