var basePath = $("#basePath").val();
var totalPages = $("#totalPages").val();
var pageNo = $("#pageNo").val();
var key = $("#keyWords").val();
var idAll = "";
var len = "";
var check = "";
$("#bar .head_href_text").css("background","#FFF");
$("#bar .head_href_text").css("color","#2E4358");
$(".bar_management_next").css("background","#D2DAE3");
$(".bar_management_next").css("color","#2E4358");
$(".bar_management").hover(function(){
    $("#bar .head_href_text").css("background","#D2DAE3");
    $("#bar .head_href_text").css("color","#2E4358");
    $(".bar_management_next").css("background","#FFF");
    $(".bar_management_next").css("color","#2E4358");
    },function(){
        $("#bar .head_href_text").css("background","#FFF");
        $("#bar .head_href_text").css("color","#2E4358");
        $(".bar_management_next").css("background","#D2DAE3");
        $(".bar_management_next").css("color","#2E4358");
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
        }
    });
    $(".pop_box_yes").click(function() {
        var queryString = location.search;
        console.log(queryString);
        location.href = basePath + "exam/delete?id=" + idAll + "&pageNo=" + pageNo + "&key=" + key;
    });
    $(".pop_box_no").click(function() {
        $("#deleteBox").css("display","none");
        $("#delete_yes").css("display","none");
        $("#delete_no").css("display","none");
    });
    $(".delete_img").click(function() {
        check = $(".delete_img");
        len = check.length;
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
    $(".jump").click(function() {
        var jumpPage;
        jumpPage = $("#WritePageNo").val();
        if (jumpPage > 0 && (jumpPage + "").indexOf(".") == -1) {
            if(jumpPage > parseInt(totalPages)){
               jumpPage = totalPages;
            }
            var queryString = location.search;
            console.log(queryString);
            location.href = basePath + "exam/list?pageNo=" + jumpPage + "&key=" ;
        } else {
            alert("Please input Int number.");
            $("#WritePageNo").val("");
         }
    });