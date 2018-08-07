/**
 * 唐军
 *  ajax再次封装
**/
/**
* ajax post提交
* @param url
* @param param
* @param datat 为html,json,text
* @param callback回调函数
* @return
*/

/**
 *例子 
 * eg:jsonAjax("sss.do", "type=json", "json", callBack);  
function callBack(data) {
    $("#proceeding").html('');
    var json = eval(data); //数组  
    $.each(json, function (index, item) {
        //循环获取数据
        var name = json[index].Name;
        $("#proceeding").html($("#proceeding").html() + "<br>" + name + "<br/>");
    });
};
**/
function jsonAjax(url, param, datat, callback,async) {
	var asyncv = true;
	if("undefined" != typeof async){
		asyncv=async;
	}
    $.ajax({
        type: "post",
        url: url,
        data: param,
        async:asyncv,
        dataType: datat,
        success: callback,
        error: function () {
        }
    });
}

