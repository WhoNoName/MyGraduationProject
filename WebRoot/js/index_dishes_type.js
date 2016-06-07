//主页加载
function loadIndexThings() {
	
	// 加载所有
	$.ajax({	url : schema_url + "/loaddishestable.do",
				type : "post",
				data : "",
				dataType : "json",
				success : function(result) {
					if (result.status == 0) {
						var dishes = result.data;
						for (var i = 0; i < dishes.length; i++) {
							
							var merchantId = dishes[i].user_id;
							var merchantName = dishes[i].user_name;
							var merchantImg = dishes[i].user_picture_url;
							var merchantSales = dishes[i].merchant_sales;
							var merchantAvgTime = dishes[i].avg_time;
							var merchantScore = dishes[i].score;
							
							var dt = "<a href='toMerchantDishesDetail.do?id=" +
									merchantId+"' class='showMerchants'><table class='inner_show_dishes'><tr><td rowspan='2' class='inner_show_dishes_td'>";
							dt += "<img	class='dishes_picture' alt='' src='";
							dt += merchantImg;
							dt += "' />";
							dt += "</td>";
							dt += "<td class='merchant_name'>";
							dt += merchantName;
							dt += "</td>";
							dt += "</tr><tr><td>销量：";
							if (merchantSales == null || merchantSales == "") {
								dt += "暂无";
							} else {
								
								dt += merchantSales;
							}
							dt += "</td></tr><tr><td>评价：";
							dt += merchantScore;
							dt += "</td><td>平均用时：" ;
							if (merchantAvgTime == null || merchantAvgTime == "") {
								dt += "暂无";
							} else {
								
								dt += merchantAvgTime;
							}
							dt += "</td></tr></table></a>";
							var $ta = $(dt);
							$ta.data("merchantId", merchantId);
							$("#show_float_dishes").append($ta);

						}

					}
				},
				error : function() {
					alert("加载内容失败");
				}

			});
	
}

// 主页选择区操作
function index_things() {
	
	var random_who_id = 0;
	var minRandomNum = 200;
	var typeId = 3;
	$("#index_dishes_random_btn").click(function() {
		random_who_id = 0;
		minRandomNum = 200;
		$("#alert_who").show();
		$(".alert_bg").show();
	});
	
	
	$(".close").click(function() {
		$("#alert_who").hide();
		$(".alert_bg").hide();
		$("#id_and_num").empty();
		random_who_id = 0;
		minRandomNum = 200;
	});
	
	
	$("#sure_try").click(
			function() {
				random_who_id += 1;
				var random_try = Math.floor(Math.random() * 100);
				if (minRandomNum > random_try) {
					minRandomNum = random_try;
					$("#id_and_num .selected_boy").removeClass("selected_boy");
					$("#id_and_num").append(
							"<div class='selected_boy'><span>" + random_who_id
									+ "</span>号：" + random_try + "</div>");
				} else {
					$("#id_and_num").append(
							"<div><span>" + random_who_id + "</span>号："
									+ random_try + "</div>");
				}
	});

}

//商家类型
function merchantType(){
	var typeId = $(this).attr("id");
	$(".bar_one a").removeClass("type_checked");
	$(this).addClass("type_checked");
	$(".index_dishes_orderbutton input").removeClass("show_type_checked");
	$("#btn1").addClass("show_type_checked");
	
	$.ajax({
		url : schema_url + "/loaddishesbytypeid.do",
		type : "post",
		data : {"typeId":typeId},
		dataType : "json",
		success : function(result) {
				if (result.status == 0) {
					$(".showMerchants").remove();
					var dishes = result.data;
					for (var i = 0; i < dishes.length; i++) {
						
						var merchantId = dishes[i].user_id;
						var merchantName = dishes[i].user_name;
						var merchantImg = dishes[i].user_picture_url;
						var merchantSales = dishes[i].merchant_sales;
						var merchantAvgTime = dishes[i].avg_time;
						var merchantScore = dishes[i].score;
						
						var dt = "<a href='toMerchantDishesList.do?id=" +
								merchantId+"' class='showMerchants'><table class='inner_show_dishes'><tr><td rowspan='2' class='inner_show_dishes_td'>";
						dt += "<img	class='dishes_picture' alt='' src='";
						dt += merchantImg;
						dt += "' />";
						dt += "</td>";
						dt += "<td class='merchant_name'>";
						dt += merchantName;
						dt += "</td>";
						dt += "</tr><tr><td>销量：";
						if (merchantSales == null || merchantSales == "") {
							dt += "暂无";
						} else {
							
							dt += merchantSales;
						}
						dt += "</td></tr><tr><td>评价：";
						dt += merchantScore;
						dt += "</td><td>平均用时：" ;
						if (merchantAvgTime == null || merchantAvgTime == "") {
							dt += "暂无";
						} else {
							
							dt += merchantAvgTime;
						}
						dt += "</td></tr></table></a>";
						var $ta = $(dt);
						$ta.data("merchantId", merchantId);
						$("#show_float_dishes").append($ta);

					}

				}
			},
		error : function() {
			alert("加载内容失败");
		}

	}); 
	
	};


//吃啥
function randomDishes(){
	$("#show_random_details_cov").hide();
	$("#show_random_details").html("");
	var randomNum = Math.floor(Math.random() * 10);
	$.ajax({
		url : schema_url + "/showrandomdetails.do",
		type : "post",
		data : {
			"randomNum" : randomNum
		},
		dataType : "json",
		success : function(result) {
			if (result.status == 0) {

				var dishes = result.data;
				var st = "<table class='random_show_dishes'> <tr><td rowspan='2' class='width30'>";
				st += "<img id='randomdishes' alt='pictureofrandomdishes' src='";
				st += dishes.dishes_imgurl;
				st += "' />";
				st += "</td>";
				st += "<td class='width40'>名称：";
				st += dishes.dishes_name;
				st += "</td>";
				st += "<td>销量：";
				st += dishes.dishes_sales;
				st += "</td>";
				st += "</tr><tr><td>单价：";
				st += dishes.dishes_price;
				st += "</td><td><a href='#'>";
				st += "<img class='dishes_click_btn' alt='' src='images/buy_cn.gif' /></a> <a href='#'>"
				st += "<img class='dishes_click_btn' alt='' src='images/detail_cn.gif' /></a></td></tr></table>";
				var $tabl = $(st);
				$tabl.data("dishesId",dishes.dishes_id);
				$("#show_random_details").append($tabl);
			}
		},
		error : function() {
			alert("获取失败");
		}
	});

};


