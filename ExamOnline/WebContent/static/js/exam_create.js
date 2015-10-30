var basePath = $("#basePath").val();
var id = $("#null_or_not").val();
    if(id <= 0){
        $("input").each(function(){
             $(this).val("");
         });
    }

    $("input[type=text]").change(function(){
        $('input[type=text]:not(:disabled)').each(function(){
            var str = $(this).val();
            str = str.replace(/(^\s+)|(\s+$)/g,"");
            var  entry = { "'": "&apos;", '"': '&quot;', '<': '&lt;', '>': '&gt;' };
            str = str.replace(/(['")-><&\\\/\.])/g, function ($0) { return entry[$0] || $0; });
            $(this).val(str);
        });
    });
    $(".handle_submit_create").click(function() {
        var isSubmitForm = true;
        $(".exam_name_input").each(function(){
            if ( ! $(this).val()) {
                isSubmitForm = false;
                $(this).attr('placeholder', 'Must be write.');
            }
        });
        $(".effective_time_input").each(function(){
            if ( ! $(this).val()) {
                isSubmitForm = false;
                $(this).attr('placeholder', 'select the date');
            }
        });
//        $(".effective_time_input_two").each(function(){
//            if ( ! $(this).val()) {
//                isSubmitForm = false;
//                $(this).attr('placeholder', '00：00');
//            }
//        });
        $(".duration_input").each(function() {
            if ( ! $(".duration_input").val()) {
                isSubmitForm = false;
                $(this).attr('placeholder', 'Must be write.');
            }
        });
        $(".setting_input").each(function() {
            if ( ! $(this).val()) {
                isSubmitForm = false;
                $(this).attr('placeholder', 'Must be write.');
            }
        });
        if ( ! isSubmitForm) {
            $("#flashMessage").css("display", "block");
            $("#flashMessage").fadeOut(4000);
        }
        if (isSubmitForm) {
            var date = $(".effective_time_input").val();
            var time = $(".effective_time_input_two").val();
            if(date || time){
                var dateTime = date + " " + time + ":00";
                $(".dateTime").val(dateTime);
                $("form").submit();
            }else{
//                $(".effective_time_input").css("border","1px solid red");
//                $(".effective_time_input_two").css("border","1px solid red");
                isSubmitForm = false;
            }
        }
    });
    $(".handle_submit_cancel").click(function() {
        location.href = basePath + "exam/list?pageNo=1";
    });