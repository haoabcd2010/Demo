var f=[false,false,false,false,false];
			//获取地址信息的Json数据
			
			//页面装载事件
			$(function(){
				$("#receiveName")[0].focus();
				var jsonAdd=getJsonAddress();
				//地址讯选择事件
				$("#address").change(function(){
					$("#receiveName")[0].focus();
					if($(this).val()==-1) {
						$("#addressId").val(null);
						$("#receiveName").val("");
						$("#fullAddress").val("");
						$("#postalCode").val("");
						$("#mobile").val("");
						$("#phone").val("");
						$("#fullAddress").attr("readonly",false);
						$("#fullAddress").css("background","#FFFFFF");
					}
					else {
						$("#addressId").val($(this).val()+"");
						$("#receiveName").val(eval("jsonAdd.id"+$(this).val()+".receiveName"));
						$("#fullAddress").val(eval("jsonAdd.id"+$(this).val()+".fullAddress"));
						$("#postalCode").val(eval("jsonAdd.id"+$(this).val()+".postalCode"));
						$("#mobile").val(eval("jsonAdd.id"+$(this).val()+".mobile"));
						$("#phone").val(eval("jsonAdd.id"+$(this).val()+".phone"));
						$("#fullAddress").attr("readonly",true);
						$("#fullAddress").css("background","#EEEEEE");
					}
				});
				//表单验证的问题
				$("#receiveName").blur(function(){
					f[0]=validateName($(this),$("#errName"));
				});
				$("#fullAddress").blur(function(){
					f[1]=validateFullAddress($(this),$("#errAddress"));
				});
				$("#postalCode").blur(function(){
					f[2]=validatePostalCode($(this),$("#errPost"));
				});
				$("#phone").blur(function(){
					f[3]=validatephone($(this),$("#mobile"),$("#errPhone"));
				});
				$("#mobile").blur(function(){
					f[4]=validateMobile($("#phone"),$(this),$("#errPhone"),$("#errMobile"));
				});
				//表单提交事件
				$("#f").submit(function(){
					if(f[0]==false) {
						f[0]=validateName($("#receiveName"),$("#errName"));
					}
					if(f[1]==false) {
						f[1]=validateFullAddress($("#fullAddress"),$("#errAddress"));
					}
					if(f[2]==false) {
						f[2]=validatePostalCode($("#postalCode"),$("#errPost"));
					}
					if(f[3]==false) {
						f[3]=validatephone($("#phone"),$("#mobile"),$("#errPhone"));
					}
					if(f[4]==false) {
						f[4]=validateMobile($("#phone"),$("#mobile"),$("#errPhone"),$("#errMobile"));
					}
					return f[0]&&f[1]&&f[2]&&f[3]&&f[4];
				});
			});
			//姓名验证
			function validateName(field,span) {
				span.text("");
				if(!requiredString(field.val(),true)) {
					span.html("<img src='../images/wrong.gif'  width='12' height='12' align='top'/>&nbsp;姓名不能为空");
					return false;
				}
				if(0!=stringLength(field.val(),MIN_NAME_LENGTH,MAX_NAME_LENGTH)) {
					span.html("<img src='../images/wrong.gif'  width='12' height='12' align='top'/>&nbsp;姓名长度错误，应该在"+MIN_NAME_LENGTH+"-"+MAX_NAME_LENGTH+"之间");
					return false;
				}
				span.html("<span style='color:#666666'><img src='../images/right.gif'  width='12' height='12' align='top'/>&nbsp;正确</span>");
				return true;
			}
			//验证地址
			function validateFullAddress(field,span) {
				span.text("");
				if(!requiredString(field.val(),true)) {
					span.html("<img src='../images/wrong.gif'  width='12' height='12' align='top'/>&nbsp;地址不能为空！");
					return false;
				}
				if(0!=stringLength(field.val(),MIN_ADDRESS_LENGTH,MAX_ADDRESS_LENGTH)) {
					span.html("<img src='../images/wrong.gif'  width='12' height='12' align='top'/>&nbsp;地址长度错误，应该在"+MIN_ADDRESS_LENGTH+"-"+MAX_ADDRESS_LENGTH+"之间");
					return false;
				}
				span.html("<span style='color:#666666'><img src='../images/right.gif'  width='12' height='12' align='top'/>&nbsp;正确</span>");
				return true;
			}
			//验证邮编
			function validatePostalCode(field,span) {
				if(!requiredString(field.val(),true)) {
					span.html("<img src='../images/wrong.gif'  width='12' height='12' align='top'/>&nbsp;邮政编码不能为空！");
					return false;
				}
				if(!postalCode(field.val())) {
					span.html("<img src='../images/wrong.gif'  width='12' height='12' align='top'/>&nbsp;邮政编码格式错误！");
					return false;
				}
				span.html("<span style='color:#666666'><img src='../images/right.gif'  width='12' height='12' align='top'/>&nbsp;正确</span>");
				return true;
			}
			//验证电话
			function validatephone(field,field1,span) {
				span.html("");
				if(!requiredString(field.val(),true)) {
					if(!requiredString(field1.val(),true)){
						span.html("<img src='../images/wrong.gif'  width='12' height='12' align='top'/>&nbsp;电话和手机必须填写其中之一");
						return false;
					}
				}else{
					if(!phone(field.val())) {
						span.html("<img src='../images/wrong.gif'  width='12' height='12' align='top'/>&nbsp;电话号码格式错误");
						return false;
					}else{
						span.html("<span style='color:#666666'><img src='../images/right.gif'  width='12' height='12' align='top'/>&nbsp;正确</span>");
						return true;
					}
				}
			}
			//验证移动手机
			function validateMobile(field,field1,span,span1) {
				span1.html("");
				if(!requiredString(field1.val(),true)) {
					if(!requiredString(field.val(),true)){
						//phonespan
						span1.html("<img src='../images/wrong.gif'  width='12' height='12' align='top'/>&nbsp;电话和手机必须填写其中之一");
						return false;
					}
				}else{
					if(!mobile(field1.val())) {
						span1.html("<img src='../images/wrong.gif'  width='12' height='12' align='top'/>&nbsp;手机格式错误");
						return false;
					}else{
						span1.html("<span style='color:#666666'><img src='../images/right.gif'  width='12' height='12' align='top'/>&nbsp;正确</span>");
						return validatephone(field,field1,span);
					}
				}
			}