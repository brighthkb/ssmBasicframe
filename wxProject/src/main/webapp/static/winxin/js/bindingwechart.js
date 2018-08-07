
/** 获取倒计时参数  **/
var clock = '';
var nums = 60;
var btn;

$(function(){
	$(".getTime").hide();
});
/**
 * 验证码循环
 * @param value
 * @returns {*}
 */

function sendCodetell(thisBtn){
    var phone=$("#phone").val();
    if(!isPhone(phone)) return;
    //获取倒计时
    btn = thisBtn;
    if(!btn.disabled){
        btn.disabled = true; //将按钮置为不可点击
        clock = setInterval(doLoop, 1000); //一秒执行一次
        jsonAjax(ctxjsurl+"/weinxin/wxindexmain/checkrandomVcode.do",{phone:phone},"json",
			  	function(data){
		},false); 
        return clock;
    }

}
function doLoop()
{
    nums--;
    if(nums > 0){
        $(".sentTime").hide();
        $(".getTime").show();
        $(".getTime").html("重新发送"+nums);
    }else{
        clearInterval(clock); //清除js定时器
        btn.disabled = false;
        $(".getTime").hide();
        $(".sentTime").show();
        $(".sentTime").html("重新发送");
        nums = 60; //重置时间
    }
}

/**
 * 手机号码校验
 * @param value
 * @returns {*}
 */

function isPhone(value) {
    var phone = value;
    if (phone == "") {
        $.toptip('手机号码不能为空', 'error');
        return false;
    }
    var patterns = /^1[3,5,8,7,4]\d{9}$/;
    if (!patterns.test(phone)) {
        $.toptip('手机号码错误', 'error');
        return false;
    }
    return true;

}

/**
 * 6位验证码校验
 * @param value
 * @returns {*}
 */
function isYzm(value) {
    var code = value;
    if (code == "") {
        $.toptip('验证码不能为空', 'error');
        return false;
    }
    var reg = /^[0-9A-Za-z]{6}$/;
    if (!reg.test(code)) {
        $.toptip('验证码错误', 'error');
        return false;
    } else {
        return true;
    }
}