function get(e) {
	return document.getElementById(e);
}
$(function(){
	$('#sig_in').click(function() {
		get('dl').className = 'log log_out';
		get('zc').className = 'sig sig_in';
	});
	$('#back').click(function() {
		get('zc').className = 'sig sig_out';
		get('dl').className = 'log log_in';
	});
	
});


$(function() {
	var t = setTimeout("get('zc').style.visibility='visible'", 800);

	$("#count").blur(function() {
		var uname = $("#count").val().trim();
		if (uname == "") {
			$("#count_span").html("用户名不能为空");
			$("#count_warning").show();
		}
	});
	
	$("#password").blur(function() {
		var upass = $("#password").val().trim().trim();
		if (upass == "") {
			$("#password_span").html("密码不能为空");
			$("#password_warning").show();
		}
	});
	
	$("#captcha").blur(function() {
		var ucapt = $("#captcha").val().trim().trim();
		if (ucapt == "") {
			$("#captcha_span").html("验证码不能为空");
			$("#captcha_warning").show();
		}
	});
	
	

	$("#regist_username").blur(function() {
		var userName = $("#regist_username").val().trim();
		if (userName == "") {
			$("#warning_1 span").html("用户名不能为空");
			$("#warning_1").show();
		}else{
			$.ajax( {
				url : schema_url + "/checkregistusername.do",
				type : "post",
				data : {
					"userName" : userName
				},
				dataType : "json",
				success : function(result) {
					if (result.status == 1) {
						$("#warning_1 span").html("用户名已占用");
						$("#warning_1").show();
					}
				},
				error : function() {
					alert("注册失败");
				}
			});
		}

	});

	
	$("#regist_address").blur(function() {
		var uaddr = $("#regist_address").val().trim();
		if (uaddr == "") {
			$("#warning_4 span").html("地址不能为空");
			$("#warning_4").show();
		}
	});
	
	$("#regist_phonenum").blur(function() {
		var uphon = $("#regist_phonenum").val().trim();
		var myreg = /^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/; 
		if(!myreg.test(uphon)) { 
			$("#warning_5 span").html('请输入有效号码'); 
			$("#warning_5").show();
		    return; 
		} 
		if (uphon == "") {
			$("#warning_5 span").html("手机号不能为空");
			$("#warning_5").show();
		}else{
			$.ajax( {
				url : schema_url + "/checkregistuserphone.do",
				type : "post",
				data : {
					"uphon" : uphon
				},
				dataType : "json",
				success : function(result) {
					if (result.status == 1) {
						$("#warning_5 span").html("手机号已注册");
						$("#warning_5").show();
					}
				},
				error : function() {
					alert("注册失败");
				}
			});
		}
	});
	
	$("#regist_password").blur(function() {
		var npassword = $("#regist_password").val().trim();
		if (npassword == "") {
			$("#warning_2 span").html("密码不能为空");
			$("#warning_2").show();
		} else if (npassword.length < 6) {
			$("#warning_2 span").html("密码过短");
			$("#warning_2").show();
		}
	});

	$("#final_password").blur(function() {
		var fpassword = $("#final_password").val().trim();
		var npassword = $("#regist_password").val().trim();
		if (fpassword != npassword) {
			$("#warning_3 span").html("密码不一致");
			$("#warning_3").show();
		}
	});

	/*	get('regist_username').onfocus = function() {
	 get('warning_1').style.display = 'none';
	 }*/
	$("#regist_username").focus(function() {
		$("#warning_1").hide();
	});

	$("#regist_password").focus(function() {
		$("#warning_2").hide();
	});

	$("#final_password").focus(function() {
		$("#warning_3").hide();
	});
	
	$("#regist_address").focus(function() {
		$("#warning_4").hide();
	});
	
	$("#regist_phonenum").focus(function() {
		$("#warning_5").hide();
	});
	
	$("#count").focus(function() {
		$("#count_warning").hide();
	});
	
	$("#password").focus(function() {
		$("#password_warning").hide();
	});
	
	$("#captcha").focus(function() {
		$("#captcha_warning").hide();
	});
});








