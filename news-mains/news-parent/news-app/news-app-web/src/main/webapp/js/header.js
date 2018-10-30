$(function(){
	$(".del-user-msg").click(function(){
		
		delUserMsgInfo($(this).attr('data'));
		
		$(this).parent().remove();
		decNum($('.user-msg-num-total'));
		decNum($('.user-msg-num-list'));
	});
	
	/**
	 * 自减数字
	 * @param obj
	 * @returns
	 */
	function decNum(obj){
		var num = parseInt(obj.html());
		if(num > 0 ){
			obj.html(num - 1);
		}
	}
	
	/**
	 * 删除消息
	 * @param msgId
	 * @returns
	 */
	function delUserMsgInfo(msgId){
		$.ajax({
			url : conf.ctx + '/user/delMsgInfo.do',
			type : 'post',
			dataType : 'json',
			data : JSON.stringify({"id":msgId}),
			contentType : "application/json",
			success : function(data) {
				if (data.success) {
					toastr["success"]("删除成功", "温馨提示");
				} else {
					toastr["warning"](
							data.message ? data.message
									: "操作失败", "温馨提示");
				}
			},
			error : function(e) {
				toastr["error"]("连接服务器超时，请稍后重试");
			}
		});
	}
	
	/**
	 * 点击消息内容
	 */
	$(".click-user-msg").click(function(){
		//FIXME 完善连接
		var data = JSON.parse($(this).attr('data'));
		switch (data.type_cd) {
		    case "QYHT":
		        // 跳转到签约合同的页面
		    	window.location.href = conf.ctx + '/signVendorContract/toContactDeteail.do?contractId='+data.contract_id;
		         break;
		    case "WGHT":
		        // 跳转到外雇合同的页面
		    	window.location.href = conf.ctx + '/tempVendorContract/toTempContactDeteail.do?tempContactcontractId='+data.contract_id;
		        break;
		    case "DBHT":
		        // 跳转到外雇合同的页面
		    	window.location.href = conf.ctx + '/shortVendorContract/toShortContactDeteail.do?contractId='+data.contract_id;
		        break;
		    default:
		        console.log(data);
		}
	});

});