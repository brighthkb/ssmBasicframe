/* 日期对象格式化成字符串  */
Date.prototype.zznode_format = function(format) {
	var o = {
		"M+" : this.getMonth() + 1,
		"d+" : this.getDate(),
		"h+" : this.getHours(),
		"m+" : this.getMinutes(),
		"s+" : this.getSeconds(),
		"q+" : Math.floor((this.getMonth() + 3) / 3),
		"S" : this.getMilliseconds()
	};
	if (/(y+)/.test(format)) {
		format = format.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	}
	for ( var k in o) {
		if (new RegExp("(" + k + ")").test(format)) {
			format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k]
					: ("00" + o[k]).substr(("" + o[k]).length));
		}
	}
	return format;
};

/* 字符串转换成日期对象,注意:月份从0-11 */
function dateStrToDate(dateStr) {
	var theDate = null;
	if (dateStr.indexOf(" ") == -1) {
		// 2012-9-20、2012-09-20
		var b = dateStr.split("-");
		theDate = new Date(b[0], b[1] - 1, b[2]);
	} else {
		// 2012-9-20 19:46:18、2012-09-20 19:46:18
		var a = dateStr.split(" ");
		var b = a[0].split("-");
		var c = a[1].split(":");
		theDate = new Date(b[0], b[1] - 1, b[2], c[0], c[1], c[2]);
	}

	return theDate;
}

// 注册命名空间-防止JS命名冲突
var Namespace = new Object();
Namespace.register = function(path) {
	var arr = path.split(".");
	var ns = "";
	for ( var i = 0; i < arr.length; i++) {
		if (i > 0)
			ns += ".";
		ns += arr[i];
		eval("if(typeof(" + ns + ") == 'undefined') " + ns + " = new Object();");
	}
};

//跳转工具类方法
$.extend({
	// (表单提交方式)页面跳转
	jumpPage : function(url, args) {
		var body = $(document.body), form = $("<form method='post'></form>"), input;
		form.attr({
			"action" : url
		});
		$.each(args, function(key, value) {
			input = $("<input type='hidden'>");
			input.attr({
				"name" : key
			});
			input.val(value);
			form.append(input);
		});

		form.appendTo(document.body);
		form.submit();
		document.body.removeChild(form[0]);
	},
	// Tab页面内部跳转:进入下一个页面
	jumpPage2 : function(uuid,url, args, successFun, errorFun) {
		var loadIndex = layer.load();
		$.ajax({
			url : url,
			data : args,
			type : "POST",
			timeout : 10 * 1000,
			dataType : "html",
			success : function(data, textStatus) {
				layer.close(loadIndex);
				$("#panel_"+uuid).hide();
				$("#panel_"+uuid).after(data);
				var datanew =data;
				var panelid =$(datanew).find("div")[0].id;
				$("#"+panelid).append("<input type='hidden' name='panneluuid' value='"+uuid+"'/>");;
				if (typeof successFun == 'function') {
					successFun();
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				layer.close(loadIndex);
				layer.msg('加载页面错误...', function() {
					if (typeof errorFun == 'function') {
						errorFun();
					}
				});
			}
		});
	},
	// Tab页面内部跳转：返回上一个页面
	jumpPage3 : function(uuid,callbackFun) {
		var uuidBak =$("#panel_"+uuid+" input[name='panneluuid']").val();
		$("#page_"+uuid).remove();
		$("#panel_"+uuidBak).show();
		if (typeof callbackFun == 'function') {
			callbackFun();
		}
	},
	// Tab页面内部跳转：替换方式进入下一个页面(可用于批量操作)
	jumpPage4 : function(url, args, successFun, errorFun) {
		var loadIndex = layer.load();
		$.ajax({
			url : url,
			data : args,
			type : "POST",
			timeout : 10 * 1000,
			dataType : "html",
			success : function(data, textStatus) {
				layer.close(loadIndex);
				$(".page:visible").hide().remove();
				$(".page:last").append(data);
				if (typeof successFun == 'function') {
					successFun();
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				layer.close(loadIndex);
				layer.msg('加载页面错误...', function() {
					if (typeof errorFun == 'function') {
						errorFun();
					}
				});
			}
		});
	},
	// 点击菜单进入Tab页面
	jumpPage5 : function(url, args, successFun, errorFun) {
		var loadIndex = layer.load();
		$.ajax({
			url : url,
			data : args,
			type : "POST",
			timeout : 10 * 1000,
			dataType : "html",
			success : function(data, textStatus) {
				layer.close(loadIndex);
				$(".page").empty().append(data);
				if (typeof successFun == 'function') {
					successFun();
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				layer.close(loadIndex);
				layer.msg('加载页面错误...', function() {
					if (typeof errorFun == 'function') {
						errorFun();
					}
				});
			}
		});
	},
	// 拓扑图点击进入下一层页面使用，旨在记录访问的地址及访问参数，以便实现返回功能
	jumpPage6 : function(url, args, successFun, errorFun) {
		var loadIndex = layer.load();
		$.ajax({
			url : url,
			data : args,
			type : "POST",
			timeout : 10 * 1000,
			dataType : "html",
			success : function(data, textStatus) {
				layer.close(loadIndex);
				$(".page").hide();
				$(".page").append(data);
				if (typeof successFun == 'function') {
					successFun({
			             url : url,
			             args : args
			         });
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				layer.close(loadIndex);
				layer.msg('加载页面错误...', function() {
					if (typeof errorFun == 'function') {
						errorFun();
					}
				});
			}
		});
	}
});

//初始化表单元素
jQuery.fn.extend({
	/*  初始化select下拉option元素  */
	initSelectOption: function(_name,_emptytext,_selected) {
		var currentEm = $(this);
		$.ajax({
			url : ctx+"/common/dict",
			data : {"_name" : _name},
			type : "POST",
			dataType : "json",
			success : function(result) {
				if(result.success){
					var htmlOptions = "";
					//拼接空值option
					if(_emptytext){
						htmlOptions+='<option value="">'+_emptytext+'</option>';
					}
					//拼接字典option
					$.each(result.userdata, function(i,n){
						var selectedAttr = _selected==n.key ? ' selected="selected" ' : ' ';
						var option = '<option '+selectedAttr+' value="'+n.key+'">'+n.value+'</option>';
						htmlOptions+=option;
					});
					//添加到select元素中
					currentEm.html(htmlOptions);
				}else{
					$.messager.alert('提示信息',"加载字典数据错误！",'error',function(){});
				}
			}
		});
		
		return currentEm;
    },
    /*  初始化checkbox元素  */
	initCheckBox: function(_name, _emNameAttr, _funCallbak) {
		var currentEm = $(this);
		if(!_emNameAttr) 
			_emNameAttr = '';
		else
			_emNameAttr = ' name="'+_emNameAttr+'" ';
		
		$.ajax({
			url : ctx+"/common/dict",
			data : {"_name" : _name},
			type : "POST",
			dataType : "json",
			success : function(result) {
				if(result.success){
					var htmlCheckboxs = "";
					//拼接字典checkbox
					$.each(result.userdata, function(i,n){
						var checkbox = '<label style="font-size:14px;cursor: pointer;"><input '+_emNameAttr+' style="margin: 0px 1px 0px 0px;" type="checkbox" value="'+n.key+'"/>'+n.value+'</label>&nbsp;&nbsp;&nbsp;';
						htmlCheckboxs+=checkbox;
					});
					//添加到checkbox容器中
					currentEm.html(htmlCheckboxs);
					//回调方法
					if(typeof(_funCallbak) == 'function'){
						_funCallbak($(":checkbox", currentEm));
					}
				}else{
					$.messager.alert('提示信息',"加载字典数据错误！",'error',function(){});
				}
			}
		});
		
		return currentEm;
    },
    /*  初始化radio元素  */
	initRadio: function(_name, _emNameAttr, _funCallbak) {
		var currentEm = $(this);
		if(!_emNameAttr) 
			_emNameAttr = '';
		else
			_emNameAttr = ' name="'+_emNameAttr+'" ';
		
		$.ajax({
			url : ctx+"/common/dict",
			data : {"_name" : _name},
			type : "POST",
			dataType : "json",
			success : function(result) {
				if(result.success){
					var htmlRadios = "";
					//拼接字典radio
					$.each(result.userdata, function(i,n){
						var radio = '<label style="font-size:14px;cursor: pointer;"><input '+_emNameAttr+' style="margin: 0px 1px 0px 0px;" type="radio" value="'+n.key+'"/>'+n.value+'</label>&nbsp;&nbsp;&nbsp;';
						htmlRadios+=radio;
					});
					//添加到radio容器中
					currentEm.html(htmlRadios);
					//回调方法
					if(typeof(_funCallbak) == 'function'){
						_funCallbak($(":radio", currentEm));
					}
				}else{
					$.messager.alert('提示信息',"加载字典数据错误！",'error',function(){});
				}
			}
		});
		
		return currentEm;
    }
});

//表格-格式化单元格时间(参数：毫秒)
function format_time(value,row,index){
	if(value){
		return new Date(parseInt(value)).zznode_format("yyyy-MM-dd hh:mm:ss");
	}
	
	return value;
}
//表格-格式化单元格日期(参数：毫秒)
function format_date(value,row,index){
	if(value){
		return new Date(parseInt(value)).zznode_format("yyyy-MM-dd");
	}
	
	return value;
}
//表格-格式化单元格月日(参数：毫秒)
function format_MonthDay(value,row,index){
	if(value){
		return new Date(parseInt(value)).zznode_format("MM-dd");
	}
	
	return value;
}
//表格-格式化单元格提示信息  
function format_tooltip(value,row,index){ 
	if(value){
		return '<span title="' + value + '">' + value + '</span>';  
	}
	
	return value;
}
//表格-格式化单元格工单编号链接
function format_xngj_sheetLink(value,row,index){
	if(value){
		var url='http://10.101.214.131:8080/eoms35/sheet/commonfault/commonfault.do?method=showHistoryPage&type=interface&userTreeName=Y2VzaGkx&app=app&sheetNo='+value;
	    return '<span title="' + value + '">' +'<a href="' + url + '" target="_blank" style="text-decoration:none;">' + value + '</a>' + '</span>'; 
	}
	
	return value;
}
//表格-格式化数值，保留1位小数(参数：Number)
function format_number_1(value,row,index){
	if(value!=null){
		if(typeof(value) == "string"){
			value = parseFloat(value);
		}

		return value.toFixed(1);
	}
	
	return value;
}
//表格-格式化数值，保留2位小数(参数：Number)
function format_number_2(value,row,index){
	if(value!=null){
		if(typeof(value) == "string"){
			value = parseFloat(value);
		}
		
		return value.toFixed(2);
	}
	
	return value;
}
//表格-格式化数值，保留3位小数(参数：Number)
function format_number_3(value,row,index){
	if(value!=null){
		if(typeof(value) == "string"){
			value = parseFloat(value);
		}
		
		return value.toFixed(3);
	}
	
	return value;
}

var loadExcelImp; //进度条
var includeExcelFileSuffixs=['.xls','.xlsx']; //有效excel文件后缀名
/**
 * ajax方式导入excel文件
 * 
 * @param linkBtn linkbutton按钮
 * @param url 导入请求URL
 * @param param 导入请求参数
 * @param callbackFunc 导入完成后回调函数
 */
function ajaxUploadExcel(linkBtn, url, param, callbackFunc) {
	if(!url || !linkBtn) return;
		
	/*调用ajax文件上传组件*/
    new AjaxUpload($(linkBtn).get(0), {  
    	action: url,  
        data: param,  
        name: 'uploadExcelFile', 
        responseType: "json",
        onSubmit: function(fileName, fileExt) {
        	var fileSuffix = fileName.substring(fileName.lastIndexOf('.'), fileName.length).toLowerCase();
        	if(jQuery.inArray(fileSuffix, includeExcelFileSuffixs)==-1){
        		$.messager.alert('提示信息',"请选择excel文件！",'error',function(){});
    			return false;
    		}
        	
        	$(linkBtn).linkbutton('disable');
        	loadExcelImp = layer.load();
        },  
        onComplete: function(fileName, response) {
        	layer.close(loadExcelImp);
        	$(linkBtn).linkbutton('enable');
        	
        	if(callbackFunc && typeof(callbackFunc) == 'function'){
				callbackFunc(response);
			}
        }  
    });  
}

//设置组件是否可用
function setupDisabled(context, isDisabled) {
	if (context && $(context).size() > 0) {
		$("input[type!='hidden'][type='text']", $(context)).prop("readonly",isDisabled);
		$("input[type!='hidden'][type!='text']", $(context)).prop("disabled",isDisabled);
		$("textarea", $(context)).prop("readonly", isDisabled);
		$("select", $(context)).prop("disabled", isDisabled);
	}
}

//默认弹出框配置
var defaultDialogOption ={
	title: '我的标题',
	msg: '', //弹出框内容：支持html和js
	showType: 'show',
	showSpeed: 600,
	modal: true,
	width: 800,
	height: 400,
	timeout: 0,//手动关闭
	onOpen: null,//无参回调函数
	onClose: null,//无参回调函数
	style: {},//弹出框样式:默认居中
	id: "_defaultDialogId"//弹出框ID标识
};
//打开对话框
var jqDialogMap = {
	close: function(id){
		if(!id) {
			id = defaultDialogOption.id;
		}
		jqDialogMap[id].window('close');
	}
};
function openDialog(url, args, dialogOption){
	//自定义弹出框配置
	var option = $.extend({}, defaultDialogOption, dialogOption);
	//不能重复弹出对话框
	var isExist = false;
	$.each(jqDialogMap, function(i,n){
		if(i == option.id){
			isExist = true;
			return false;
		}
	});
	if(!option.id || isExist){
		return;
	}else{
		jqDialogMap[option.id] = null;
		//绑定回调函数
		delete option.onOpen;
		option.onOpen = function (){
			if(typeof dialogOption.onOpen == "function"){
				dialogOption.onOpen();
			}
		};
		//绑定回调函数
		delete option.onClose;
		option.onClose = function(){
			delete jqDialogMap[$(this).prop("id")];
			if(typeof dialogOption.onClose == "function"){
				dialogOption.onClose();
			}
		};
	}
	//打开弹出框架界面
	$.ajax({
		url : url,
		data : args,
		type : "POST",
		dataType : "html",
		success : function(result) {
			option.msg = result;
			jqDialogMap[option.id] = $.messager.show(option);
		}
	});
}

//下载附件
function download(url) {
	var myframe = $('<iframe hidden="hidden" download="Y" height="0px" width="0px" style="display:none;"></iframe>');
	myframe.attr({
		"src" : url
	});
	myframe.appendTo(document.body);
}

//项目管理--选择项目
function pm_selectProject(callbackFun){
	var url = ctx+"/projectMgr/projectMaintenance";
	var args = {source:"selectProject"};
	var option = {title:"选择项目", width:1024, height:550};
	openDialog(url, args, option);
	
	$(window).unbind("pm_selectProject");
	$(window).one("pm_selectProject", {"callbackFun":callbackFun}, function(event, selectProjectId){
		$.cookie("pm_selectProjectId", selectProjectId, {expires:365});
		if(typeof event.data.callbackFun == 'function'){
			callbackFun();
		};
		return false;
	}); 
}

//excel报表下载
function excelReortDownload(tableId, reportConfigId){
	function appendUrlParam(url, name, value) {
		if(url && name){
			if(!value) value = "";
			
			if(url.lastIndexOf("?")==-1){
				url+= "?"+name+"="+encodeURIComponent(value);
			}else if(url.lastIndexOf("?")==url.length-1 || url.lastIndexOf("&")==url.length-1){
				url+= name+"="+encodeURIComponent(value);
			}else {
				url+= "&"+name+"="+encodeURIComponent(value);
			}
		}

		return url;
	}
	
	var paging = $('#'+tableId).datagrid("getPager").data("pagination" ).options;
	var args = $('#'+tableId).datagrid("options").queryParams;
	var url = $('#'+tableId).datagrid("options").url;
	if(paging.total>50000){
		$.messager.alert('提示信息',"下载数据大于50000行，请分批次下载！",'error',function(){});
		return;
	}
	//设置参数
	url = appendUrlParam(url, "reportConfigId", reportConfigId);
	url = appendUrlParam(url, "page", 1);
	url = appendUrlParam(url, "rows", paging.total?paging.total:200);
	$.each(args, function(key, value) {
		url = appendUrlParam(url, key, value);
	});
	download(url);
}
