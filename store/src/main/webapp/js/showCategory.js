$(function(){
	var id = 0;
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
	//删除按钮点击事件
	$(".deleteCategory").click(function(){
		//获取id属性的值
		id = $(this).attr("id");
		var text = $(this).parent().siblings(".cName").text();
		
		$("#myModalDelete").modal();
		$(".modal-body").text("是否要删除:  "+text);
	})
	//form表单提交事件
	$("#confirmDelete").click(function(){
		$.ajax({
			type: "GET",
			url: "/store/manager/ManagerController?op=deleteCategory",
			data: "categoryId="+id,
			success: function(msg){
				//想要展示页面  页面需要数据 就必须来到 controller请求数据
				window.location.href = "/store/manager/ManagerController?op=showCategoryAll";
			}
		});
	})
	//修改按钮点击事件
	$(".updateCategory").click(function(){
		
		id = $(this).attr("id");
		$.ajax({
			type: "GET",
			url: "/store/manager/ManagerController?op=showUpdateCategory",
			data: "id="+id,
			success: function(msg){
				var json = eval('(' + msg + ')');
				$("#id").val(json.id);
				$("#categoryName").val(json.categoryName);
				$("#des").text(json.des);
				$("#myModalUpdate").modal();
			}
		});
	})
	//监听修改的form表单提交事件
	$(".updateCategoryButton").click(function(){
		var id = $("#id").val();
		var categoryName = $("#categoryName").val();
		var des = $("#des").val();
		$.ajax({
			type: "POST",
			url: "/store/manager/ManagerController?op=updateCategory",
			data: "categoryName="+categoryName+"&des="+des+"&id="+id,
			success: function(msg){
				window.location.href = "/store/manager/ManagerController?op=showCategoryAll";
			}
		});
		return false;
	})
	
})