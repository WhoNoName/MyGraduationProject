<%@ page language="java" import="java.util.*" contentType="text/html;"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<title>网上订餐系统</title>

<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/style.css" />
</head>


<body>

	<%@include file="orderhead.jsp"%>
	<!-- 首页主体 -->
	<div class="index_body">
		<div class="index_body_box all_show_table">

			<div class="index_dishes_type">

				<table>
					<td class="width50">
						<div class="bar_one">
							<span>商家分类：</span> <a href="JavaScript:void(0)"
								class="type_checked" id="tp0">全部商家</a> <a
								href="JavaScript:void(0)" id="tp1">快餐类</a> <a
								href="JavaScript:void(0)" id="tp2">正餐类</a> <a
								href="JavaScript:void(0)" id="tp3">小吃零食</a> <a
								href="JavaScript:void(0)" id="tp4">甜品饮品</a> <a
								href="JavaScript:void(0)" id="tp5">果蔬生鲜</a>
						</div>
					</td>
					<td class="width10"><button type="button" value="吃啥"
						id="index_dishes_random" class="btn show_type_checked"><span class="glyphicon glyphicon-cutlery"
									aria-hidden="true"></span>&nbsp;吃啥</button></td>
					<td id="show_random_details"></td>
					<td class="width15"><img type="button" value="谁取外卖"
						id="index_dishes_random_btn" src="images/wp.png"></td>
				</table>

			</div>

			<div class="index_dishes_orderbutton">

				<table class="col-md-7">
					<tr>
						<td><button id="btn1" type="button"
								class="btn show_type_checked index_order_btn" value="按默认排序">
								按默认排序<span class="glyphicon glyphicon-triangle-top"
									aria-hidden="true"></span>
							</button></td>
						<td><button id="btn2" type="button"
								class="btn index_order_btn" value="按销量排序">
								按销量排序<span class="glyphicon glyphicon-triangle-bottom"
									aria-hidden="true"></span>
							</button></td>
						<td><button id="btn3" type="button"
								class="btn index_order_btn" value="按速度排序">按速度排序
								<span class="glyphicon glyphicon-triangle-top"
									aria-hidden="true"></span>
							</button></td>
						<td><button id="btn4" type="button"
								class="btn index_order_btn" value="按评分排序">按评分排序
								<span class="glyphicon glyphicon-triangle-bottom"
									aria-hidden="true"></span>
							</button></td>
						
					</tr>
				</table>
			</div>

			<div class="index_show_dishes">
				<!-- background-->
				<div class="alert_bg" style="display:none"></div>
				<!-- alerts -->
				<div id="alerts">
					<div class="modal" id="alert_who" style="display:none">
				      <div class="modal-dialog">
				        <div class="modal-content">
				          <div class="modal-header">
				            <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true" class="close">×</span>
                            <span class="sr-only">Close</span>
									</button>
				            <h4 class="modal-title">看看手气</h4>
                            <input type="button" class="btn"
										id="sure_try" value="试试手气" />
				          </div>
				          <div class="modal-body">
				              <div class="form_id" id="id_and_num">
									<!-- 动态生成 -->
	                          </div>
				          </div>
				          
				        </div>
				      </div>
				    </div>		
				</div>
					

				<div id="show_float_dishes" class="float_dishes">
					<!-- 动态生成 -->
				</div>
				<div class="clear"></div>



			</div>
		</div>
	</div>



	<div id="orderfoot">
		<ul>
			<li><a href="merchant.do" target="_blank"><span
					class="glyphicon glyphicon-home" aria-hidden="true"></span>&nbsp;商户中心</a>
			</li>
			<li><span class="glyphicon glyphicon-phone-alt"
				aria-hidden="true"></span>&nbsp;
				管理热线：<em>1111111111111111</em> 
				<span>&nbsp;&nbsp;&nbsp;&nbsp;
				<span class="glyphicon glyphicon-time" aria-hidden="true">
				</span>&nbsp;工作时间：周一至周日10:00-22:00
				</span>
			</li>
			<li><span class="glyphicon glyphicon-pencil" aria-hidden="true">
				</span>&nbsp;
				Design
				by WJX
			</li>
		</ul>
	</div>


	<script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>
	<script type="text/javascript" src="js/base.js"></script>
	<script type="text/javascript" src="js/header_title.js"></script>
	<script type="text/javascript" src="js/index_dishes_type.js"></script>
	<script type="text/javascript" src="js/index_select.js"></script>
	<script type="text/javascript" src="js/cookie_util.js"></script>

	<script type="text/javascript">
		//标题部分页面选中
		$("#order_index_button").addClass("title_checked_now");
		//header
		//登录部分
		head_things();

		$(function() {

			//主页加载
			loadIndexThings();

			//手气
			//选择菜品类型
			index_things();

			//吃啥显示
			$("#index_dishes_random").click(randomDishes);

			//排序按钮
			select_btn();

			//菜品类型选项
			$(".bar_one a").click(merchantType);

		});
	</script>
</body>
</html>

