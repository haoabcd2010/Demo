		
		var f=[false,false,false,false,false];
		var ajaxf=[-1,-1];
		$(function(){
			$("#email")[0].focus();
			$("#f").submit(function(){
				if(f[0]==false) {
					f[0]=validateEmail($("#emailInfo"),$("#email"));
				}
				if(f[1]==false) {
					f[1]=validateNickname($("#nameInfo"),$("#txtNickName"));
				}
				if(f[2]==false) {
					f[2]=validatePassword($("#passwordInfo"),$("#txtPassword"),$("#txtRepeatPass"));
				}
				if(f[3]==false) {
					f[3]=validateRepeatPassword($("#password1Info"),$("#txtPassword"),$("#txtRepeatPass"));
				}
				if(f[4]==false) {
					f[4]=validateCode($("#numberInfo"),$("#validateCode"));
				}
				if(ajaxf[0]==99) {
					alert("正在进行电子邮件可用性的检测，请稍后提交！");
					return false;
				}
				if(ajaxf[1]==99) {
					alert("正在进行验证码正确性的检测，清稍后提交！");
					return false;
				}
				if(ajaxf[0]!=true) ajaxf[0]=false;
				if(ajaxf[1]!=true) ajaxf[1]=false;
				return f[0]&&f[1]&&f[2]&&f[3]&&f[4]&&ajaxf[0]&&ajaxf[1];
			});
			//验证Email Form
			function validateEmail(errorSpan,field) {
				if(!requiredString(field.val(),true)) {
					errorSpan.html("<img src='../images/wrong.gif'  width='12' height='12' align='top'/>&nbsp;电子邮件不能为空");
					f[0]=false;
					return false;
				}
				if(!email(field.val())) {
					errorSpan.html("<img src='../images/wrong.gif'  width='12' height='12' align='top'/>&nbsp;电子邮件地址格式错误");
					f[0]=false;
					return false;
				}
				f[0]=true;
			}
			//服务器端验证Email的可用性
			function validateEmailServer(errorSpan,field) {
				ajaxf[0]=99;
				errorSpan.html("<img src='../images/load.gif' width='12' height='12' align='top'/><span style='color:#666666'>正在检测邮件可用性</span>");
				$.ajax({
						url:"verifyEmail.action",
						type:"get",
						data:{ email: field.val(),time:(new Date()).getTime()},
						dataType:"json",
						async:true,
						success: function(json){
					  			ajaxf[0]=json.ok;
					  			if(ajaxf[0]) {
					  				errorSpan.html("<span style='color:#666666'><img src='../images/right.gif'  width='12' height='12' align='top'/>&nbsp;电子邮件地址可用</span>");
					  			}
					  			else {
					  				errorSpan.html("<img src='../images/wrong.gif'  width='12' height='12' align='top'/>&nbsp;抱歉，邮件地址已经被使用");
					  			}
					  	}	  	
				});
			}
			//validate昵称
			function validateNickname(errorSpan,field) {
				errorSpan.text("");
				if(!requiredString(field.val(),true)) {
					errorSpan.html("<img src='../images/wrong.gif'  width='12' height='12' align='top'/>&nbsp;昵称不能为空");
					f[1]=false;
					return false;
				}
				if(0!=stringLength(field.val(),MIN_NICK_NAME_LENGTH,MAX_NICK_NAME_LENGTH)) {
					errorSpan.html("<img src='../images/wrong.gif'  width='12' height='12' align='top'/>&nbsp;昵称的长度不符合要求");
					f[1]=false;
					return false;
				}
				else {
					errorSpan.html("<span style='color:#666666'><img src='../images/right.gif'  width='12' height='12' align='top'/>&nbsp;正确<span>");
					f[1]=true;
					return true;
				}
			}
			//validate密码
			function validatePassword(errorSpan,field,field1) {
				errorSpan.text("");
				if(!requiredString(field.val(),true)) {
					errorSpan.html("<img src='../images/wrong.gif'  width='12' height='12' align='top'/>&nbsp;密码不能为空");
					f[2]=false;
					return false;
				}
				if(0!=stringLength(field.val(),MIN_PASSWORD_LENGTH,MAX_PASSWORD_LENGTH)) {
					errorSpan.html("<img src='../images/wrong.gif'  width='12' height='12' align='top'/>&nbsp;密码的长度不符合要求");
					f[2]=false;
					return false;
				}
				if(requiredString(field1.val(),true)) {
					if(requiredString(field1.val(),true) && !stringEquals(field.val(),field1.val(),true,false)) {
						$("#password1Info").html("<img src='../images/wrong.gif'  width='12' height='12' align='top'/>&nbsp;两次输入的密码不同");
					}
					else {
						$("#password1Info").html("<span style='color:#666666'><img src='../images/right.gif'  width='12' height='12' align='top'/>&nbsp;正确</span>");
						f[3]=true;
					}
				}
				errorSpan.html("<span style='color:#666666'><img src='../images/right.gif'  width='12' height='12' align='top'/>&nbsp;正确</span>");
				f[2]=true;
				return true;
			}
			//validate密码确认
			function validateRepeatPassword(errorSpan,field1,field2) {
				errorSpan.text("");
				if(!requiredString(field2.val(),true)) {
					errorSpan.html("<img src='../images/wrong.gif'  width='12' height='12' align='top'/>&nbsp;确认密码不能为空");
					f[3]=false;
					return false;
				}
				if(!stringEquals(field1.val(),field2.val(),true,true)) {
					errorSpan.html("<img src='../images/wrong.gif'  width='12' height='12' align='top'/>&nbsp;两次输入的密码不同");
					f[3]=false;
					return false;
				}
				else {
					errorSpan.html("<span style='color:#666666'><img src='../images/right.gif'  width='12' height='12' align='top'/>&nbsp;正确</span>");
					f[3]=true;
					return true;
				}
			}
			//validate verfiy code
			function validateCode(errorSpan,field) {
				if(!requiredString(field.val(),true)) {
					errorSpan.html("<img src='../images/wrong.gif'  width='12' height='12' align='top'/>&nbsp;验证码不能为空");
					f[4]=false;
					return false;
				}
				f[4]=true;
				return true;
			}
			//validate ajax verify code
			function validateCodeServer(errorSpan,field) {
				ajaxf[1]=99;
				errorSpan.html("<img src='../images/load.gif' width='12' height='12' align='top'/><span style='color:#666666'>正在检测验证码</span>");
				//Ajax
				$.ajax({
						url:"verifyCode.action",
						data:{ validateCode: field.val(),time:(new Date()).getTime()},
						dataType:"json",
						type:"post",
						async:true,
						success:function(json){
					  			ajaxf[1]=json.ok;
					  			if(!ajaxf[1]) {
					  				errorSpan.html("<img src='../images/wrong.gif'  width='12' height='12' align='top'/>&nbsp;验证码输入错误");
					  			}
					  			else {
					  				errorSpan.html("<span style='color:#666666'><img src='../images/right.gif'  width='12' height='12' align='top'/>&nbsp;正确</span>");
					  			}
					  	}
				});
			}
			//email blur验证
			$("#email").blur(function(){
				validateEmail($("#emailInfo"),$(this));
				if(f[0]==true) {
					validateEmailServer($("#emailInfo"),$(this));
				}
			});
			//nick name blur 验证
			$("#txtNickName").blur(function(){
				validateNickname($("#nameInfo"),$(this));
			});
			//password blur
			$("#txtPassword").blur(function() {
				validatePassword($("#passwordInfo"),$(this),$("#txtRepeatPass"));
			});
			//repeat password blur
			$("#txtRepeatPass").blur(function(){
				validateRepeatPassword($("#password1Info"),$("#txtPassword"),$(this));
			});
			//validateCode blur
			$("#validateCode").blur(function(){
				validateCode($("#numberInfo"),$(this));
				if(f[4]==true)  {
					validateCodeServer($("#numberInfo"),$(this));
				}
			});
			
		});