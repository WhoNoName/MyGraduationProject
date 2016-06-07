package org.order.controller;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import org.order.service.UserService;
import org.order.util.ImageUtil;
import org.order.util.OrderResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 二级控制器
 * @author 
 *
 */
@Controller
public class LoginController {
	
	@Resource
	private UserService userService;

	@RequestMapping("/toLoginTest.do")
	public String toLogin() {
		System.out.println("toLogin方法");
		return "loginTest";
	}
	
	/**
	 * 验证码创建
	 * @param session
	 * @param res
	 * @return
	 */
	@RequestMapping("/createImg.do")
	public String imgcreate(HttpSession session,HttpServletResponse res) {
		Object[] obj = ImageUtil.createImage();
		session.setAttribute("imageCode",obj[0]);
		res.setContentType("image/jpeg");
		OutputStream output;
		try {
			output = res.getOutputStream();
			ImageIO.write((BufferedImage)obj[1] , "jpg", output);
			res.getOutputStream().flush();
			res.getOutputStream().close();
			output.flush();
			output.close();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	/**
	 * 登录
	 * @param name
	 * @param password
	 * @return
	 */
	@RequestMapping("/orderlogin.do")
	@ResponseBody
	public OrderResult checkLogin(HttpServletRequest req, HttpServletResponse res){
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String captcha = req.getParameter("captcha");
		System.out.println(name+","+password+","+captcha);
		OrderResult or = new OrderResult();
		HttpSession session = req.getSession();
		String imgCode = (String)session.getAttribute("imageCode");
		System.out.println(imgCode);
		if(captcha.equalsIgnoreCase(imgCode)){
			or = userService.userLogin(name,password);
			System.out.println(or);
			return or;
		}else{
			or.setMsg("验证码错误");
			or.setStatus(2);
			return or;
		}
		
	}
	
	
	/**
	 * 注册登录名检测
	 * @param userName
	 * @return
	 */
	@RequestMapping("/checkregistusername.do")
	@ResponseBody
	public OrderResult checkRegistUserName(String userName){
		OrderResult or = userService.checkRegistUserName(userName);
		System.out.println(or);
		return or;
	}
	
	/**
	 * 注册手机号检测
	 * @param uphon
	 * @return
	 */
	@RequestMapping("/checkregistuserphone.do")
	@ResponseBody
	public OrderResult checkRegistUserPhone(String uphon){
		OrderResult or = userService.checkRegistUserPhone(uphon);
		System.out.println(or);
		return or;
	}
	
	/**
	 * 注册录入
	 * @param user_name
	 * @param password
	 * @param dishes_address
	 * @param phone_num
	 * @return
	 */
	@RequestMapping("/orderregist.do")
	@ResponseBody
	public OrderResult registUser(String name,
			String uphon, String password, String uaddr){
		OrderResult or = userService.saveUser(name,password,
				uaddr,uphon);
		System.out.println(or);
		return or;
	}
	
}
