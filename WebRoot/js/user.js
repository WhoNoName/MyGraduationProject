function userLogin(){

	//清除原有提示信息
	$("#count_span").html("");
	$("#password_span").html("");
	$("#captcha_span").html("");
	//获取请求参数
	var name = $("#count").val().trim();
	var password = $("#password").val().trim();
	var captcha = $("#captcha").val().trim();

	//格式检查
	var check = true;
	if (name == "") {
		
		check = false;
		$("#count_span").html("用户名为空");
		$("#count_warning").show();
	}
	if (password == "") {
		check = false;
		$("#password_span").html("密码为空");
		$("#password_warning").show();
	}
	if (captcha == "") {
		check = false;
		$("#captcha_span").html("验证码为空");
		$("#captcha_warning").show();
	}
	//发送ajax
	if (check) {
		$.ajax( {
			url : schema_url + "/orderlogin.do",
			type : "post",
			data : {
				"name" : name,
				"password" : password,
				"captcha" : captcha
			},
			dataType : "json",
			success : function(result) {
				console.log(result);
				if (result.status == 0) {
					
					//获取id，写入cookie
					var userMsg = result.data;
					var userId = userMsg.user_id;
					var userName = userMsg.user_name;
					console.log(userId+','+userName);
					addCookie("userId",userId,120);
					addCookie("userName", userName,120);
					window.location.href = "toIndex.do";
				} else if (result.status == 1) {
					$("#password_span").html(result.msg);
					$("#password_warning").show();
				} else if (result.status == 2){
					$("#captcha_span").html(result.msg);
					$("#captcha_warning").show();
				}
			},
			error : function() {
				alert("登录失败");
				
			}

		});
	}
};

function userRegist() {

	var name = $("#regist_username").val().trim();
	var password = $("#regist_password").val().trim();
	var final_password = $("#final_password").val().trim();
	var uaddr = $("#regist_address").val().trim();
	var uphon = $("#regist_phonenum").val().trim();	
	
	//检查格式
	var check = true;
	if (name == "") {
		check = false;
		$("#warning_1 span").html("用户名不能为空");
		$("#warning_1").show();
	}
	
	if (uaddr == "") {
		check = false;
		$("#warning_4 span").html("地址不能为空");
		$("#warning_4").show();
	}
	
	if (uphon == "") {
		check = false;
		$("#warning_5 span").html("手机号不能为空");
		$("#warning_5").show();
	}else if(!(/^1[3|4|5|7|8]\d{9}$/.test(uphon))){
		$("#warning_5 span").html("手机号码有误，请重填");
		$("#warning_5").show();  
        return false; 
	}

	if (password == "") {
		check = false;
		$("#warning_2 span").html("密码不能为空");
		$("#warning_2").show();
	} else if (password.length < 6) {
		check = false;
		$("#warning_2 span").html("密码过短");
		$("#warning_2").show();
	}

	if (final_password == "") {
		check = false;
		$("#warning_3 span").html("密码不能为空");
		$("#warning_3").show();
	} else if (final_password != password) {
		check = false;
		$("#warning_3 span").html("密码不一致");
		$("#warning_3").show();
	}

	if (check) {
		$.ajax({
			url : schema_url + "/orderregist.do",
			type : "post",
			data : {
				"name" : name,
				"uphon" : uphon,
				"password" : password,
				"uaddr":uaddr			
			},
			dataType : "json",
			success : function(result) {
				if (result.status == 0) {
					alert(result.msg);
					$("#back").click();
				} else if (result.status == 1) {
					$("#warning_1 span").html("用户名已占用");
					$("#warning_1").show();
				}
			},
			error : function() {
				alert("注册失败");
			}
		});
	}

};

function login_functions(){
	
	//用户名栏回车处理
	$("#count").keydown(function(event) {
		var code = event.keyCode;// 键值
		var keyword = $(this).val();
		if (code == 13) {
			
			$("#login_btn").trigger("click");
		}
	});
	
	//密码栏回车处理
	$("#password").keydown(function(event) {
		var code = event.keyCode;// 键值
		var keyword = $(this).val();
		if (code == 13) {
			$("#login_btn").trigger("click");
		}
	});

	//验证码栏回车处理
	$("#captcha").keydown(function(event) {
		var code = event.keyCode;// 键值
		var keyword = $(this).val();
		if (code == 13) {
			$("#login_btn").trigger("click");
		}
	});
	
	
	
	
	
}

