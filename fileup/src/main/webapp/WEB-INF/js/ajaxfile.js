/**
 * 处理首页的js
 */
$(function(){
	$("#ajaxfilesubmit").click(function(){ajaxfile()});
});

/*使用ajxa 提交文件*/
function ajaxfile(){
	var maxSize = 1024*1024*5;//文件上传大小限制 5M  1024*1024*5
	
	var formData = new FormData();
	
	formData.append('ajaxfile', $('#ajaxfile')[0].files[0]);
	var filesize=$('#ajaxfile')[0].files[0].size;//单位 b 字节
	if(filesize>maxSize) {
		alert("文件太大"+" filesize="+filesize+" maxSize="+maxSize);
	}else{	
		ajaxup(formData);//调用ajax方法上传
	}
	
	
};

function ajaxup( date){
	$.ajax({
		url : "ajaxfile",// 请求地址
		//timeout : 600000,//超时时间设置，单位毫秒
		contentType: false, // 注意这里应设为false
		processData: false,
		async : true,// 异步
		cache : false,// 缓存
		type : 'post',// 请求方式			
		data:date,						
		dataType : 'json',// 服务器返回的数据类型
		success : function(data) {// 请求成功后调用的
			alert(data.result+"~"+data.msg);
		},
		
		error :function(){
			alert("异常");
		}
	});
	
}