/** 空间参考地理坐标系 */
var spatialReference = {wkid: 4326};

/** 地市地理信息【地市中心坐标、地市地理范围】 */
var cityGisInfo = [
	{city: "四川", center: [102.94, 30.13], extend: {xmin: null, ymin: null, xmax: null, ymax: null, spatialReference: spatialReference}},
    {city: "资阳", center: [105.01, 30.16]}
];

/** 获取地市地理相关信息 */
function getCityGisInfo(city, fieldName){
	for(var i=0; i<cityGisInfo.length; i++){
		if(cityGisInfo[i].city == city){
			return cityGisInfo[i][fieldName];
		}
	}
	
	return cityGisInfo[0][fieldName];
}



/**
 * @author 陈涛
 * @describe 地图操作API
 */
;(function($) {
	/** 地图上下文 */
	var MapContext = function(map, config){
		var _this = this;
	    this.map = map;//地图对象
	    this.config = config;//配置参数
		this.plate = null;	//当前场景板块

		/* 图象标记默认设置 */
		var defaultPictureMarkerOption = {
			iconUrl: null, //标记icon地址
			iconWidth: 16, //标记icon宽度
			iconHeight: 16, //标记icon高度
			long: null, //标记经度 
			lat: null, //标记纬度
			dataAttr: {}, //数据属性，json标准格式对象
			title: " ", //标记标题
			content: null, //标记内容，支持html标签和模板取值。注意：JSP的EL表达式需要转义
			infoWindowPopupType: 0, //infoWindow弹出方式【0：click方式；1：鼠标悬停】
			showFunc: null, //显示InfoWindow弹出框时执行回调函数
			closeFun: null //关闭InfoWindow弹出框时执行回调函数
		};
		/* 在地图上添加图形标记 */
		this.addPictureMarker = function(pictureMarkerOption) {
			var option = {};
			jQuery.extend(option, defaultPictureMarkerOption, pictureMarkerOption);
			
		    //创建图形标记
	        var symbol = new esri.symbol.PictureMarkerSymbol(option.iconUrl, option.iconWidth, option.iconHeight);
			//添加标记
	        _this.addMarker(option.long, option.lat, symbol, option);
	    };
		
		/* 文本标记默认设置 */
		var defaultTextMarkerOption = {
			text: null, //标记文本
			color: "black", //标记颜色
			textAlign: "center", //标记水平对齐
			verticalAlign: "middle", //标记垂直对齐
			fontSize: "12px",  //标记字体大小
			fontWeight: "normal", //标记字体加粗
			fontFamily: "微软雅黑", //标记字体
			long: null, //标记经度 
			lat: null, //标记纬度
			dataAttr: {}, //数据属性，json标准格式对象
			title: " ", //标记标题
			content: null, //标记内容，支持html标签和模板取值。注意：JSP的EL表达式需要转义	
			infoWindowPopupType: 0, //infoWindow弹出方式【0：click方式；1：鼠标悬停】
			showFunc: null, //显示InfoWindow弹出框时执行回调函数
			closeFun: null //关闭InfoWindow弹出框时执行回调函数
		};
		/* 在地图上添加文本标记 */
		this.addTextMarker = function(textMarkerOption) {
			var option = {};
			jQuery.extend(option, defaultTextMarkerOption, textMarkerOption);

		  	//创建字体
			var font = new esri.symbol.Font();
			font.setSize(option.fontSize);
			font.setWeight(option.fontWeight);
			font.setFamily(option.fontFamily);
			//创建颜色
			var color = new esri.Color(option.color);
			//创建文本标记
			var symbol = new esri.symbol.TextSymbol(option.text, font, color);
			symbol.setHorizontalAlignment(option.textAlign);
			symbol.setVerticalAlignment(option.verticalAlign);	
			//添加标记
			_this.addMarker(option.long, option.lat, symbol, option);
	    };
		
		/* InfoWindow弹出框默认设置 */
		var defaultInfoWindowOption = {
			long: null, //标记经度 
			lat: null, //标记纬度
			dataAttr: {}, //数据属性，json标准格式对象
			title: " ", //标记标题
			content: null, //标记内容，支持html标签和模板取值。注意：JSP的EL表达式需要转义
			showFunc: null, //显示InfoWindow弹出框时执行回调函数
			closeFun: null //关闭InfoWindow弹出框时执行回调函数
		};
		/* 显示InfoWindow弹出框 */
		this.showInfoWindow = function(infoWindowOption){
			var option = {};
			jQuery.extend(option, defaultInfoWindowOption, infoWindowOption);
			
			//标题
			_this.map.infoWindow.setTitle(option.title);
			//内容【支持JS模板语言】
			_this.map.infoWindow.setContent($.processTemplateToText($.createTemplate(option.content), option.dataAttr));
			//位置
		    var point = new esri.geometry.Point(option.long, option.lat);
		    _this.map.infoWindow.show(point);
	      	//显示InfoWindow弹出框时执行回调函数
	        if(typeof(option.showFunc)=="function"){
	    	   option.showFunc(option.dataAttr);
		    } 
	      	//给InfoWindow弹出框的关闭按钮绑定一次性click事件，用于触发InfoWindow hide事件【默认关闭没有触发hide事件】
	      	$("#"+_this.config.mapDivId+" div.esriPopup .close").unbind("click").one("click", function(e){
				_this.closeInfoWindow();
		    });
	      	//保存InfoWindow弹出框设置
		    _this.map.infoWindow.infoWindowOption = option;
		};
		
		/* 关闭InfoWindow弹出框 */
		this.closeInfoWindow = function (){
			_this.map.infoWindow.hide();
		};
		
		/* 在地图上添加自定义标记 */
		this.addMarker = function(long, lat, symbol, option){
			var This = this;
			//创建【“GraphicsLayer_001”样式】图层
			if(_this.getLayer("GraphicsLayer_001") == null){
				var markerGraphicsLayer = new esri.layers.GraphicsLayer({id: "GraphicsLayer_001", className: "GraphicsLayer_001"});
				_this.map.addLayer(markerGraphicsLayer);
				//绑定事件
				dojo.connect(markerGraphicsLayer, "onMouseDown", function(e){
					var type = e.graphic.attributes.dataAttr.ICONTYPE;
					if(!e) e = window.event;
					var pageX = e.pageX;
					var pageY = e.pageY;
					switch(type){
						case '基站' :
							if(e.button == 2) {
								if(This.plate == "xq"){
									$("#rightMenu").css({
										"left" : pageX + 5 + 'px',
										"top"  : pageY + 5 + "px"
									}).show().data("dataAttr",e.graphic.attributes);
								}else{
									$("#rightMenu_2").css({
										"left" : pageX + 5 + 'px',
										"top"  : pageY + 5 + "px"
									}).show().data("dataAttr",e.graphic.attributes);
								}
								e.stopPropagation();
								$(document).on("contextmenu",function(e){
									return false;						
								});
							}
						;break;
						case '通勤车' :
							var json = e.graphic.attributes;
							var mapContainer = $("#"+_this.config.mapDivId);
							$("#carRightMenu").remove();
							var oDiv = $("<div id='carRightMenu'></div>").css({
								"position" : "absolute",
								"z-index" : "999",
								"background" : "red",
								"left" : pageX + 5 + 'px',
								"top"  : pageY + 5 + "px"
							}).data("dataAttr",json);
							oDiv.load(ctx + "/sceneMonitor/emergency/getRightMouseMenu",function(){
								oDiv.find("#rightMouseMenu").show();
							});
							mapContainer.append(oDiv);
			      			e.stopPropagation();
							$(document).on("contextmenu",function(e){
								return false;						
							})
						break;
					}
				});
				
		        dojo.connect(markerGraphicsLayer, "onMouseOver", function(e){
		        	var g = e.graphic;
		        	if(g.attributes.infoWindowPopupType == 1){
		        		_this.showInfoWindow(g.attributes);
		        	}
				});
				dojo.connect(markerGraphicsLayer, "onMouseOut", function(e){
					var g = e.graphic;
					if(g.attributes.infoWindowPopupType == 1){
						_this.closeInfoWindow();
					}
				});
				dojo.connect(markerGraphicsLayer, "onClick", function(e){
		        	var g = e.graphic;
		        	if(g.attributes.infoWindowPopupType == 0){
		        		_this.showInfoWindow(g.attributes);
		        	}
				});
				dojo.connect(map.infoWindow, "hide", function(){
					var closeFun = _this.map.infoWindow.infoWindowOption?_this.map.infoWindow.infoWindowOption.closeFun:null;
					var dataAttr = _this.map.infoWindow.infoWindowOption?_this.map.infoWindow.infoWindowOption.dataAttr:null;
					delete _this.map.infoWindow.infoWindowOption;
					if(typeof(closeFun) == "function"){
			        	closeFun(dataAttr);
				    }
				});
			}
			//创建【“GraphicsLayer_002”样式】图层
			if(_this.getLayer("GraphicsLayer_002") == null){
				var markerGraphicsLayer = new esri.layers.GraphicsLayer({id: "GraphicsLayer_002", className: "GraphicsLayer_002"});
				_this.map.addLayer(markerGraphicsLayer);
			}
			
			//创建位置
		    var point = new esri.geometry.Point(long, lat);
			//创建模版
	        var infoTemplate = null;
	        if(option.content){
	        	//infoTemplate = new esri.InfoTemplate({title: option.title, content: option.content});
	        }
	      	//创建图象
	        var graphic = new esri.Graphic(point, symbol, option, infoTemplate);
	      	//把图象添加到刚才创建的图层上
	        if(option.content){
	        	_this.getLayer("GraphicsLayer_001").add(graphic);
	        }else{
	        	_this.getLayer("GraphicsLayer_002").add(graphic);
	        }
		};
		
		/* 地图移动和放大缩小 */
		this.centerAndZoom = function(){
			var long, lat, zoom;
			if(arguments.length == 1){
				zoom = arguments[0];
			}else{
				long = arguments[0];
				lat = arguments[1];
				zoom = arguments[2];
			}
			
			if(long && lat){
			    var point = new esri.geometry.Point(long, lat);
			    _this.map.centerAt(point);
			}
			
			if(typeof(zoom) == "number"){
				//这儿有问题，获取值都是-1
				//if(zoom<map.getMinZoom() || zoom>map.getMaxZoom()){
				//	zoom = map.getZoom();
				//}
				_this.map.setZoom(zoom);
			}
		};

		/* 获取图层 */
		this.getLayer = function(layerId){
			return _this.map.getLayer(layerId);
		};
		
		/* 清除图层标记 */
		this.clearMarker = function(layerId){
			var layerIds = null;
			if(layerId){
				layerIds = [layerId];
			}else{
				layerIds = _this.map.graphicsLayerIds;
			}
			
			if(layerIds && layerIds.length>0){
				$.each(layerIds, function(i, n){
					_this.getLayer(n).clear();
				});
			}
		};
		
		/* 删除图层--功能报错 */
		this.removeLayer = function(layerId){
			_this.map.removeLayer(_this.getLayer(layerId));
		};
		
		/* 显示图层 */
		this.showLayer = function(layerId){
			_this.getLayer(layerId).show();
		};
		
		/* 隐藏图层 */
		this.hideLayer = function(layerId){
			_this.getLayer(layerId).hide();
		};
		
		/* 工具栏添加按钮 */
		this.addToolBtn = function(toolBtn){
			var mapContainer = $("#"+_this.config.mapDivId);
	      	var gisToolbar = $(".gisToolbar:visible", mapContainer);	      	
	      	//判断工具栏是否已加载并可见
	      	if(gisToolbar.size()!=1){
	      		console.warn("GIS工具栏未加载或者不可见");
	      		return false;
	      	}
	      	//已定义工具按钮，通过名称引用
			if(typeof(toolBtn)=="string"){
				if("zoomIn"==toolBtn){//放大
					toolBtn = {};
				}else if("zoomOut"==toolBtn){//缩小
					toolBtn = {};
				}else if("graphicsPanel"==toolBtn){//图层面板
					toolBtn = {title:"图层面板", iconUrl:ctx+"/static/common/style/sceneMonitor/images/sulv.png", onClick:function(e){
						_this.openGraphicsPanel(true);
					}};
				}else{
					console.warn("通过名称未找到已定义工具按钮");
					return false;
				}
			}
			//添加按钮
	      	gisToolbar.append('<div class="toolBtn" title="'+toolBtn.title+'"><img src="'+toolBtn.iconUrl+'"/></div>');
	      	if(typeof(toolBtn.onClick) == "function"){
	      		$(".toolBtn:last", gisToolbar).click(toolBtn.onClick);
	      	}
	      	
	      	return true;
		};
		
		/* 打开工具栏 */
		this.openToolbar = function(isOpen){
			var mapContainer = $("#"+_this.config.mapDivId);
	      	var gisToolbar = $(".gisToolbar", mapContainer);
	      	if(isOpen == true){
	      		if(gisToolbar.size()==0){
	      			mapContainer.append('<div class="easyui-draggable gisToolbar" title="可拖动工具栏"></div>');
			      	var mapLeft = mapContainer.offset().left;
			      	var mapTop = mapContainer.offset().top;
			      	var mapWidth = mapContainer.width();
			      	gisToolbar = $(".gisToolbar", mapContainer);//刷新JQuery对象
			      	gisToolbar.show().css({ left: mapLeft+(mapWidth/2)-(gisToolbar.width()/2), top: mapTop });
			      	$.parser.parse(mapContainer);
		      	}else{
		      		gisToolbar.show();
		      	}
      		}else{
      			gisToolbar.hide();
      		}
	      	
	      	return gisToolbar;//返回工具栏jQuery对象
		};
		
		/* 打开图层面板 */
		this.openGraphicsPanel = function(isOpen){
			var mapContainer = $("#"+_this.config.mapDivId);
	      	var graphicsPanel = $(".graphicsPanel", mapContainer);
	      	var plate = this.plate;
	      	if(isOpen == true){
	      		if(graphicsPanel.size()==0){
	      			if(plate == "xq"){
	      				mapContainer.append('<div class="easyui-draggable graphicsPanel" title="可拖动图层面板">'+
			      							'<div class="easyui-panel" title="图层面板" data-options="fit:true,closable:true,href:\''+ctx+'/gis/getEmergencyGisMapLayer?mapDivId='+_this.config.mapDivId+'\',onClose:function(){$(\'#'+_this.config.mapDivId+' .graphicsPanel\').hide();}"></div>'	
			      						+'</div>');
	      			}else{
	      				mapContainer.append('<div class="easyui-draggable graphicsPanel" title="可拖动图层面板">'+
			      							'<div class="easyui-panel" title="图层面板" data-options="fit:true,closable:true,href:\''+ctx+'/sceneMonitor/emergency/getEmergencyGisMapLayer?mapDivId='+_this.config.mapDivId+'\',onClose:function(){$(\'#'+_this.config.mapDivId+' .graphicsPanel\').hide();}"></div>'	
			      						+'</div>');
	      			}
	      			
			      	var mapLeft = mapContainer.offset().left;
			      	var mapTop = mapContainer.offset().top;
			      	var mapWidth = mapContainer.width();
			      	var mapHeight = mapContainer.height();
			      	graphicsPanel = $(".graphicsPanel", mapContainer);//刷新JQuery对象
			      	graphicsPanel.show().css({ left: mapLeft+mapWidth-graphicsPanel.width()-10, top: mapTop+10, height: mapHeight-20});
			      	$.parser.parse(mapContainer);
		      	}else{
		      		graphicsPanel.show();
		      		$(".easyui-panel", graphicsPanel).panel("open");
		      	}
      		}else{
      			graphicsPanel.hide();
      		}
	      	
	      	return graphicsPanel;//返回图例面板jQuery对象
		};
		
		/* 打开图例面板 */
		this.openLegendPanel = function(isOpen){
			var mapContainer = $("#"+_this.config.mapDivId);
	      	var legendPanel = $(".legendPanel", mapContainer);
	      	if(isOpen == true){
	      		if(legendPanel.size()==0){
			      	mapContainer.append('<div class="easyui-draggable legendPanel" title="可拖动图例面板"></div>');
			      	var mapLeft = mapContainer.offset().left;
			      	var mapTop = mapContainer.offset().top;
			      	var mapHeight = mapContainer.height();
			      	legendPanel = $(".legendPanel", mapContainer);//刷新JQuery对象
			      	legendPanel.show().css({ left: mapLeft+5, top: mapTop+mapHeight-legendPanel.height()-5});
			      	$.parser.parse(mapContainer);
		      	}else{
		      		legendPanel.show();
		      	}
      		}else{
      			legendPanel.hide();
      		}
	      	
	      	return legendPanel;//返回图例面板jQuery对象
		};
	};
	
	$.fn.extend({
		/** 初始化地图 */
		initMap: function(userConfig) {
			var _this = this;
			var mapContext = null;
			// 参数配置
			var config = {
				displayGisToolBar : false,
				gisToolBtns: null,
				city : null,
				completeFunc : null,
				zoom : 0,
				mapDivId : _this.get(0).id //【注：地图容器必须是div元素且id唯一】
			};
		    if(userConfig != null) {
		    	jQuery.extend(config, userConfig);
		    }
			
		    // 显示进度条
	    	var loadMapIndex = layer.load();
		    require([ "esri/map", "esri/SpatialReference", "esri/geometry/Extent",
		      		"esri/dijit/InfoWindow", "esri/layers/ArcGISDynamicMapServiceLayer",
		      		"esri/layers/ArcGISTiledMapServiceLayer", "esri/layers/GraphicsLayer",
		      		"esri/symbols/PictureMarkerSymbol", "esri/symbols/TextSymbol",
		      		"esri/geometry/Point", "esri/Color", "esri/symbols/Font",
		      		"dojo/dom-construct", "dojo/dom", "dojo/parser", "dojo/on",
		      		"dojo/domReady!" ], function(Map, SpatialReference, Extent, InfoWindow,
		      		ArcGISDynamicMapServiceLayer, ArcGISTiledMapServiceLayer,
		      		GraphicsLayer, PictureMarkerSymbol, TextSymbol, Point, Color, Font,
		      		domConstruct, dom, parser) {
		      	// 解析DOJO标记文档
		      	parser.parse();

		      	// 初始化地图
		      	var map = new Map(config.mapDivId, {
		      		zoom : config.zoom,
		      		center : getCityGisInfo(config.city, "center"),
		      		//extent : new Extent(getCityGisInfo(city, "extend")),
		      		//spatialReference : spatialReference,
		      		fitExtent : true,
		      		autoResize : true,
		      		logo : false,
		      		backgroundColor : "white",
		      		slider : true
		      	});
		      	// map.setMapCursor("pointer");
		      	
		      	// 加载切片地图
		      	var tiledMapLayer = new ArcGISTiledMapServiceLayer(tiledMapUrl);
		      	map.addLayer(tiledMapLayer);
		      	
		      	// 实例化地图上下文并缓存
		      	mapContext = new MapContext(map, config);
		      	mapContext.plate = userConfig.plate;
		      	$(_this).data("_mapContext", mapContext);
		      	
		      	// 初始化工具栏
		      	if(config.displayGisToolBar == true){
		      		mapContext.openToolbar(true);
		      		if(config.gisToolBtns && config.gisToolBtns.length>0){
			      		$.each(config.gisToolBtns, function(i, n){
			      			mapContext.addToolBtn(n);
			      		});
		      		}
		      	}
		      	
		      	// 初始化地图完成时执行回调函数
		      	if (typeof(config.completeFunc) == "function") {
		      		try {
		      			config.completeFunc(mapContext);
					} catch (e) {
						console.error(e);
					}
		      	}
		    });
		    // 关闭进度条
	      	layer.close(loadMapIndex);
			
			return mapContext;
		},
		/** 初始化地图 */
		getMapContext: function() {
			return $(this).data("_mapContext");
		}
	});
})(jQuery);