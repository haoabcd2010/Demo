$(function() {
			$("#validatecode")[0].focus;
			$("#verifyForm").submit(function() {
						$("#register1_validatenull").html("");
						if (!requiredString($("#validatecode").val(), true)) {
							$("#register1_validatenull").html("激活码不能为空");
							return false;
						}
						return true;
					});
		});