<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>登录</title>

		<link type="text/css" rel="stylesheet" media="screen"
			href="css/bootstrap.min.css" />

		<style>
body {
	padding: 100px;
}

.login {
	border-radius: 4px;
	-moz-border-radius: 4px;
	-webkit-border-radius: 4px;
}

.login {
	background-color: #FF4500;
	padding: 10px;
	border: #c0c0c0 1px solid;
}

.xxx {
	text-align: center;
}


</style>

	</head>
	<body>

		<div class="container login" style="width: 500px !important;">

			<div class="rom">
				<div class=" login-box">
					<h3 class="xxx">
						用户登陆
					</h3>
					<form class="form-horizontal" role="form" method="post" action="#">
						<div class="form-group">
							<label for="login-name" class="col-xs-4 control-label">
								登陆名称:
							</label>
							<div class="col-xs-6">
								<input type="text" name="login-name" class="form-control"
									id="login-name" placeholder="手机号或者电子邮件" />
							</div>
						</div>
						<div class="form-group">
							<label for="login-pass" class="col-xs-4 control-label">
								登陆密码:
							</label>
							<div class="col-xs-6">
								<input type="password" name="login-pass" class="form-control"
									id="login-pass" placeholder="登陆密码" />
							</div>
						</div>
						<div class="form-group">
							<label for="login-verify" class="col-xs-4 control-label">
								验证码:
							</label>

							<div class="col-xs-3">
								<input type="text" name="login-verify" class="form-control"
									id="login-verify" placeholder="输入验证码" />

							</div>
							<div class="col-xs-3">
								<img src="createImg.do" class="form-control-static" alt="验证码"
									title="点击更换"
									" onclick="this.src='createImg.do?x='+Math.random;" >
								<span>
									<label class="control-label helplable"
										for="login-verify">
										点击图片刷新
									</label>
								</span>
								</img>
							</div>
						</div>
						<div class="form-group">
							<div class="col-xs-offset-3 col-xs-4">
								<button type="submit" class="btn btn-primary btn-block">
									登 陆
								</button>
							</div>
						</div>
					</form>
					<div class="col-xs-4 login-help">
						还没有注册过？
						<a href="http://sc.chinaz.com/jiaoben/">点此注册</a>

					</div>
					<span> <label class="control-label helplable"
							for="login-pass">
							忘记密码
							<a href="#">点此找回</a>
						</label> </span>
				</div>

			</div>

		</div>
	</body>
</html>