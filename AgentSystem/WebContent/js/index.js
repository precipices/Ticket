laydate.render({
    elem: '#beginTime_text' //指定元素
  });
//时间选择器
laydate.render({
  elem: '#beginTime_text2'
  ,type: 'datetime'
});
var flights;
var flightInfo;
$(function(){		
	//定义两个城市选择器
	var cityPicker1 = new HzwCityPicker({
	    data: data,
	    target: 'fromWhere_text',
	    valType: 'k-v',
	    hideCityInput: {
	        name: 'city',
	        id: 'city'
	    },
	    hideProvinceInput: {
	        name: 'province',
	        id: 'province'
	    },
	    callback: function(){
	    }
	});
	var cityPicker2 = new HzwCityPicker({
	    data: data,
	    target: 'toWhere_text',
	    valType: 'k-v',
	    hideCityInput: {
	        name: 'city2',
	        id: 'city2'
	    },
	    hideProvinceInput: {
	        name: 'province2',
	        id: 'province2'
	    },
	    callback: function(){
	    }
	});
	var cityPicker3 = new HzwCityPicker({
	    data: data,
	    target: 'fromWhere_text2',
	    valType: 'k-v',
	    hideCityInput: {
	        name: 'city3',
	        id: 'city3'
	    },
	    hideProvinceInput: {
	        name: 'province3',
	        id: 'province3'
	    },
	    callback: function(){
	    }
	});
	var cityPicker4 = new HzwCityPicker({
	    data: data,
	    target: 'toWhere_text2',
	    valType: 'k-v',
	    hideCityInput: {
	        name: 'city4',
	        id: 'city4'
	    },
	    hideProvinceInput: {
	        name: 'province4',
	        id: 'province4'
	    },
	    callback: function(){
	    }
	});
	cityPicker1.init();
	cityPicker2.init();
	cityPicker3.init();
	cityPicker4.init();
	//用post方法调用SelectFlightServlet,查询所有航班,并将结果放到表格#select_flight_table中
		function getAllFlights() {
			$.post("SelectFlightServlet", {
				"method" : "getAllFlights"
			}, function(data, status) {
				if (status = "success") {
					$("#select_flight_table tr:not(:first)").remove();
					$('.flight').remove();
					flights = JSON.parse(data);
					for (i = 0; i < flights.length; i++) {
						var flight = flights[i];
						$('#select_flight_table').append(
								'<tr><td>'
										+ flight.flight+ '</td><td>'
										+ new Date(flight.beginTime).toLocaleString() + '</td><td>'
										+ flight.fromWhere + '</td><td>'
										+ flight.toWhere + '</td><td>'
										+ flight.price + '</td><td><input type="button" class="buttonstyle2" value="删除"><input type="button" class="buttonstyle2" value="查看机票"></td></tr>');
					}
				} else {
					alert("失败!status=" + status);
				}
			});
		}
		//页面加载时就调用selectFlights(),将数据放到表格中;
		// 		getAllFlights();
		$('#getAllFlights_button').click(function() {
			getAllFlights()
		});
		//用post方法调用SelectFlightServlet,查询航班,并将结果放到表格#select_flight_table中
		function getFlights(beginTime, fromWhere, toWhere) {
			$.post("SelectFlightServlet", {
				"method" : "getFlights",
				"beginTime" : beginTime,
				"fromWhere" : fromWhere,
				"toWhere" : toWhere
			}, function(data, status) {
				if (status = "success") {
					$("#select_flight_table tr:not(:first)").remove();
					flights = JSON.parse(data);
					for (i = 0; i < flights.length; i++) {
						var flight = flights[i];
						var table = $('#select_flight_table').append(
								'<tr><td>'
										+ flight.flight + '</td><td>'
										+ new Date(flight.beginTime).toLocaleString() + '</td><td>'
										+ flight.fromWhere + '</td><td>'
										+ flight.toWhere + '</td><td>'
										+ flight.price + '</td><td><input type="button" class="buttonstyle2" value="删除"><input type="button" class="buttonstyle2" value="查看机票"></td></tr>');
					}
				} else {
					alert("失败!status=" + status);
				}
			});
		}
		$('#getFlights_button').click(function() {
			var beginTime = $('#beginTime_text').val();
			var fromWhere = $('#fromWhere_text').val();
			var toWhere = $('#toWhere_text').val();
			if (beginTime == "") {
				alert("出发日期不能为空!");
				return;
			}
			if (fromWhere == "") {
				alert("出发地不能为空!");
				return;
			}
			if (toWhere == "") {
				alert("目的地不能为空!");
				return;
			}
			getFlights(beginTime, fromWhere, toWhere);
		});
		function addFlight(flight, beginTime, fromWhere, toWhere, price, seatsNum) {
			$.post("SelectFlightServlet", {
				"method" : "addFlight",
				"flight":flight,
				"beginTime" : beginTime,
				"fromWhere" : fromWhere,
				"toWhere" : toWhere,
				"price":price,
				"seatsNum":seatsNum
			}, function(data, status) {
				if (status = "success") {
					alert(data);
				} else {
					alert("失败!status=" + status);
				}
			});
		}
		$("#addFlight_button").click(function(){
			var flight=$("#flight_text2").val();
			var beginTime = $('#beginTime_text2').val();
			var fromWhere = $('#fromWhere_text2').val();
			var toWhere = $('#toWhere_text2').val();
			var price=$("#price_text2").val();
			var seatsNum=$("#seatsNum_text2").val();
			if (flight == "") {
				alert("航班不能为空!");
				return;
			}
			if (beginTime == "") {
				alert("起飞时间不能为空!");
				return;
			}
			if (fromWhere == "") {
				alert("出发地不能为空!");
				return;
			}
			if (toWhere == "") {
				alert("目的地不能为空!");
				return;
			}
			if (price == "") {
				alert("机票价格不能为空!");
				return;
			}
			if(isNaN(price)){
				alert("输入的机票价格不是一个数字!");
				return;
			}
			if (seatsNum == "") {
				alert("座位数量不能为空!");
				return;
			}
			if(isNaN(seatsNum)){
				alert("输入的座位数量不是一个数字!");
				return;
			}
			addFlight(flight, beginTime, fromWhere, toWhere, price, seatsNum);
		});
		$("#select_flight_table").on('click', 'input[type="button"][value="查看机票"]', function() {
			//得到选择行的机票的数据
			var rowNum=$(this).parent().parent().index()-1;
			flightInfo=flights[rowNum];
			//post从服务器获取机票余量
			$.post("GetMessageServlet", {
				"method" : "getFlightTickets",
				"beginTime" : flightInfo.beginTime,
				"flight" : flightInfo.flight
			}, function(data, status) {
				if (status == "success") {
					if(data=="时间类型不正确!"){
						alert("时间类型不正确!");
						return;
					}
					//移除表格内容
					$("#select_ticket_table tr:not(:first)").remove();
					var tickets=JSON.parse(data);
					for (i = 0; i < tickets.length; i++) {
						var ticket = tickets[i]
						if(!ticket.idcard){ticket.idcard="未售出";ticket.name="未售出";}
						$('#select_ticket_table').append(
								'<tr><td>'
										+ flightInfo.flight + '</td><td>'
										+ new Date(flightInfo.beginTime).toLocaleString() + '</td><td>'
										+ flightInfo.fromWhere + '</td><td>'
										+ flightInfo.toWhere + '</td><td>'
										+ flightInfo.price + '</td><td>'
										+ ticket.seatNumber + '</td><td>'
										+ ticket.idcard + '</td><td>'
										+ ticket.name + '</td></tr>');
					}
					//触发select_ticket_tab的点击事件
					$("#select_ticket_tab").trigger("click");
				} else {
					alert("失败!status=" + status);
				}
				return;
			});
		});
		$("#select_flight_table").on('click', 'input[type="button"][value="删除"]', function() {
			//得到选择行的机票的数据
			var rowNum=$(this).parent().parent().index()-1;
			flightInfo=flights[rowNum];
			var tr=$(this).parent().parent();
			//post从服务器获取机票余量
			$.post("DeleteFlightServlet", {
				"method" : "deleteFlight",
				"beginTime" : flightInfo.beginTime,
				"flight" : flightInfo.flight
			}, function(data, status) {
				if (status == "success") {
					alert(data);
					if(data=="删除成功!"){
						tr.remove();
					}
				} else {
					alert("失败!status=" + status);
				}
				return;
			});
		});
});