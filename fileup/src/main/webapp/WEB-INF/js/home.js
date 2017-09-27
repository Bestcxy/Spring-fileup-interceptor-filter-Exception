/**
 * 处理首页的js
 */
$(function(){
	$(".checkUserName").blur(function(){checkUserName(this)});
});

/*使用ajxa 方法后台访问该用户名是否已经注册*/
function checkUserName(theid){
	//data="&"+id+"="+value是ajax的本质模式,这里id是一个变量,比如 id="userName",等同于 data={userName:value}={'userName':value},二者 的区别是{}中的key不能为变量
	//var data="&"+id+"="+value;
	var data=gainJson(theid);

	$.ajax({
		url : "ajaxCheckUserName",// 请求地址
		timeout : 600000,//超时时间设置，单位毫秒
		async : true,// 异步
		cache : false,// 缓存
		type : 'post',// 请求方式
		/*data: $('#formid').serialize(),//序列化表单*/			
		data:data,						
		dataType : 'json',// 服务器返回的数据类型
		contentType:"application/x-www-form-urlencoded; charset=utf-8",
		success : function(data) {// 请求成功后调用的
			$(".col_msgspan").text(data.result+"~ "+data.msg);
		},
		
		error :function(){
			alert("异常");
		}
	});
};

//获取id和值的公共方法，返回json格式
function gainJson(theid){
	var id=$(theid).attr("id");
	var value=$("#"+id+"").val();
	var str="&"+id+"="+value;
	return str;
}