$(function(){
	$("#btn-s").click(function(){
	
		var code = $("#code").val();
		var pswd = $("#pswd").val();
		
		if(code =="")
		{
			$("#tips").html("<font color='red'>用户名不能为空！</font>");
			return false;
		}
		
		if(pswd =="")
		{
			$("#tips").html("<font color='red'>密码不能为空！</font>");
			return false;
		}
			
		$("#tips").html("");
		
		var cfg = {
				url: 'http://localhost:8080/p/signin0.ajax',
				type: 'POST', 
				dataType: "json",
				data:{code:code,password:pswd},
				//contentType: "application/json; charset=utf-8",
				error:function(XMLHttpRequest, textStatus, errorThrown) {
					alert("req.status:"+XMLHttpRequest.status);
					//alert("req.readyState:"+XMLHttpRequest.readyState);
					//alert(textStatus);
					window.location.href="/";
				},
				success: function(d) { 
					if(d.code){
						$("#hid2").css("display","none");
						$("#p_code").html(d.code);
						$("#hid").css({ display: "block"});
					}
					else
					{
						$("#tips").html("用户名或密码错误，请重试");
					}
				} 
			};
		$.ajax(cfg);
		
	});

});


function chk(){		
	alert("before submit!");
	if($("#code").val()=="")
	{
		$("#tips").html("<font color='red'>用户名不能为空！</font>");
		return false;
	}

	if($("#password").val()=="")
	{
		$("#tips").html("<font color='red'>密码不能为空！</font>");
		return false;
	}
	$("#tips").html("");
	return true;
}

function onover(){
	$("#t_drop").show();
}
function on(){
	$("#t_drop").hide();
}

function onout(){
	setTimeout("on()",2000);
	
}