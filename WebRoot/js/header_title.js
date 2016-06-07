
//标题按钮
function head_things() {
	
	//检测用户
	var userId = getCookie("userId");
	var userName = getCookie("userName");
	console.log(userId+','+userName);
	if(userId != null){
		$.ajax({
			url : schema_url + "/checkLoadUser.do",
			type : "post",
			data : {"userId":userId},
			dataType : "json",
			success : function(result) {
				if (result.status == 0) {
					console.log(result.data)
					$("#logout_user_info").hide();
					$("#usermessage").html(result.data);
					$("#login_user_info").show();
				}
			},
			error : function(){
				alert("失败");
			}
		});
	}; 
	
	//信息菜单
	$(".login_info").mouseover(function() {
		$(".user_menu").show();
		
	});
	$(".login_info").mouseout(function() {
		$(".user_menu").hide();
	});
	$(".user_menu").mouseout(function() {
		$(".user_menu").hide();
	});
	$(".user_menu").mouseover(function() {
		$(".user_menu").show();
	});

	//退出登录
	$(".btn_logout").click(function(){
		delCookie("userId");
		delCookie("userName");
		$("#logout_user_info").show();
		$("#login_user_info").hide();
	});
	
	$("#sinput").focus(function() {
		$("#sinput").val("  ");
	});

	$("#sinput").blur(function() {
		var xxxx = $("#sinput").val().trim();
		if (xxxx == "" || xxxx == null || xxxx == "搜索店铺") {
			$("#sinput").val("     搜索店铺");
		} else {
			return;
		}

	});

	//点击搜索按钮
	$("#f-close-btn")
			.click(
					function() {

						var xxxx = $("#sinput").val().trim();
						if (xxxx == "" || xxxx == null || xxxx == "搜索店铺") {
							$("#sinput").val("     搜索信息有误");
							setTimeout("$('#sinput').val('     搜索店铺');", 1500);
						} else {
							var scanName = $("#sinput").val().trim();
							$
									.ajax({
										url : schema_url
												+ "/loaddishesbyscanname.do",
										type : "post",
										data : {
											"scanName" : scanName
										},
										dataType : "json",
										success : function(result) {
											if (result.status == 0) {
												$(".showMerchants").remove();
												$(".index_dishes_type").hide();
												var dishes = result.data;
												for (var i = 0; i < dishes.length; i++) {

													var merchantId = dishes[i].user_id;
													var merchantName = dishes[i].user_name;
													var merchantImg = dishes[i].user_picture_url;
													var merchantSales = dishes[i].merchant_sales;
													var merchantAvgTime = dishes[i].avg_time;
													var merchantScore = dishes[i].score;

													var dt = "<a href='toMerchantDishesDetail.do?id="
															+ merchantId
															+ "' class='showMerchants'><table class='inner_show_dishes'><tr><td rowspan='2' class='inner_show_dishes_td'>";
													dt += "<img	class='dishes_picture' alt='' src='";
													dt += merchantImg;
													dt += "' />";
													dt += "</td>";
													dt += "<td class='merchant_name'>";
													dt += merchantName;
													dt += "</td>";
													dt += "</tr><tr><td>销量：";
													if (merchantSales == null
															|| merchantSales == "") {
														dt += "暂无";
													} else {

														dt += merchantSales;
													}
													dt += "</td></tr><tr><td>评价：";
													dt += merchantScore;
													dt += "</td><td>平均用时：";
													if (merchantAvgTime == null
															|| merchantAvgTime == "") {
														dt += "暂无";
													} else {

														dt += merchantAvgTime;
													}
													dt += "</td></tr></table></a>";
													var $ta = $(dt);
													$ta.data("merchantId",
															merchantId);
													$("#show_float_dishes")
															.append($ta);
												}

											}
										},
										error : function() {
											alert("加载内容失败");
										}

									});
						}
					});

	// 回车搜索部分
	$("#sinput")
			.keydown(
					// 输入栏回车搜索
					function(event) {
						var code = event.keyCode;// 键值
						var keyword = $(this).val();
						if (code == 13) {// 回车键
							var scanName = $("#sinput").val().trim();
							// 发送Ajax请求
							$
									.ajax({
										url : schema_url
												+ "/loaddishesbyscanname.do",
										type : "post",
										data : {
											"scanName" : scanName
										},
										dataType : "json",
										success : function(result) {
											if (result.status == 0) {
												$(".showMerchants").remove();
												$(".index_dishes_type").hide();
												var dishes = result.data;
												for (var i = 0; i < dishes.length; i++) {

													var merchantId = dishes[i].user_id;
													var merchantName = dishes[i].user_name;
													var merchantImg = dishes[i].user_picture_url;
													var merchantSales = dishes[i].merchant_sales;
													var merchantAvgTime = dishes[i].avg_time;
													var merchantScore = dishes[i].score;

													var dt = "<a href='toMerchantDishesDetail.do?id="
															+ merchantId
															+ "' class='showMerchants'><table class='inner_show_dishes'><tr><td rowspan='2' class='inner_show_dishes_td'>";
													dt += "<img	class='dishes_picture' alt='' src='";
													dt += merchantImg;
													dt += "' />";
													dt += "</td>";
													dt += "<td class='merchant_name'>";
													dt += merchantName;
													dt += "</td>";
													dt += "</tr><tr><td>销量：";
													if (merchantSales == null
															|| merchantSales == "") {
														dt += "暂无";
													} else {

														dt += merchantSales;
													}
													dt += "</td></tr><tr><td>评价：";
													dt += merchantScore;
													dt += "</td><td>平均用时：";
													if (merchantAvgTime == null
															|| merchantAvgTime == "") {
														dt += "暂无";
													} else {

														dt += merchantAvgTime;
													}
													dt += "</td></tr></table></a>";
													var $ta = $(dt);
													$ta.data("merchantId",
															merchantId);
													$("#show_float_dishes")
															.append($ta);
												}

											}
										},
										error : function() {
											alert("加载内容失败");
										}
									});
						}
					});

};

