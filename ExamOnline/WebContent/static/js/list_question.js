var basePath = $("#basePath").val();
var totalPages = $("#totalPages").val();
var pageNo = $("#pageNo").val();
var questionId = $(".questionId").val();
var key = $("#searchInput").val();
var keyPage = $("#keyWords").val();
var idAll = "";
var len = "";
var check = "";
    if(! keyPage){
        $("#searchInput").attr("placeholder", "Please input the key world");
    }else{
        $("#searchInput").val(keyPage);
    }
    $(".bar_management_next").hover(function(){
        $("#bar .head_href_text_next").css("background","#D2DAE3");
        $("#bar .head_href_text_next").css("color","#2E4358");
        $("#bar .head_href_text").css("background","#FFF");
        $("#bar .head_href_text").css("color","#2E4358");
        },function(){
             $("#bar .head_href_text_next").css("background","#FFF");
             $("#bar .head_href_text_next").css("color","#2E4358");
             $("#bar .head_href_text").css("background","#D2DAE3");
             $("#bar .head_href_text").css("color","#2E4358");
    });
    $("#selectAll").click(function() {
        if (this.checked == true) {
            $("[name='check']").prop("checked",true);
            $("[name='check']").each(function() {
                check = $(".delete_img");
                len = check.length;
            });
        } else {
            $("[name='check']").prop("checked",false) ;
            idAll = "";
            len = "";
            check = "";
        }
    });
    $(".pop_box_yes").click(function() {
        var queryString = location.search;
        console.log(queryString);
        location.href = basePath + "question/delete?id=" + idAll + "&pageNo=" + pageNo + "&key=" + key;
    });
    $(".pop_box_no").click(function() {
        $("#deleteBox").css("display","none");
        $("#delete_yes").css("display","none");
        $("#delete_no").css("display","none");
    });
    $(".delete_img").click(function() {
        check = $(".delete_img");
        len = check.length;
        if(this.checked == false){
            $('#selectAll').prop("checked",false);
        }
    });
    $(".suer_button").click(function() {
         for (var i = 0; i < len; i++) {
            if(check[i].checked == true) {
                idAll += check[i].value + ",";
             }
         }
        if ( ! idAll) {
            alert ("You must checkbox if want to delet Question.");
        } else {
            $("#deleteBox").css("display","block");
            $("#delete_yes").css("display","block");
            $("#delete_no").css("display","block");
            }
    });
    $(".search_input_img").click(function() {
        key = $("#searchInput").val();
        location.href = basePath + "question/list?key=" + key + "&pageNo=1" ;
        });
    $(".jump").click(function() {
        var jumpPage;
        jumpPage = $("#WritePageNo").val();
        if (jumpPage > 0 && (jumpPage + "").indexOf(".") == -1) {
            if(jumpPage > parseInt(totalPages)){
               jumpPage = totalPages;
            }
            var queryString = location.search;
            console.log(queryString);
            location.href = basePath + "question/list?pageNo=" + jumpPage + "&key=" + key;
        } else {
            alert("Please input Int number.");
            $("#WritePageNo").val("");
         }
    });
