$(function(){
	//显示登陆框,隐藏注册框
	$('#switch_qlogin').click(function(){
		$('#switch_login').removeClass("switch_btn_focus").addClass('switch_btn');
		$('#switch_qlogin').removeClass("switch_btn").addClass('switch_btn_focus');
		$('#switch_bottom').animate({left:'0px',width:'70px'});
		$('#qlogin').css('display','none');
		$('#web_qr_login').css('display','block');
		});
	//显示注册框,隐藏登陆框
	$('#switch_login').click(function(){
		$('#switch_login').removeClass("switch_btn").addClass('switch_btn_focus');
		$('#switch_qlogin').removeClass("switch_btn_focus").addClass('switch_btn');
		$('#switch_bottom').animate({left:'154px',width:'70px'});
		$('#qlogin').css('display','block');
		$('#web_qr_login').css('display','none');
		});

//	var reMethod = "GET";
	var pwdmin = 3;
	//登陆按扭
	$('#login_button').click(function(){
		if ($('#username').val() == "") {
			$('#username').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			alert("用户名不能为空");
			//$('#usernameCue').html("<font color='red'><b>×用户名不能为空</b></font>");
			return false;
		}
//		if ($('#username').val().length < 4 || $('#username').val().length > 16) {
//			$('#username').focus().css({
//				border: "1px solid red",
//				boxShadow: "0 0 2px red"
//			});
//			alert("用户名位4-16字符");
//			//$('#usernameCue').html("<font color='red'><b>×用户名位4-16字符</b></font>");
//			return false;
//		}
		if ($('#password').val() == "") {
			$('#password').focus();
			alert("密码不能为空");
			//$('#usernameCue').html("<font color='red'><b>×用户名不能为空</b></font>");
			return false;
		}
		//提交[删除账户]表单
		$.post("LoginServlet", $("#login_form").serialize(), function(data, status) {
			if (status == "success") {
				alert(data);
				if(data=="登陆成功!"){
					window.location.href="mainticket.html";
				}
			} else {
				alert("失败! status=" + status);
			}
//			callback();
		});
//		$('#login_form').submit();
	});
	//注册按扭
	$('#reg').click(function() {
		if ($('#user').val() == "") {
			$('#user').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue').html("<font color='red'><b>×用户名不能为空</b></font>");
			return false;
		}
//		if ($('#user').val().length < 4 || $('#user').val().length > 16) {
//
//			$('#user').focus().css({
//				border: "1px solid red",
//				boxShadow: "0 0 2px red"
//			});
//			$('#userCue').html("<font color='red'><b>×用户名位4-16字符</b></font>");
//			return false;
//		}
		if ($('#passwd').val().length < pwdmin) {
			$('#passwd').focus();
			$('#userCue').html("<font color='red'><b>×密码不能小于" + pwdmin + "位</b></font>");
			return false;
		}
		if ($('#passwd2').val() != $('#passwd').val()) {
			$('#passwd2').focus();
			$('#userCue').html("<font color='red'><b>×两次密码不一致！</b></font>");
			return false;
		}
		var sid = /^[0-9]{4,20}$/;
		if (!sid.test($('#idcard').val()) || $('#idcard').val().length < 4 || $('#idcard').val().length > 20) {
			$('#idcard').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue').html("<font color='red'><b>×身份证号格式不正确</b></font>");
			return false;
		} else {
			$('#idcard').css({
				border: "1px solid #D7D7D7",
				boxShadow: "none"
			});
		}
		if ($('#realname').val() == "") {
			$('#realname').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue').html("<font color='red'><b>×真实姓名不能为空</b></font>");
			return false;
		}
		$('#reg').css("cursor","wait");
		$("#reg").attr('disabled',true); 
		$.post("RegisterServlet", $("#regUser").serialize(), function(data, status) {
			if (status == "success") {
				$('#userCue').html("<font color='red'><b>"+data+"</b></font>");
			} else {
				alert("失败!status=" + status);
			}
		});
		$('#reg').css("cursor","pointer");
		$("#reg").attr('disabled',false);
//		$('#regUser').submit();
	});
});


//根据参数名获得该参数 pname等于想要的参数名 
function getParam(pname) { 
    var params = location.search.substr(1); // 获取参数 平且去掉？ 
    var ArrParam = params.split('&'); 
    if (ArrParam.length == 1) { 
        //只有一个参数的情况 
        return params.split('=')[1]; 
    } 
    else { 
         //多个参数参数的情况 
        for (var i = 0; i < ArrParam.length; i++) { 
            if (ArrParam[i].split('=')[0] == pname) { 
                return ArrParam[i].split('=')[1]; 
            } 
        } 
    } 
}