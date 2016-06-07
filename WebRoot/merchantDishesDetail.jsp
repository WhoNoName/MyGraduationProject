<%@ page language="java" import="java.util.*" contentType="text/html;"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<title>网上订餐系统</title>

<link rel="stylesheet" href="css/merchant-styles.css" />
</head>

<body>

	<%@include file="orderhead.jsp"%>


<!-- 主体 -->
	<div class="index_body">
		<div class="index_body_box all_show_table">

			<div class="index_dishes_type">

				<table class="merchant_show_table">

				</table>

			</div>

					<div class="index_dishes_orderbutton">

				<table class="col-md-7">
					<tr>
						<td><input id="btn1" type="button" class="btn show_type_checked index_order_btn" value="按默认排序" /></td>
						<td><input id="btn2" type="button" class="btn index_order_btn" value="按销量排序" /></td>
						<td><input id="btn3" type="button" class="btn index_order_btn"
							value="按速度排序" /></td>
						<td><input id="btn4" type="button" class="btn index_order_btn" value="按评分排序" /></td>
						
					</tr>
				</table>
			</div>


			<div class="index_show_dishes">
				<!-- background-->
				<div class="alert_bg" style="display:none"></div>
				<!-- alerts -->
				<div id="alerts">
					
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
				aria-hidden="true"></span>&nbsp; 管理热线：<em>1111111111111111</em> <span>&nbsp;&nbsp;&nbsp;&nbsp;
					<span class="glyphicon glyphicon-time" aria-hidden="true"> </span>&nbsp;工作时间：周一至周日10:00-22:00
			</span></li>
			<li><span class="glyphicon glyphicon-pencil" aria-hidden="true">
			</span>&nbsp; Design by WJX</li>
		</ul>
	</div>



	<footer id="orderfoot">
	<ul>
		<li><a href="merchant.do" target="_blank">商户中心</a></li>
		<li>管理热线：<em>1111111111111111</em> <span>&nbsp;&nbsp;&nbsp;&nbsp;工作时间：周一至周日10:00-22:00</span>
		</li>
		<li>Design by WJX</li>
	</ul>
	</footer>


	<script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>
	<script type="text/javascript" src="js/base.js"></script>
	<script type="text/javascript" src="js/header_title.js"></script>
	<script type="text/javascript" src="js/index_dishes_type.js"></script>
	<script type="text/javascript" src="js/index_select.js"></script>
	<script type="text/javascript" src="js/cookie_util.js"></script>

	<script type="text/javascript">
		//header
		//登录部分
		head_things();
		
		
		$(function() {

		
		
		$.extend({
		getRequestParameter:function(name){
			var url = window.location.search,reg,retVal;
			/*
			 * 其中正则详解：
			 * (^\?|&)以？或者&开头的字符
			 * name是传进来的参数名
			 * =([^&]*)(&|$)表示=后面&前面或者到结束的非&的0+个字符
			 * 通过()组合方式，并且不把RegExp设置为全局g，可以通过match方法返回匹配到的字符串和pattern数组
			 * */
			return name?(reg = new RegExp("(^\\?|&)"+name+"=([^&]*)(&|$)"),retVal = url.match(reg),$.isArray(retVal)&&retVal.length>=3?
					retVal[2]:''):'';
		}
		});
		var merchantId = $.getRequestParameter("id");
		//商家信息加载
		$.ajax({url : schema_url + "/loadmerchantinfo.do",
				type : "post",
				data : {"merchantId":merchantId},
				dataType : "json",
				success : function(result) {
					if (result.status == 0) {
						var dishes = result.data;
						
							var merchantName = dishes.user_name;
							var merchantImg = dishes.user_picture_url;
							var merchantSales = dishes.merchant_sales;
							var merchantAvgTime = dishes.avg_time;
							var merchantScore = dishes.score;
							var merchantAdd = dishes.dishes_address;
							var merchantType = dishes.type_des;
							var merchantPhoneNum = dishes.phone_num;
							$("title").html(merchantName); 
							var dt = "<tr><td rowspan='3' >";
							dt +="<img	class='merchant_picture' alt='' src='";
							dt += merchantImg;
							dt += "' /></td><td>名称：";
							dt +=merchantName;
							dt +="</td>	<td>销量：";
							if (merchantSales == null || merchantSales == "") {
								dt += "暂无";
							} else {
								
								dt += merchantSales;
							}
							dt +="</td><td rowspan='3'>地址：";
							dt +=merchantAdd;
							dt +="</td></tr><tr><td>类型：";
							dt +=merchantType;
							dt +="</td><td>评分：";
							dt +=merchantScore;
							dt +="</td></tr><tr><td>平均送餐时间：";
							if (merchantAvgTime == null || merchantAvgTime == "") {
								dt += "暂无";
							} else {
								
								dt += merchantAvgTime;
							}
							dt +="</td><td>电话：";
							dt +=merchantPhoneNum;
							dt +="</td></tr>";
							var $ta = $(dt);
							
							$(".merchant_show_table").append($ta);
						

					}
				},
				error : function() {
					alert("加载内容失败");
				}

			});
		
		//菜品加载
		$.ajax({
		url : schema_url + "/loaddishesbymerchantid.do",
		type : "post",
		data : {"merchantId":merchantId},
		dataType : "json",
		success : function(result) {
			if (result.status == 0) {
				var dishes = result.data;
				update_dishes(dishes);
			}
		},
		error : function() {
			alert("获取失败");
		}
	});
		
		//手气
		//选择菜品类型
		index_things();

		//吃啥显示
		$("#index_dishes_random").click(randomDishes);

		//默认排序
		$("#btn6").click(function(){
		console.log('btn6');
		$(".index_dishes_orderbutton input").removeClass("show_type_checked");
		$(this).addClass("show_type_checked");
		$.ajax({
			url : schema_url + "/loaddishesbymerchantid.do",
			type : "post",
			data : {"merchantId":merchantId},
			dataType : "json",
			success : function(result) {
				if (result.status == 0) {
					$("#show_float_dishes").empty();
					var dishes = result.data;
						update_dishes(dishes);
				}
			},
			error : function() {
				alert("加载内容失败");
			}

		});
	});
	
	//按销售量显示
	$("#btn7").click(function(){
		$(".index_dishes_orderbutton input").removeClass("show_type_checked");
		$(this).addClass("show_type_checked");
		console.log('btn7');
		$.ajax({
			url : schema_url + "/loaddishesbymerchantidorderbysales.do",
			type : "post",
			data : {"merchantId":merchantId},
			success : function(result) {
				if (result.status == 0) {
					$("#show_float_dishes").empty();
					var dishes = result.data;
						update_dishes(dishes);
				} 
			},
			error : function() {
				alert("加载内容失败");
			}

		});
	});
	
	
	
	
	
	//按评分排序
	$("#btn8").click(function(){
		$(".index_dishes_orderbutton input").removeClass("show_type_checked");
		$(this).addClass("show_type_checked");
		console.log('btn8');
		$.ajax({
			url : schema_url + "/loaddishesbymerchantidorderbyscore.do",
			type : "post",
			data : {"merchantId":merchantId},
			dataType : "json",
			success : function(result) {
				if (result.status == 0) {
					$("#show_float_dishes").empty();
					var dishes = result.data;
						update_dishes(dishes);
				} 
			},
			error : function() {
				alert("加载内容失败");
			}

		});
	});
	
	
	//按价格排序
	$("#btn9").click(function(){
		$(".index_dishes_orderbutton input").removeClass("show_type_checked");
		$(this).addClass("show_type_checked");
		
		console.log('btn9');
		$.ajax({
			url : schema_url + "/loaddishesbymerchantidorderbyprice.do",
			type : "post",
			data : {"merchantId":merchantId},
			dataType : "json",
			success : function(result) {
				if (result.status == 0) {
					$("#show_float_dishes").empty();
					var dishes = result.data;
						update_dishes(dishes);
				} 
			},
			error : function() {
				alert("加载内容失败");
			}

		});
	});
		
		//菜品类型选项
		$(".bar_one a").click(merchantType);
	
	});
	

	//更改显示
function update_dishes(dishes){

	for(var i=0;i<dishes.length;i++){
					var st = "<table class='random_show_dishes'> <tr><td rowspan='3' class='width30'>";
					st += "<img id='randomdishes' alt='pictureofrandomdishes' src='";
					st += dishes[i].dishes_imgurl;
					st += "' />";
					st += "</td>";
					st += "<td class='width40'>";
					st += dishes[i].dishes_name;
					st += "</td>";
					st += "<td>￥";
					st += dishes[i].dishes_price;
					st += "</td>";
					st += "</tr><tr><td>销量：";
					if (dishes[i].dishes_sales == null || dishes[i].dishes_sales == "") {
						st += "暂无";
					} else {
						st += dishes[i].dishes_sales;
					}
					
					st += "</td><td rowspan='2'> <a href='#'>";
					st += "<img class='dishes_click_btn' alt='' src='images/bar1.png' /></a></td></tr>";
					st += "<tr><td>";
					st += "评价：";
					if ( dishes[i].dishes_score == null ||  dishes[i].dishes_score == "") {
						st += "暂无";
					} else {
						st += dishes[i].dishes_score;
					}
					st += "</td></tr></table>";
					
					var $tabl = $(st);
					$tabl.data("dishesId",dishes.dishes_id);
					$("#show_float_dishes").append($tabl);
				}

};
	</script>
</body>
</html>
