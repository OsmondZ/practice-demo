$(function(){
	var id = 0;
	$.ajax({
		type : "GET",
		url : "/store/manager/ManagerController?op=findBooks",
		success : function(msg) {
			var json = eval('(' + msg + ')');
			console.log(json);
			for (var i = 0; i < json.length; i++) {
				var b = json[i];
			
				var trobj = $("#bookTable").append("<tr id='"+b.book.id+"'></tr>");
				$("#"+b.book.id).append("<td>"+b.book.id+"</td>");
				$("#"+b.book.id).append("<td>"+b.book.bookName+"</td>");
				$("#"+b.book.id).append("<td>"+b.book.sellPoint+"</td>");
				$("#"+b.book.id).append("<td>"+b.book.price+"</td>");
				console.log(b.book.pic);
				$("#"+b.book.id).append("<td><img src='"+b.book.pic+"' width='60px' height='80px'/></td>");
				$("#"+b.book.id).append("<td>"+b.book.des+"</td>");
				$("#"+b.book.id).append("<td>"+b.categoryName+"</td>");
				//<button type="button" id="${category.id }"
				//class="btn btn-danger btn-sm deleteCategory">删除</button>
				$("#"+b.book.id).append("<td><button type='button' id='"+b.book.id+"' class='btn btn-danger btn-sm deleteBook'>删除</button> <button type='button' id='"+b.book.id+"' class='btn btn-primary btn-sm updateBook'>修改</button></td>");
				
			}
		}
	});
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


})