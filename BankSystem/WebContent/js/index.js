$(document).ready(function(){
	//添加账户
	function addAccount(callback){
		var idcard=$("#addAccount_form input[name='idcard']").val();
		var password=$("#addAccount_form input[name='password']").val();
		var name=$("#addAccount_form input[name='name']").val();
		var balance=$("#addAccount_form input[name='balance']").val();
		if(idcard==""){
			alert("身份证号不能为空!");
			callback();return;
		}
		var sid = /^[0-9]{4,20}$/;
		if (!sid.test(idcard) || idcard.length < 4 || idcard.length > 20) {
			alert("身份证号格式不正确!");
			callback();return;
		}
		if(name==""){
			alert("姓名不能为空!");
			callback();return;
		}
		if(balance==""){
			alert("余额不能为空!");
			callback();return;
		}
		if(isNaN(balance)){
			alert("输入的余额不是一个数字!");
			callback();return;
		}
		//提交[添加账户]表单
		$.post("AccountServlet", $("#addAccount_form").serialize(), function(data, status) {
			if (status == "success") {
				alert(data);
			} else {
				alert("失败! status=" + status);
			}
			callback();
		});
	}
	$("#addAccount_button").click(function(){
		$('#addAccount_button').css("cursor","wait");
		$("#addAccount_button").attr('disabled',true);
		addAccount(function(){
			$('#addAccount_button').css("cursor","pointer");
			$("#addAccount_button").attr('disabled',false);
		});
	});
	//删除账户
	function deleteAccount(callback){
		var idcard=$("#deleteAccount_form input[name='idcard']").val();
		if(idcard==""){
			alert("身份证号不能为空!");
			callback();return;
		}
		//提交[删除账户]表单
		$.post("AccountServlet", $("#deleteAccount_form").serialize(), function(data, status) {
			if (status == "success") {
				alert(data);
			} else {
				alert("失败! status=" + status);
			}
			callback();
		});
	}
	$("#deleteAccount_button").click(function(){
		$('#deleteAccount_button').css("cursor","wait");
		$("#deleteAccount_button").attr('disabled',true);
		deleteAccount(function(){
			$('#deleteAccount_button').css("cursor","pointer");
			$("#deleteAccount_button").attr('disabled',false);
		});
	});
	
	var accounts;
	//根据idcard查询账户
	function getAccount(callback){
		var idcard=$("#getAccount_form input[name='idcard']").val();
		if(idcard==""){
			alert("身份证号不能为空!");
			callback();return;
		}
		//从服务器获取数据
		$.post("AccountServlet",$("#getAccount_form").serialize(), function(data, status) {
			if(data=="该身份证号尚未注册!"){
				alert("该身份证号尚未注册!");
				callback();return;
			}
			if (status == "success") {
				$("#accounts_table tr:not(:first)").remove();
				var account= JSON.parse(data);
				accounts=new Array();
				accounts[0]=account;
				$('#accounts_table').append('<tr><td>'
						+ account.idcard + '</td><td>'
						+ account.name + '</td><td>'
						+ account.balance + '</td><td><input type="button" class="buttonstyle2" value="查询账单"/><input type="button" class="buttonstyle2" value="删除账户"/></td></tr>');
			} else {
				alert("失败!status=" + status);
			}
			callback();
		});
	}
	$("#getAccount_button").click(function(){
		$('#getAccount_button').css("cursor","wait");
		$("#getAccount_button").attr('disabled',true);
		getAccount(function(){
			$('#getAccount_button').css("cursor","pointer");
			$("#getAccount_button").attr('disabled',false);
		});
	});
	//查询全部账户
	function getAllAccounts(callback){
		//从服务器获取数据
		$.post("AccountServlet",{"method":"getAllAccounts"}, function(data, status) {
			if (status == "success") {
				$("#accounts_table tr:not(:first)").remove();
				accounts= JSON.parse(data);
				for (i = 0; i < accounts.length; i++) {
					var account = accounts[i];
					$('#accounts_table').append('<tr><td>'
							+ account.idcard + '</td><td>'
							+ account.name + '</td><td>'
							+ account.balance + '</td><td><input type="button" class="buttonstyle2" value="查询账单"/><input type="button" class="buttonstyle2" value="删除账户"/></td></tr>');
				}
			} else {
				alert("失败!status=" + status);
			}
			callback();
		});
	}
	$("#getAllAccounts_button").click(function(){
		$('#getAllAccounts_button').css("cursor","wait");
		$("#getAllAccounts_button").attr('disabled',true);
		getAllAccounts(function(){
			$('#getAllAccounts_button').css("cursor","pointer");
			$("#getAllAccounts_button").attr('disabled',false);
		});
	});
	//点击表格里的查询账单按扭
	$("#accounts_table").on('click', 'input[type="button"][value="查询账单"]', function() {
		var rowNum=$(this).parent().parent().index()-1;
		var account=accounts[rowNum];
		$("#getAccountBills_form input[name='idcard']").val(account.idcard);
		getAccountBills();
		$("#select_bills_tab").trigger("click");
	});
	//点击表格里的删除账户按扭
	$("#accounts_table").on('click', 'input[type="button"][value="删除账户"]', function() {
		var rowNum=$(this).parent().parent().index()-1;
		var account=accounts[rowNum];
		$("#deleteAccount_form input[name='idcard']").val(account.idcard);
		deleteAccount();
		$(this).parent().parent().remove();
	});
	var bills;
	//根据idcard查询账单
	function getAccountBills(callback){
		var idcard=$("#getAccountBills_form input[name='idcard']").val();
		if(idcard==""){
			alert("身份证号不能为空!");
			callback();return;
		}
		//从服务器获取数据
		$.post("AccountServlet",$("#getAccountBills_form").serialize(), function(data, status) {
			if(data=="该身份证号尚未注册!"){
				alert("该身份证号尚未注册!");
				callback();return;
			}
			if (status == "success") {
				$("#bills_table tr:not(:first)").remove();
				bills= JSON.parse(data);
				for (i = 0; i < bills.length; i++) {
					var bill = bills[i];
					$('#bills_table').append('<tr><td>'
							+ bill.idcard + '</td><td>'
							+ bill.cost + '</td><td>'
							+ bill.fromCompany + '</td><td>'
							+ new Date(bill.paydate).toLocaleString() + '</td></tr>');
				}
			} else {
				alert("失败!status=" + status);
			}
			callback();
		});
	}
	$("#getAccountBills_button").click(function(){
		$('#getAccountBills_button').css("cursor","wait");
		$("#getAccountBills_button").attr('disabled',true);
		getAccountBills(function(){
			$('#getAccountBills_button').css("cursor","pointer");
			$("#getAccountBills_button").attr('disabled',false);
		});
	});
	//查询全部账单
	function getAllBills(callback){
		//从服务器获取数据
		$.post("AccountServlet",{"method":"getAllBills"}, function(data, status) {
			if (status == "success") {
				$("#bills_table tr:not(:first)").remove();
				bills= JSON.parse(data);
				for (i = 0; i < bills.length; i++) {
					var bill = bills[i];
					$('#bills_table').append('<tr><td>'
							+ bill.idcard + '</td><td>'
							+ bill.cost + '</td><td>'
							+ bill.fromCompany + '</td><td>'
							+ new Date(bill.paydate).toLocaleString() + '</td></tr>');
				}
			} else {
				alert("失败!status=" + status);
			}
			callback();
		});
	}
	$("#getAllBills_button").click(function(){
		$('#getAllBills_button').css("cursor","wait");
		$("#getAllBills_button").attr('disabled',true);
		getAllBills(function(){
			$('#getAllBills_button').css("cursor","pointer");
			$("#getAllBills_button").attr('disabled',false);
		});
	});
});