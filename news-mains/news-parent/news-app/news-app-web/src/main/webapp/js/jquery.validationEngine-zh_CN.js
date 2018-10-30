(function($){
    $.fn.validationEngineLanguage = function(){
    };
    $.validationEngineLanguage = {
        newLang: function(){
            $.validationEngineLanguage.allRules = {
                "required": { // Add your regex rules here, you can take telephone as an example
                    "regex": "none",
                    "alertText": "* 此处为必输项",
                    "alertTextCheckboxMultiple": "* 请选择一个项目",
                    "alertTextCheckboxe": "* 您必须钩选此栏",
                    "alertTextDateRange": "* 日期范围不可空白"
                },
                "requiredInFunction": { 
                    "func": function(field, rules, i, options){
                        return (field.val() == "test") ? true : false;
                    },
                    "alertText": "* Field must equal test"
                },
                "dateRange": {
                    "regex": "none",
                    "alertText": "* 无效的 ",
                    "alertText2": " 日期范围"
                },
                "dateTimeRange": {
                    "regex": "none",
                    "alertText": "* 无效的 ",
                    "alertText2": " 时间范围"
                },
                "minSize": {
                    "regex": "none",
                    "alertText": "* 最少 ",
                    "alertText2": " 个字符"
                },
                "maxSize": {
                    "regex": "none",
                    "alertText": "* 最多 ",
                    "alertText2": " 个字符"
                },
				"groupRequired": {
                    "regex": "none",
                    "alertText": "* 你必需选填其中一个栏位"
                },
                "min": {
                    "regex": "none",
                    "alertText": "* 最小值為 "
                },
                "max": {
                    "regex": "none",
                    "alertText": "* 最大值为 "
                },
                "past": {
                    "regex": "none",
                    "alertText": "* 日期必需早于 "
                },
                "future": {
                    "regex": "none",
                    "alertText": "* 日期必需晚于 "
                },	
                "maxCheckbox": {
                    "regex": "none",
                    "alertText": "* 最多选取 ",
                    "alertText2": " 个项目"
                },
                "minCheckbox": {
                    "regex": "none",
                    "alertText": "* 请选择 ",
                    "alertText2": " 个项目"
                },
                "equals": {
                    "regex": "none",
                    "alertText": "* 请输入与上面相同的密码"
                },
                "creditCard": {
                    "regex": "none",
                    "alertText": "* 无效的信用卡号码"
                },
                "phone": {
                    // credit: jquery.h5validate.js / orefalo
                    "regex": /^([\+][0-9]{1,3}([ \.\-])?)?([\(][0-9]{1,6}[\)])?([0-9 \.\-]{1,32})(([A-Za-z \:]{1,11})?[0-9]{1,4}?)$/,
                    "alertText": "* 无效的电话号码"
                },
        		"mobile":{
        			"regex" : /^0?(1)[0-9]{10}$/,
        			"alertText": "* 无效的手机号码"
        		},
        		"bankCard":{
        			"regex" : /^(\d{16,19})$/,
        			"alertText": "* 无效的银行帐号"
        		},        		
        		"qq":{
        			"regex" : /[1-9][0-9]{4,14}/,
        			"alertText": "* 无效的qq账号"
        		},        		
        		"text":{
        			"regex" : /^0\.(0[1-9]|[1-9]{1,2})$/,
        			"alertText": "* 不是有效的税率"
        		},       		
                "email": {
                    // Shamelessly lifted from Scott Gonzalez via the Bassistance Validation plugin http://projects.scottsplayground.com/email_address_validation/
                    "regex": /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i,
                    "alertText": "* 邮件地址无效"
                },
                "zcode": {
                    // Shamelessly lifted from Scott Gonzalez via the Bassistance Validation plugin http://projects.scottsplayground.com/email_address_validation/
                    "regex": /^[1-9]\d{5}(?!\d)$/g,
                    "alertText": "* 邮编格式无效"
                },
                "integer": {
                    "regex": /^[\-\+]?\d+$/,
                    "alertText": "* 不是有效的整数"
                },
                "number": {
                    // Number, including positive, negative, and floating decimal. credit: orefalo
                    "regex": /^[\-\+]?((([0-9]{1,3})([,][0-9]{3})*)|([0-9]+))?([\.]([0-9]+))?$/,
                    "alertText": "* 无效的数字"
                },
                "date": {
                    "regex": /^\d{4}[\/\-](0?[1-9]|1[012])[\/\-](0?[1-9]|[12][0-9]|3[01])$/,
                    "alertText": "* 无效的日期，格式必需为 YYYY-MM-DD"
                },
                "ipv4": {
                    "regex": /^((([01]?[0-9]{1,2})|(2[0-4][0-9])|(25[0-5]))[.]){3}(([0-1]?[0-9]{1,2})|(2[0-4][0-9])|(25[0-5]))$/,
                    "alertText": "* 无效的 IP 地址"
                },
                "url": {
                    "regex": /^(https?|ftp):\/\/(((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:)*@)?(((\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5]))|((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?)(:\d*)?)(\/((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/(([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)?)?(\?((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|[\uE000-\uF8FF]|\/|\?)*)?(\#((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|\/|\?)*)?$/i,
                    "alertText": "* Invalid URL"
                },
                "onlyNumberSp": {
                    "regex": /^[0-9\ ]+$/,
                    "alertText": "* 只能填数字"
                },
                "onlyNumberSp0": {
                    "regex": /^(0|[1-9][0-9]*)$/,
                   
                    "alertText": "* 请输入正确的整数"
                },
                "onlyLetterSp": {
                    "regex": /^[a-zA-Z\ \']+$/,
                    "alertText": "* 只接受英文字母大小写"
                },
				"onlyLetterAccentSp":{
                    "regex": /^[a-z\u00C0-\u017F\ ]+$/i,
                    "alertText": "* 只接受英文字母大小写"
                },
                "onlyLetterNumber": {
                    "regex": /^[0-9a-zA-Z]+$/,
                    "alertText": "* 不接受特殊字符"
                },
                // --- CUSTOM RULES -- Those are specific to the demos, they can be removed or changed to your likings
                "ajaxUserCall": {
                    "url": "ajaxValidateFieldUser",
                    // you may want to pass extra data on the ajax call
                    "extraData": "name=eric",
                    "alertText": "* 此名称已被其他人使用",
                    "alertTextLoad": "* 正在确认名称是否有其他人使用，请稍等。"
                },
				"ajaxUserCallPhp": {
                    "url": "phpajax/ajaxValidateFieldUser.php",
                    // you may want to pass extra data on the ajax call
                    "extraData": "name=eric",
                    // if you provide an "alertTextOk", it will show as a green prompt when the field validates
                    "alertTextOk": "* 此帐号名称可以使用",
                    "alertText": "* 此名称已被其他人使用",
                    "alertTextLoad": "* 正在确认帐号名称是否有其他人使用，请稍等。"
                },
                "ajaxNameCall": {
                    // remote json service location
                    "url": "ajaxValidateFieldName",
                    // error
                    "alertText": "* 此名称可以使用",
                    // if you provide an "alertTextOk", it will show as a green prompt when the field validates
                    "alertTextOk": "* 此名称已被其他人使用",
                    // speaks by itself
                    "alertTextLoad": "* 正在确认名称是否有其他人使用，请稍等。"
                },
				 "ajaxNameCallPhp": {
	                    // remote json service location
	                    "url": "phpajax/ajaxValidateFieldName.php",
	                    // error
	                    "alertText": "* 此名称已被其他人使用",
	                    // speaks by itself
	                    "alertTextLoad": "* 正在确认名称是否有其他人使用，请稍等。"
	                },
                "validate2fields": {
                    "alertText": "* 请输入 HELLO"
                },
	            //tls warning:homegrown not fielded 
                "dateFormat":{
                    "regex": /^\d{4}[\/\-](0?[1-9]|1[012])[\/\-](0?[1-9]|[12][0-9]|3[01])$|^(?:(?:(?:0?[13578]|1[02])(\/|-)31)|(?:(?:0?[1,3-9]|1[0-2])(\/|-)(?:29|30)))(\/|-)(?:[1-9]\d\d\d|\d[1-9]\d\d|\d\d[1-9]\d|\d\d\d[1-9])$|^(?:(?:0?[1-9]|1[0-2])(\/|-)(?:0?[1-9]|1\d|2[0-8]))(\/|-)(?:[1-9]\d\d\d|\d[1-9]\d\d|\d\d[1-9]\d|\d\d\d[1-9])$|^(0?2(\/|-)29)(\/|-)(?:(?:0[48]00|[13579][26]00|[2468][048]00)|(?:\d\d)?(?:0[48]|[2468][048]|[13579][26]))$/,
                    "alertText": "* 无效的日期格式"
                },
                //tls warning:homegrown not fielded 
				"dateTimeFormat": {
	                "regex": /^\d{4}[\/\-](0?[1-9]|1[012])[\/\-](0?[1-9]|[12][0-9]|3[01])\s+(1[012]|0?[1-9]){1}:(0?[1-5]|[0-6][0-9]){1}:(0?[0-6]|[0-6][0-9]){1}\s+(am|pm|AM|PM){1}$|^(?:(?:(?:0?[13578]|1[02])(\/|-)31)|(?:(?:0?[1,3-9]|1[0-2])(\/|-)(?:29|30)))(\/|-)(?:[1-9]\d\d\d|\d[1-9]\d\d|\d\d[1-9]\d|\d\d\d[1-9])$|^((1[012]|0?[1-9]){1}\/(0?[1-9]|[12][0-9]|3[01]){1}\/\d{2,4}\s+(1[012]|0?[1-9]){1}:(0?[1-5]|[0-6][0-9]){1}:(0?[0-6]|[0-6][0-9]){1}\s+(am|pm|AM|PM){1})$/,
                    "alertText": "* 无效的日期或时间格式",
                    "alertText2": "可接受的格式： ",
                    "alertText3": "mm/dd/yyyy hh:mm:ss AM|PM 或 ", 
                    "alertText4": "yyyy-mm-dd hh:mm:ss AM|PM"
	            },
	            "city2":{
	            	"func": function(field, rules, i, options){
	            		var code = field.val();
	            		if('' == code || code.length < 4){
	            			return false;
	            		}
	            		return true;
	            	},
	            	"alertText":"* 请选至市一级"
	            },
	            "city3":{
	            	"func": function(field, rules, i, options){
	            		var code = field.siblings('input').val();
	            		if('' == code || Number(code) % 100 == 0){
	            			return false;
	            		}
	            		return true;
	            	},
	            	"alertText":"* 请选至区县一级"
	            }, 
	            "IdNo":{
	            	"func": function(field, rules, i, options){
	            		   // 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X  
	            		   var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;  
	            		   if(reg.test(field.val()) === false){  
	            		       return  false;  
	            		   }  else{
	            			   return true;
	            		   }
	            	},
	            	"alertText":"* 身份证号码不合法"
	            },
	            //车头车牌校验
	            "tkPlateNo":{
	            	"func": function(field, rules, i, options){
	            		   var reg = /^[\u4e00-\u9fa5]{1}[A-Z]{1}[A-Z_0-9]{5}$/;  
	            		   if(reg.test(field.val()) === false){  
	            		       return  false;  
	            		   }  else{
	            			   return true;
	            		   }
	            	},
	            	"alertText":"* 车牌不合法"
	            },
	            //车厢车牌校验
	            "trPlateNo":{
	            	"func": function(field, rules, i, options){
	            		var reg = /^[\u4e00-\u9fa5]{1}[A-Z]{1}[A-Z_0-9]{4}挂$/;  
	            		if(reg.test(field.val()) === false){  
	            			return  false;  
	            		}  else{
	            			return true;
	            		}
	            	},
	            	"alertText":"* 车牌不合法"
	            },
	            "valiName":{
	            	"func": function(field, rules, i, options){
	            		// 只能包含汉字和英文
	            		var reg = /^[\u4e00-\u9fa5a-zA-Z]{2,10}?$/;  
	            		if(reg.test(field.val()) === false){  
	            			return  false;  
	            		}  else{
	            			return true;
	            		}
	            	},
	            	"alertText":"* 只能包含2-10个汉字和英文"
	            },
	            "valiNum":{
	            	"func": function(field, rules, i, options){
	            		// 纯数字
	            		var reg = /^[0-9]*$/;  
	            		if(reg.test(field.val()) === false){  
	            			return  false;  
	            		}  else{
	            			return true;
	            		}
	            	},
	            	"alertText":"* 只能输入数字"
	            },
	            "valiCharge":{
	            	"func": function(field, rules, i, options){
	            		// 纯数字
	            		var reg = /^\d{1,5}(\.\d{1,2})?$/;  
	            		if(reg.test(field.val()) === false){  
	            			return  false;  
	            		}  else{
	            			return true;
	            		}
	            	},
	            	"alertText":"* 价格输入不合法，最大值为99999.99"
	            },
	            "valitrCharge":{
	            	"func": function(field, rules, i, options){
	            		// 纯数字
	            		var reg = /^\d{1,5}(\.\d{1,2})?$/;  
	            		if(reg.test(field.val()) === false){  
	            			return  false;  
	            		}  else{
	            			return true;
	            		}
	            	},
	            	"alertText":"* 输入不合法,区间为[0.01-99999.99]。"
	            },
	            "validuration":{
	            	"func": function(field, rules, i, options){
	            		var reg = /^\d{1,3}(\.\d{1,1})?$/;  
	            		if(reg.test(field.val()) === false){  
	            			return  false;  
	            		}  else{
	            			return true;
	            		}
	            	},
	            	"alertText":"* 时效为正整数或小数 最多一位小数，最长不能超过999.9"
	            },
	            "validistance":{
	            	"func": function(field, rules, i, options){
	            		// 公里数为正整数，最大不能超过10000 
	            		var reg = /^([0-9]\d{0,3}|10000)$/;  
	            		if(reg.test(field.val()) === false){  
	            			return  false;  
	            		}  else{
	            			return true;
	            		}
	            	},
	            	"alertText":"* 公里数输入不合法，最大值为10000的正整数"
	            },
	            "password" : {
					"regex" : /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]+$/,
					"alertText" : "* 必须包含字母和数字"
				},
				"valinumber1":{
	            	"func": function(field, rules, i, options){
	            		var reg = /^\d{1,8}(\.\d{1,2})?$/;  
	            		if(reg.test(field.val()) === false){  
	            			return  false;  
	            		}  else{
	            			return true;
	            		}
	            	},
	            	"alertText":"* 输入不合法，输入值为正整数或小数 最多2位小数，最长不能超过99999999.99"
	            },
	            "valinumber2":{
	            	"func": function(field, rules, i, options){
	            		var reg = /^\d{1,4}(\.\d{1,1})?$/;  
	            		if(reg.test(field.val()) === false){  
	            			return  false;  
	            		}  else{
	            			return true;
	            		}
	            	},
	            	"alertText":"* 输入不合法，输入值为正整数或小数 最多1位小数，最长不能超过9999.9"
	            },
	            "valinumber3":{
	            	"func": function(field, rules, i, options){
	            		var reg = /^\d{1,9}$/;  
	            		if(reg.test(field.val()) === false){  
	            			return  false;  
	            		}  else{
	            			return true;
	            		}
	            	},
	            	"alertText":"* 输入不合法，输入值为整数，最小为0，最长不能超过999999999"
	            },
	            "valinumber4":{
	            	"func": function(field, rules, i, options){
	            		var reg = /(0\.\d{1,4}\b|^0$)/;  
	            		if(reg.test(field.val()) === false){  
	            			return  false;  
	            		}  else{
	            			return true;
	            		}
	            	},
	            	"alertText":"* 输入不合法，输入值为小数，最长不能超过1.0000"
	            },
	            "valinumber5":{
	            	"func": function(field, rules, i, options){
	            		var reg = /^[1-9][0-9]{0,8}?$/;  
	            		if(reg.test(field.val()) === false){  
	            			return  false;  
	            		}  else{
	            			return true;
	            		}
	            	},
	            	"alertText":"* 输入不合法，输入值为整数，最小为1，最长不能超过999999999"
	            },
	            "valinumber6":{
	            	"func": function(field, rules, i, options){
	            		var reg = /^\d{0,8}(\.\d{1,2})?$/;
	            		if(reg.test(field.val()) === false){  
	            			return  false;  
	            		} else if(Number(field.val()) === 0){
	            			return  false;  
	            		}else{
	            			return true;
	            		}
	            	},
	            	"alertText":"* 输入不合法，输入值为大于0的正整数或小数 最多2位小数，最长不能超过99999999.99"
	            },
	            "valinumber7":{  //FIXME 太定制化了 不适合放在公共方法里
	            	"func": function(field, rules, i, options){
	            		var reg = /^\d{0,2}(\.\d{1,1})?$/;
	            		if(reg.test(field.val()) === false){  
	            			return  false;  
	            		} else if(Number(field.val()) === 0){
	            			return  false;  
	            		}else{
	            			return true;
	            		}
	            	},
	            	"alertText":"* 输入不合法，输入值为大于0的正整数或小数 最多1位小数，最长不能超过99.9"
	            }
            };
            
        }
    };
    $.validationEngineLanguage.newLang();
})(jQuery);
