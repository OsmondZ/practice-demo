$(function() {
	$.ajax({
		type : "GET",
		url : "/store/manager/ManagerController?op=findCategories",
		success : function(msg) {
			var json = eval('(' + msg + ')');
			for (var i = 0; i < json.length; i++) {
				var category = json[i];
				$("#categoryId").append(
						"<option value=" + category.id + ">"
								+ category.categoryName + "</option>");
			}
		}
	});

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
})