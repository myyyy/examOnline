var queryString = location.hash;
$("#queryString").val(queryString);
$("#error_info_image").hide();
$("#error_info_image_second").hide();
    $(".input_submit").click(function() {
        var isSubmitForm = true;
        var userNameNull = false;
        var error_info;
        var userPasswordNull = false;
        if ( ! $("#userName").val()) {
            userNameNull = true;
            error_info = "User Name is required";
            isSubmitForm = false;
            $("#error_info_image").show();
        }
        if ( ! $("#userPassword").val()){
            userPasswordNull = true;
            error_info = "User password is required";
            isSubmitForm = false;
            $("#error_info_image_second").show();
        }
        if (userNameNull&&userPasswordNull) {
            error_info = ("User Name&password is required.");
        }
        if ( ! isSubmitForm) {
            $("#error_info").text(error_info);
            $("#error_info").show;
        }
        if (isSubmitForm) {
            $("form").submit();
         }
    });
    $("#userName").keyup(function() {
        $("#error_info_image").hide();
        $("span").text("");
    });
    $("#userPassword").keyup(function() {
        $("#error_info_image_second").hide();
        $("span").text("");
    });
