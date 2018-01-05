jQuery.fn.extend({
	//js custom plugin 
	imgtips:function(option){
		var x = 10;
		var y = 20;
		var tooltip = "<div id='tooltip'><img height='200px' width='150px' src='' alt='preview'/><\/div>"; 
		$("body").append(tooltip);
		
		$("#tooltip").css({
			 "position":"absolute",
			 "display":"none"
		});
		
		$.each(this,function(i,item){
			$(item).mouseover(function(e){
				$("#tooltip").find("img").attr("src",$(this).attr("src"))
				
				$("#tooltip").css({
					 "top": (e.pageY+y) + "px",
					 "left":  (e.pageX+x)  + "px"
				}).show("fast");
	    	}).mouseout(function(){	
				$("#tooltip").hide();	 //ÒÆ³ý 
	    	}).mousemove(function(e){
				$("#tooltip")
					.css({
						"top": (e.pageY+y) + "px",
						"left":  (e.pageX+x)  + "px"
				});
			});
		});
	}
});