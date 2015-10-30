var titel = $("#titel_hidden").val();
$(".question_titel_input").text(titel);
var basePath = $("#basePath").val();
    $(".handle_submit_create").click(function() {
        var isSubmitForm = true;
        $(".question_answer_input").each(function(){
            if ( ! $(this).val()) {
                isSubmitForm = false;
                $(this).attr('placeholder', 'Must be write.');
            }
        });
        var val = $('input:radio[name="correctAnswer"]:checked').val();
        if (val == null) {
            isSubmitForm = false;
        }
//        $(".question_id_input").each(function() {
//            if ( ! $(".question_id_input").val()) {
//                isSubmitForm = false;
//                $(this).attr('placeholder', 'Must be write.');
//            }
//
//        });
        $(".question_titel_input").each(function() {
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
            $("form").submit();
        }
    });
    $(".handle_submit_cancel").click(function() {
        location.href = basePath + "question/list";
    });