/**
 * 唐军
 * 全局项目用到的函数
**/
//将含有timestamp的json对象的毫秒数转成日期格式
 function json2TimeStamp(milliseconds){
 			if(null==milliseconds){
 				return '';
 			}else{
	　　        var datetime = new Date();
	　　        datetime.setTime(milliseconds);
	　　        var year=datetime.getFullYear();
	               //月份重0开始，所以要加1，当小于10月时，为了显示2位的月份，所以补0
	　　        var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
	　　        var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
	　　        var hour = datetime.getHours()< 10 ? "0" + datetime.getHours() : datetime.getHours();
	　　        var minute = datetime.getMinutes()< 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
	　　        var second = datetime.getSeconds()< 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
	　　        return year + "-" + month + "-" + date;
 			}
}
 
 
 //将含有timestamp的json对象的毫秒数转成日期格式
 function json2TimeStampNew(milliseconds){
　　        var datetime = new Date();
　　        datetime.setTime(milliseconds);
　　        var year=datetime.getFullYear();
               //月份重0开始，所以要加1，当小于10月时，为了显示2位的月份，所以补0
　　        var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
　　        var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
　　        var hour = datetime.getHours()< 10 ? "0" + datetime.getHours() : datetime.getHours();
　　        var minute = datetime.getMinutes()< 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
　　        var second = datetime.getSeconds()< 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
　　        return year + "-" + month + "-" + date+"  " +hour+":"+minute;
}
function trim(str){ //删除左右两端的空格　　
	try{
   	 return str.replace(/(^\s*)|(\s*$)/g, "");
    }catch(e){};
}
//支持各种浏览器
String.prototype.trim = function () {
	try{
		return this .replace(/^\s\s*/, '' ).replace(/\s\s*$/, '' );
 	}catch(e){};
}
 //去掉前后空格的
function replaceTrim(field){
	var fieldVar = $("#"+field).val().trim();
	$("#"+field).val(fieldVar);
}
//select选中
function selectObj(id,value){
	 var objSelect = document.getElementById(id);
	 for(var i=0;i<objSelect.options.length;i++) {  
        if(objSelect.options[i].value == value) {  
            objSelect.options[i].selected = true;  
            break;  
        }  
	}  
}

//清空值
function cleanClick(field){
	$("#"+field).val("");
} 

//返回
function returnObj(url){
	location.href=url;
}
//判断是否是删除和修改和查看
function checkVisitType(pageIndex,pageSize){
	 if(pageIndex == ""){
		newPage= urlToParameter('newpage')
	 }if(pageSize == ""){
		pageSize=urlToParameter('pageSize');
	 }else{
		 newPage=pageIndex;
		 pageSize=pageSize;
	 }
		 
	 
}


//juery 获取url 传过来的参数
function urlToParameter(paras){ 
	var url = location.href; 
    var paraString = url.substring(url.indexOf("?")+1,url.length).split("&"); 
    var paraObj = {} 
    for (i=0; j=paraString[i]; i++){ 
    	paraObj[j.substring(0,j.indexOf("=")).toLowerCase()] = j.substring(j.indexOf("=")+1,j.length); 
    } 
    var returnValue = paraObj[paras.toLowerCase()]; 
    if(typeof(returnValue)=="undefined"){ 
    	return ""; 
    }else{ 
    	return returnValue; 
    } 
}
//获取url所带参数
function GetRequest() { 
   var url = location.search; //获取url中"?"符后的字串 
   var theRequest = new Object(); 
   if (url.indexOf("?") != -1) { 
      var str = url.substr(1); 
      strs = str.split("&"); 
      for(var i = 0; i < strs.length; i ++) { 
         theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]); 
      } 
   } 
   return theRequest; 
}
/***
 * 截取函数
 *@param {Object} val截取的值，截取的位置
 *@return {TypeName} 
 */
function subStringStrObj(val,num){
	if(val==''||val === null){
		return "";
	}else if(val.length<=num){
		return val;
	}else{
		return val.substring(0,num)+"...";
	} 
}

//判断值是否为空
function cleanClickIS(field){
	var fieldValue = $("#"+field).val().trim();
	if(fieldValue.length<1){
		return false;
	}else{
		return true;
	}
}
//判断值是否为空
function cleanClickISVAL(fieldVal){
	var fieldValue =trim(fieldVal);
	if(fieldValue.length<1){
		return false;
	}else{
		return true;
	}
} 
//提示
function f_tip(content) {
	var t = $.ligerDialog.tip({title: '提示信息',content:content,closeWhenEnter:true});
	 var timeout=setTimeout(function () {
       t.close();
    }, 6000);
}

//提示
function f_tipT(title,content) {
	var t = $.ligerDialog.tip({title: title,content:content,closeWhenEnter:true});
	 var timeout=setTimeout(function () {
       t.close();
    }, 6000);
}
/**
 * 跳转到指定页面函数
 * @param url
 * @returns
 */
function hrefappointpage(hrefurl){
	 window.location.href=hrefurl; 
}
/**
 * 
 * @returns
 */
function alertObjWX(){
	$.alert("此功能正在建设中，敬请期待中！", "建设中...");
}
/**
 * 刷新页面 
 * @param hrefurl
 * @returns
 */
function reserchpage(){
	 window.location.href=window.location.href; 
}

function number_format(number, decimals, dec_point, thousands_sep,roundtag) {
    /*
    * 参数说明：
    * number：要格式化的数字
    * decimals：保留几位小数
    * dec_point：小数点符号
    * thousands_sep：千分位符号
    * roundtag:舍入参数，默认 "ceil" 向上取,"floor"向下取,"round" 四舍五入
    * */
    number = (number + '').replace(/[^0-9+-Ee.]/g, '');
    roundtag = roundtag || "ceil"; //"ceil","floor","round"
    var n = !isFinite(+number) ? 0 : +number,
        prec = !isFinite(+decimals) ? 0 : Math.abs(decimals),
        sep = (typeof thousands_sep === 'undefined') ? ',' : thousands_sep,
        dec = (typeof dec_point === 'undefined') ? '.' : dec_point,
        s = '',
        toFixedFix = function (n, prec) {
            var k = Math.pow(10, prec);
            return '' + parseFloat(Math[roundtag](parseFloat((n * k).toFixed(prec*2))).toFixed(prec*2)) / k;
        };
    s = (prec ? toFixedFix(n, prec) : '' + Math.round(n)).split('.');
    var re = /(-?\d+)(\d{3})/;
    while (re.test(s[0])) {
        s[0] = s[0].replace(re, "$1" + sep + "$2");
    }
 
    if ((s[1] || '').length < prec) {
        s[1] = s[1] || '';
        s[1] += new Array(prec - s[1].length + 1).join('0');
    }
    return s.join(dec);
}
//console.log(number_format(2, 2, ".", ","))//"2.00"
//console.log(number_format(3.7, 2, ".", ","))//"3.70"
//console.log(number_format(3, 0, ".", ",")) //"3"
//console.log(number_format(9.0312, 2, ".", ","))//"9.03"
//console.log(number_format(9.00, 2, ".", ","))//"9.00"
//console.log(number_format(39.715001, 2, ".", ",", "floor")) //"39.71"
//console.log(number_format(9.7, 2, ".", ","))//"9.70"
//console.log(number_format(39.7, 2, ".", ","))//"39.70"
//console.log(number_format(9.70001, 2, ".", ","))//"9.71"
//console.log(number_format(39.70001, 2, ".", ","))//"39.71"
//console.log(number_format(9996.03, 2, ".", ","))//"9996.03"
//console.log(number_format(1.797, 3, ".", ",", "floor"))//"1.797"