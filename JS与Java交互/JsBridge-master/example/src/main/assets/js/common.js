$(function(){
	var oImgList=$(".imgList")
			
			for(var i=0;i<oImgList.length;i++){
				if(i%4!=0){
					oImgList.eq(i).css('margin-left','2.3%')
				}
			}
				
	            $("[lazyLoadSrc]").YdxLazyLoad({
	                onShow: function () {
	                    $(this).parent().next().hide()
	                }
	            });

	        });