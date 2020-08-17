$(function(){
	
	// 此方法为切换左边菜单的js文件
	$(".list_dt").on("click", function() {
		$('.list_dd').stop();
		$(this).siblings("dt").removeAttr("id");
		if ($(this).attr("id") == "open") {
			$(this).removeAttr("id").siblings("dd").slideToggle();
		} else {
			$(this).attr("id", "open").next().slideToggle();
		}
	});
	// 退出
	function logout() {
		window.location.href = "login.html";
	}
	$("#categoryName").blur(function(){
		var categoryName = $(this).val();
		$.ajax({
			type: "GET",
			url: "/store/manager/ManagerController?op=checkCategoryName",
			data: "categoryName="+categoryName,
			success: function(msg){
				var json = eval('(' + msg + ')');
				var spanObj = $("#tips");
				if(json.code==200){
					spanObj.css("color","#5cb85c").text(json.msg);
				}else{
					spanObj.css("color","#d9534f").text(json.msg);
				}
			}
		});
	})
	$(".addCategory").submit(function(){
		var categoryName = $("#categoryName").val();
		var des = $("#des").val();
		$.ajax({
			type: "POST",
			url: "/store/manager/ManagerController?op=addCategory",
			data: "categoryName="+categoryName+"&des="+des,
			success: function(msg){
				var json = eval('(' + msg + ')');
				$(".modalTips").text(json.msg);
				
				$('#myModal').css("margin-top","200px");
				
				$('#myModal').modal();
				
			}
		});
		return false;

	})
})