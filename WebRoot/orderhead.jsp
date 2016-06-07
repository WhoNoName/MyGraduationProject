<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!-- 顶部菜单条 -->
<header class="header">
	<div class="ui-width">
		<figure>
			<a href="toIndex.do" class="logo">网上订餐</a>
		</figure>

		<div class="search">
			<input type="text" id="sinput" class="sinput placeholder-con"
				value="     搜索店铺"> <a href="JavaScript:void(0)"
				id="f-close-btn" title="搜索" class="search-btn">
            <img alt="搜索" src="images/search_icon.png"/></a>

			<div class="f-search-list"></div>
		</div>
		<nav>
			<ul class="navigat">
				<li class="nav-item " id="order_index_button"><a
					href="toIndex.do" class="nav-link">
                    首页</a></li>
                 <li class="nav-item " id="sales_rank"><a
					href="toIndex.do" class="nav-link">排行榜</a></li>   
				<li class="nav-item " id="user_order_button"><a
					href="toIndex.do" class="nav-link">我的订单</a></li>
				<li class="nav-item " id="merchant_entry" style="display: none;"><a
					href="toMerchantLogin.do" class="nav-link">商家入口</a></li>
			</ul>
		</nav>
		<div id="user_info" class="user-info-widget">
			<div id="login_user_info"  style="display: none;">
				<ul class="login_info">
					<li><a class="user_test usermessage title_btn" href="JavaScript:void(0)">username</a>
					</li>

					<li>				
						<a class="user_test btn_personal title_btn" href="/profile">
                        <span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp;个人中心</a>
					</li>										 
					<li>		
						<a class="user_test btn_logout title_btn" href="JavaScript:">
                        <span class="glyphicon glyphicon-off" aria-hidden="true"></span>&nbsp;退出登录
						</a>
					</li>

					
				</ul>
			</div>


			<div id="logout_user_info" >
				<ul class="logout_info">
					<li><a id="login" href="toLogin.do"><span class="glyphicon glyphicon-log-in" aria-hidden="true"></span>&nbsp;登录|注册</a></li>
				</ul>
			</div>

		</div>

	</div>
</header>