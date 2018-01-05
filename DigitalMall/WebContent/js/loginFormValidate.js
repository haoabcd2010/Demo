	$(function() {
			$("#txtUsername")[0].focus();
			$("#ctl00").submit(function(){
				return validateLogin($("#divErrorMssage"));
				
			});
		});
		
		function validateLogin(errorSpan) {
			errorSpan.text("");
			if(!requiredString($("#txtUsername").val(),true) || !requiredString($("#txtPassowrd").val())) {
				errorSpan.text("电子邮件或者密码不能为空");
				return false;
			}
			if(!email($("#txtUsername").val())) {
				errorSpan.text("电子邮件地址格式错误");
				return false;
			}
			if(0!=stringLength($("#txtPassowrd").val(),MIN_PASSWORD_LENGTH,MAX_PASSWORD_LENGTH)) {
				errorSpan.text("输入电子邮件或者密码错误，请重新输入");
				return false;
			}
			return true;
		}