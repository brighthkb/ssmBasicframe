;(function($){

  var xSlider = function(el, userConfig) {

    var _this = this;
    this.el = el;

    // 参数配置
    this.userConfig = userConfig;
    this.config = {
      w: this.el.width(),
      speed: 3000
    };
    if(userConfig != null) {
      $.extend(this.config,this.userConfig);
    };

    // 保存查找dom元素
    var slider_img = this.el.children('.slider-img');
    var slider_img_ul = slider_img.children('ul');
    var slider_img_ul_li = slider_img_ul.children('li');
    
    var tmpLeft = - slider_img_ul_li.width() * slider_img_ul_li.length;
    
    if(slider_img_ul_li.length > 2){
    	slider_img_ul_li.eq(0).clone().appendTo(slider_img_ul);
    	slider_img_ul_li.eq(1).clone().appendTo(slider_img_ul);
    	slider_img_ul_li = slider_img_ul.children('li');
    }

    var slider_img_length = slider_img_ul_li.length;
    var slider_img_width = slider_img_ul_li.width() * slider_img_length;

    // 初始化默认显示图片位置
    slider_img_ul.css('left', 0);
    slider_img_ul.css('width', slider_img_width);
    
    function donghua(){
      if(_this.el.parent().is(':hidden')){
        _this.stop();
        return;
      }
      if(slider_img_ul[0].offsetLeft < tmpLeft){
        _this.stop();
        slider_img_ul.css('left', 0);
      }
      slider_img_ul.animate({left:'-=1px'}, _this.config.speed,'linear', donghua);
    }

    // 停止计时器
    this.stop = function(){
      slider_img_ul.stop(true, false);
    };
    
    // 启动计时器
    this.start = function(){
      _this.stop();
      donghua();
    };
    
    el.hover(
      function () {
        _this.stop();
      },
      function () {
        _this.start();
      }
    );
    
  }; // --end-- xSlider

  $.fn.extend({
    xSlider: function(config) {
      return new xSlider($(this), config);
    }
  });

})(jQuery);
