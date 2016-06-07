<%@ page pageEncoding="UTF-8" contentType="text/html;"%>
<%@ page import="java.util.*"%>


<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>

<link type="text/css" rel="stylesheet" media="screen"
	href="css/bootstrap.min.css" />

<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/login.css" />


<style type="text/css">
</style>

</head>
<body>

	<%@include file="orderhead.jsp"%>



	<div class="login_body">
		<div class="global">

			<div class="log log_in" tabindex="-1" id="dl">

				<dl>
					<dt>
						<div class="titles">
							<h3>登&nbsp;录</h3>
						</div>
					</dt>
					<dt></dt>

					<dt>
						<div class="letter">
							用户名:&nbsp; <input type="text" name="" id="count" tabindex="1"
								class="form-control" placeholder="手机号或用户名" />
							<div class="warning warning_span" id="count_warning">
								<span id="count_span" style="color:red" class="warning_span"></span>
							</div>


						</div>
					</dt>
					<dt>
						<div class="letter">
							密&nbsp;&nbsp;&nbsp;码:&nbsp; <input type="password" name=""
								class="form-control" id="password" tabindex="2" placeholder="密码" />
							<div class="warning warning_span" id="password_warning">
								<span class="warning_span" id="password_span" style="color:red">
								</span>
							</div>


						</div>
					</dt>

					<dt>
						<div class="letter ">
							验证码: <input type="text" name="" id="captcha" tabindex="3"
								class="form-control" placeholder="输入验证码" /> <img
								src="createImg.do" class="form-control-static" alt="验证码"
								title="点击更换"
								onclick="javascript:this.src=this.src+'?time='+Math.random()" />
							<div class="warning warning_span" id="captcha_warning">
								<span class="warning_span" id="captcha_span" style="color:red">
								</span>
							</div>

						</div>
					</dt>
					<dt>
						<div>
							<input type="button" name="" id="login_btn"
								class="login_page_btn" value="&nbsp登&nbsp录&nbsp" tabindex="4" />
							<input type="button" name="" id="sig_in" class="login_page_btn"
								value="&nbsp注&nbsp册&nbsp" tabindex="5" />
						</div>
					</dt>
					<dt>
						<div>
							<!--  <span class="other_login">可使用其他账号直接登录:			
					   
					    <a href="https://api.weibo.com/oauth2/authorize?client_id=1772937595&response_type=code&redirect_uri=https://account.ele.me/auth/connect/weibo" class="a-img"><img src="images/login-weibo.png" /></a>
					    <a href="http://graph.renren.com/oauth/grant?client_id=d8599a91632b4f5290708672bfc499ab&redirect_uri=https://account.ele.me/auth/connect/renren&response_type=code&display=page&secure=true&origin=00000" class="a-img"><img src="images/login-renren.png" /></a>
					    </span> -->
							<a class="forget_password" href="#">忘记密码？点击找回</a>
						</div>
					</dt>
				</dl>
			</div>



			<div class="sig sig_out" tabindex="-1" id="zc"
				style="visibility:hidden;">
				<dl>
					<dt>
						<div class="titles">
							<h3>注&nbsp;册</h3>
						</div>
					</dt>
					<dt></dt>
					<dt>
						<div class="letter">
							用&nbsp;户&nbsp;名:&nbsp;<input type="text" name=""
								id="regist_username" class="sinput placeholder-con form-control"
								tabindex="10" />
							<div class="warning warning_span" id="warning_1">
								<span>该用户名不可用</span>
							</div>
						</div>
					</dt>
					<dt>
						<div class="letter">
							地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址:&nbsp;<input type="text"
								class="form-control" name="" id="regist_address" tabindex="11" />
							<div class="warning warning_span" id="warning_4">
								<span>地址不可为空</span>
							</div>
						</div>
					</dt>

					<dt>
						<div class="letter">
							手&nbsp;机&nbsp;号:&nbsp;<input type="text" name=""
								class="form-control" id="regist_phonenum" tabindex="12"
								maxlength="11" />
							<div class="warning warning_span" id="warning_5">
								<span>手机号不可为空</span>
							</div>
						</div>
					</dt>

					<dt>
						<div class="letter">
							密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;<input
								class="form-control" type="password" name=""
								id="regist_password" tabindex="13" />
							<div class="warning warning_span" id="warning_2">
								<span>密码长度过短</span>
							</div>
						</div>
					</dt>
					<dt>
						<div class="letter">
							确认密码:<input type="password" name="" id="final_password"
								class="form-control" tabindex="14" />
							<div class="warning warning_span" id="warning_3">
								<span>密码输入不一致</span>
							</div>
						</div>
					</dt>
					<dt>
						<div>
							<input type="button" name="" id="regist_button"
								class="login_page_btn" value="&nbsp注&nbsp册&nbsp" tabindex="15" />
							<input type="button" name="" id="back" class="login_page_btn"
								value="&nbsp返&nbsp回&nbsp登&nbsp录&nbsp" tabindex="16" />

						</div>
					</dt>
				</dl>
			</div>


		</div>
	</div>


	<%@include file="orderfoot.jsp"%>
	<!-- <div id="orderfoot">
		<ul>
			<li><a href="merchant.do" target="_blank"><span
					class="glyphicon glyphicon-home" aria-hidden="true"></span>&nbsp;商户中心</a>
			</li>
			<li><span class="glyphicon glyphicon-phone-alt"
				aria-hidden="true"></span>&nbsp; 管理热线：<em>1111111111111111</em> <span>&nbsp;&nbsp;&nbsp;&nbsp;
					<span class="glyphicon glyphicon-time" aria-hidden="true"> </span>&nbsp;工作时间：周一至周日10:00-22:00
			</span></li>
			<li><span class="glyphicon glyphicon-pencil" aria-hidden="true">
			</span>&nbsp; Design by WJX</li>
		</ul>
	</div> -->


	<script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>
	<script type="text/javascript" src="js/base.js"></script>
	<script type="text/javascript" src="js/header_title.js"></script>
	<script type="text/javascript" src="js/index_dishes_type.js"></script>

	<script type="text/javascript" src="js/cookie_util.js"></script>
	<script type="text/javascript" src="js/user.js"></script>
	<script type="text/javascript" src="js/actions.js"></script>

	<script type="text/javascript">
		$("#user_info").hide();

		$("#user_order_button").hide();

		$("#merchant_entry").show();
		$(function() {
			//header
			head_things();

			//登录按钮单击处理
			$("#login_btn").click(userLogin);

			//登录部分回车处理
			login_functions();

			//注册按钮单击处理
			$("#regist_button").click(userRegist);

			//点击按钮清除闪烁
			$("#sig_in").click(function() {
				$(".letter .warning").hide();

			});

		});
	</script>
</body>
</html>