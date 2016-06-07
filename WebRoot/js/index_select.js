function select_btn(){
	//按默认（数据库顺序）显示
	$("#btn1").click(function(){
		$(".index_dishes_orderbutton input").removeClass("show_type_checked");
		$(this).addClass("show_type_checked");
		var typeId = $(".type_checked").attr("id");
		console.log('btn1');
		console.log(typeId);
		$.ajax({
			url : schema_url + "/loaddishesbyselectbtn1.do",
			type : "post",
			data : {"typeId":typeId},
			dataType : "json",
			success : function(result) {
				if (result.status == 0) {
					$("#show_float_dishes").empty();
					var dishes = result.data;
						update_merchants(dishes);
				}
			},
			error : function() {
				alert("加载内容失败");
			}

		});
	});
	
	//按销售量显示
	$("#btn2").click(function(){
		$(".index_dishes_orderbutton input").removeClass("show_type_checked");
		$(this).addClass("show_type_checked");
		var typeId = $(".type_checked").attr("id");
		console.log('btn2');
		$.ajax({
			url : schema_url + "/loaddishesbyselectbtn2.do",
			type : "post",
			data : {"typeId":typeId},
			dataType : "json",
			success : function(result) {
				if (result.status == 0) {
					$("#show_float_dishes").empty();
					var dishes = result.data;
						update_merchants(dishes);
				} 
			},
			error : function() {
				alert("加载内容失败");
			}

		});
	});
	
	
	//按送餐速度显示
	$("#btn3").click(function(){
		$(".index_dishes_orderbutton input").removeClass("show_type_checked");
		$(this).addClass("show_type_checked");
		var typeId = $(".type_checked").attr("id");
		console.log('btn3');
		$.ajax({
			url : schema_url + "/loaddishesbyselectbtn3.do",
			type : "post",
			data : {"typeId":typeId},
			dataType : "json",
			success : function(result) {
				if (result.status == 0) {
					$("#show_float_dishes").empty();
					var dishes = result.data;
						update_merchants(dishes);
				} 
			},
			error : function() {
				alert("加载内容失败");
			}

		});
	});
	
	
	//按评分排序
	$("#btn4").click(function(){
		$(".index_dishes_orderbutton input").removeClass("show_type_checked");
		$(this).addClass("show_type_checked");
		var typeId = $(".type_checked").attr("id");
		console.log('btn4');
		$.ajax({
			url : schema_url + "/loaddishesbyselectbtn4.do",
			type : "post",
			data : {"typeId":typeId},
			dataType : "json",
			success : function(result) {
				if (result.status == 0) {
					$("#show_float_dishes").empty();
					var dishes = result.data;
						update_merchants(dishes);
				} 
			},
			error : function() {
				alert("加载内容失败");
			}

		});
	});



//购物车
$("#btn5").click(function(){
	console.log('btn5');
	window.location.href="shopcart.html";
});
};


//更改显示
function update_merchants(dishes){

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

};