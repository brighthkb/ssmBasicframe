/**
 * linkbutton方法扩展
 */
$.extend($.fn.linkbutton.methods, {
    /**
	 * 激活选项（覆盖重写）
	 */
    enable: function(jq){
        return jq.each(function(){
            var state = $.data(this, 'linkbutton');
            if ($(this).hasClass('l-btn-disabled')) {
                var itemData = state._eventsStore;
                // 恢复超链接
                if (itemData.href) {
                    $(this).attr("href", itemData.href);
                }
                // 回复点击事件
                if (itemData.onclicks) {
                    for (var j = 0; j < itemData.onclicks.length; j++) {
                        $(this).bind('click', itemData.onclicks[j]);
                    }
                }
                // 设置target为null，清空存储的事件处理程序
                itemData.target = null;
                itemData.onclicks = [];
                $(this).removeClass('l-btn-disabled');
            }
        });
    },
    /**
	 * 禁用选项（覆盖重写）
	 */
    disable: function(jq){
        return jq.each(function(){
            var state = $.data(this, 'linkbutton');
            if (!state._eventsStore)
                state._eventsStore = {};
            if (!$(this).hasClass('l-btn-disabled')) {
                var eventsStore = {};
                eventsStore.target = this;
                eventsStore.onclicks = [];
                // 处理超链接
                var strHref = $(this).attr("href");
                if (strHref) {
                    eventsStore.href = strHref;
                    $(this).attr("href", "javascript:void(0)");
                }
                // 处理直接耦合绑定到onclick属性上的事件
                var onclickStr = $(this).attr("onclick");
                if (onclickStr && onclickStr != "") {
                    eventsStore.onclicks[eventsStore.onclicks.length] = new Function(onclickStr);
                    $(this).attr("onclick", "");
                }
                // 处理使用jquery绑定的事件
                var eventDatas = $(this).data("events") || $._data(this, 'events');
                if (eventDatas["click"]) {
                    var eventData = eventDatas["click"];
                    for (var i = 0; i < eventData.length; i++) {
                        if (eventData[i].namespace != "menu") {
                            eventsStore.onclicks[eventsStore.onclicks.length] = eventData[i]["handler"];
                            $(this).unbind('click', eventData[i]["handler"]);
                            i--;
                        }
                    }
                }
                state._eventsStore = eventsStore;
                $(this).addClass('l-btn-disabled');
            }
        });
    }
});

/**
 * treegrid方法扩展 
 * 1、扩展列格式化函数参数formatter(value,row,rowIndex,colIndex,fieldName)
 * 2、列字段支持嵌套对象绑定
 */
$.extend($.fn.treegrid.defaults.view, {
	/**
	 * 表格行渲染（覆盖重写）
	 */
	renderRow:function(_f7,_f8,_f9,_fa,row){
		var _fb=$.data(_f7,"treegrid");
		var _fc=_fb.options;
		var cc=[];
		if(_f9&&_fc.rownumbers){
		cc.push("<td class=\"datagrid-td-rownumber\"><div class=\"datagrid-cell-rownumber\">0</div></td>");
		}
		for(var i=0;i<_f8.length;i++){
		var _fd=_f8[i];
		var col=$(_f7).datagrid("getColumnOption",_fd);
		if(col){
		var css=col.styler?(col.styler(row[_fd],row)||""):"";
		var cs=this.getStyleValue(css);
		var cls=cs.c?"class=\""+cs.c+"\"":"";
		var _fe=col.hidden?"style=\"display:none;"+cs.s+"\"":(cs.s?"style=\""+cs.s+"\"":"");
		cc.push("<td field=\""+_fd+"\" "+cls+" "+_fe+">");
		var _fe="";
		if(!col.checkbox){
		if(col.align){
		_fe+="text-align:"+col.align+";";
		}
		if(!_fc.nowrap){
		_fe+="white-space:normal;height:auto;";
		}else{
		if(_fc.autoRowHeight){
		_fe+="height:auto;";
		}
		}
		}
		cc.push("<div style=\""+_fe+"\" ");
		if(col.checkbox){
		cc.push("class=\"datagrid-cell-check ");
		}else{
		cc.push("class=\"datagrid-cell "+col.cellClass);
		}
		cc.push("\">");
		if(col.checkbox){
		if(row.checked){
		cc.push("<input type=\"checkbox\" checked=\"checked\"");
		}else{
		cc.push("<input type=\"checkbox\"");
		}
		cc.push(" name=\""+_fd+"\" value=\""+(row[_fd]!=undefined?row[_fd]:"")+"\">");
		}else{
		var val=null;
		//--start--
		var fieldSp = _fd.split(".");
        var dta = row[fieldSp[0]];
        for (var jj = 1; jj < fieldSp.length; jj++) {
        	if(dta){
        		dta = dta[fieldSp[jj]];
        	}
        }
		if(col.formatter){
			val=col.formatter(dta,row,_fa,i,_fd);
		}else{
			val=dta;
		}
		//--end--
		if(_fd==_fc.treeField){
		for(var j=0;j<_fa;j++){
		cc.push("<span class=\"tree-indent\"></span>");
		}
		if(row.state=="closed"){
		cc.push("<span class=\"tree-hit tree-collapsed\"></span>");
		cc.push("<span class=\"tree-icon tree-folder "+(row.iconCls?row.iconCls:"")+"\"></span>");
		}else{
		if(row.children&&row.children.length){
		cc.push("<span class=\"tree-hit tree-expanded\"></span>");
		cc.push("<span class=\"tree-icon tree-folder tree-folder-open "+(row.iconCls?row.iconCls:"")+"\"></span>");
		}else{
		cc.push("<span class=\"tree-indent\"></span>");
		cc.push("<span class=\"tree-icon tree-file "+(row.iconCls?row.iconCls:"")+"\"></span>");
		}
		}
		if(this.hasCheckbox(_f7,row)){
		var _ff=0;
		var crow=$.easyui.getArrayItem(_fb.checkedRows,_fc.idField,row[_fc.idField]);
		if(crow){
		_ff=crow.checkState=="checked"?1:2;
		}else{
		var prow=$.easyui.getArrayItem(_fb.checkedRows,_fc.idField,row._parentId);
		if(prow&&prow.checkState=="checked"&&_fc.cascadeCheck){
		_ff=1;
		row.checked=true;
		$.easyui.addArrayItem(_fb.checkedRows,_fc.idField,row);
		}else{
		if(row.checked){
		$.easyui.addArrayItem(_fb.tmpIds,row[_fc.idField]);
		}
		}
		row.checkState=_ff?"checked":"unchecked";
		}
		cc.push("<span class=\"tree-checkbox tree-checkbox"+_ff+"\"></span>");
		}else{
		row.checkState=undefined;
		row.checked=undefined;
		}
		cc.push("<span class=\"tree-title\">"+val+"</span>");
		}else{
		cc.push(val);
		}
		}
		cc.push("</div>");
		cc.push("</td>");
		}
		}
		return cc.join("");
		}
});

/**
 * datagrid方法扩展 
 * 1、扩展列格式化函数参数formatter(value,row,rowIndex,colIndex,fieldName)
 * 2、列字段支持嵌套对象绑定
 */
$.extend($.fn.datagrid.defaults.view, {
	/**
	 * 表格行渲染（覆盖重写）
	 */
	renderRow:function(_21c,_21d,_21e,_21f,_220){
		var opts=$.data(_21c,"datagrid").options;
		var cc=[];
		if(_21e&&opts.rownumbers){
		var _221=_21f+1;
		if(opts.pagination){
		_221+=(opts.pageNumber-1)*opts.pageSize;
		}
		cc.push("<td class=\"datagrid-td-rownumber\"><div class=\"datagrid-cell-rownumber\">"+_221+"</div></td>");
		}
		for(var i=0;i<_21d.length;i++){
		var _222=_21d[i];
		var col=$(_21c).datagrid("getColumnOption",_222);
		if(col){
		//--start--
		var fieldSp = _222.split(".");
		var _223=_220[fieldSp[0]];
		for (var jj = 1; jj < fieldSp.length; jj++) {
        	if(_223){
        		_223 = _223[fieldSp[jj]];
        	}
        }
		//--end--
		var css=col.styler?(col.styler(_223,_220,_21f)||""):"";
		var cs=this.getStyleValue(css);
		var cls=cs.c?"class=\""+cs.c+"\"":"";
		var _224=col.hidden?"style=\"display:none;"+cs.s+"\"":(cs.s?"style=\""+cs.s+"\"":"");
		cc.push("<td field=\""+_222+"\" "+cls+" "+_224+">");
		var _224="";
		if(!col.checkbox){
		if(col.align){
		_224+="text-align:"+col.align+";";
		}
		if(!opts.nowrap){
		_224+="white-space:normal;height:auto;";
		}else{
		if(opts.autoRowHeight){
		_224+="height:auto;";
		}
		}
		}
		cc.push("<div style=\""+_224+"\" ");
		cc.push(col.checkbox?"class=\"datagrid-cell-check\"":"class=\"datagrid-cell "+col.cellClass+"\"");
		cc.push(">");
		if(col.checkbox){
		cc.push("<input type=\"checkbox\" "+(_220.checked?"checked=\"checked\"":""));
		cc.push(" name=\""+_222+"\" value=\""+(_223!=undefined?_223:"")+"\">");
		}else{
		if(col.formatter){
		//--start--
		cc.push(col.formatter(_223,_220,_21f,i,_222));
		//--end--
		}else{
		cc.push(_223);
		}
		}
		cc.push("</div>");
		cc.push("</td>");
		}
		}
		return cc.join("");
		}
});

/**
 * datagrid方法扩展 
 * 1、扩展表格单元格行合并方法
 * 2、使用方法：$('#grid).datagrid("autoMergeCells", ['field1', 'field2','field3',……]);
 */
$.extend($.fn.datagrid.methods, {
	/**
	 * 表格单元格行合并(新增方法)
	 */
    autoMergeCells: function (jq, fields) {
        return jq.each(function () {
            var target = $(this);
            if (!fields) {
                fields = target.datagrid("getColumnFields");
            }

            var rows = target.datagrid("getRows");
            var i = 0, j = 0, temp = {};
            for (i; i < rows.length; i++) {
                var row = rows[i];
                j = 0;
                for (j; j < fields.length; j++) {
                    var field = fields[j];
                    var tf = temp[field];
                    if (!tf) {
                        tf = temp[field] = {};
                        tf[row[field]] = [i];
                    } else {
                        var tfv = tf[row[field]];
                        if (tfv) {
                            tfv.push(i);
                        } else {
                            tfv = tf[row[field]] = [i];
                        }
                    }
                }
            }

            $.each(temp, function (field, colunm) {
                $.each(colunm, function () {
                    var group = this;
                    if (group.length > 1) {
                        var before, after, megerIndex = group[0];
                        for (var i = 0; i < group.length; i++) {
                            before = group[i];
                            after = group[i + 1];
                            if (after && (after - before) == 1) {
                                continue;
                            }

                            var rowspan = before - megerIndex + 1;
                            if (rowspan > 1) {
                                target.datagrid('mergeCells', {
                                    index: megerIndex,
                                    field: field,
                                    rowspan: rowspan
                                });
                            }

                            if (after && (after - before) != 1) {
                                megerIndex = after;
                            }
                        }
                    }
                });
            });
        });
    }
});