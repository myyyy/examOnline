var totalPages = $("#totalPages").val();
var pageNo = $("#pageNo").val();
    $("input[type=text]").change(function(){
        $('input[type=text]:not(:disabled)').each(function(){
            var str = $(this).val();
            str = str.replace(/(^\s+)|(\s+$)/g,"");
            var  entry = { "'": "&apos;", '"': '&quot;', '<': '&lt;', '>': '&gt;' };
            str = str.replace(/(['")-><&\\\/\.])/g, function ($0) { return entry[$0] || $0; });
            $(this).val(str);
        });
    });
    $(".main_box_left_create").hover(function(){
        $(".main_box_left_create").css("background","#2E4358");
        $(".main_box_left_create a").css("color","#FFF");
        $(".main_box_left_list").css("background","#FFF");
        $(".main_box_left_list a").css("color","#2E4358");
        },function(){
            $(".main_box_left_create").css("background","#FFF");
            $(".main_box_left_create a").css("color","#2E4358");
            $(".main_box_left_list").css("background","#2E4358");
            $(".main_box_left_list a").css("color","#FFF");
    });
    if (totalPages > 4) {
        for (i = 1; i < 4;i++) {
             if( i == pageNo){
                 var createObj = $("<label style='color: #FE9901;' id='"+i+"'>"+i+"</label>");
             } else {
                 var createObj = $("<label id='"+i+"'>"+i+"</label>");
             }
             $("#pageNumb").append(createObj);
        }
        if ( pageNo > 3 && pageNo !=totalPages) {
            $("#1").text(pageNo-2);
            $("#2").text(pageNo-1);
            $("#3").text(pageNo);
            $("#3").css("color","#FE8001");
        }
        $("#pageNumb").append("<label>"+"..."+"</label>");
        if(pageNo == totalPages){
        	 $("#1").text(pageNo-3);
             $("#2").text(pageNo-2);
             $("#3").text(pageNo-1);
            $("#pageNumb").append("<label style='color: #FE9901;'>"+totalPages+"</label>");
        }else{
            $("#pageNumb").append("<label>"+totalPages+"</label>");
        }
    } else {
        for(var i=1;i <=totalPages;i++){
            if( i == pageNo){
            	var createObj = $("<label style='color: chocolate;'>"+i+"</label>");
            } else {
                var createObj = $("<label id='"+i+"'>"+i+"</label>");
            }
             $("#pageNumb").append(createObj);
        }
     };
