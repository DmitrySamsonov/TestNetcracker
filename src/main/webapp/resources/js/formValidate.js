$(function(){
    $("#fio_error_message").hide();
    $("#groupNumber_error_message").hide();
    $("#scolarship_error_message").hide();


    var error_groupNumber = false;
    var error_scolarship = false;

    $("#form_fio").focusout(function(){
        check_fio();
    });
    $("#form_groupNumber").focusout(function(){
        check_groupNumber();
    });
    $("#form_scolarship").focusout(function(){
        check_scolarship();
    });


    function check_fio() {
        var fio_length = $("#form_fio").val().length;
        var fio_english = $("#form_fio").val().match(/^[-a-zA-Z ]+$/i);

        var error_fio = false;

        if (fio_length < 8 || fio_length > 40) {
            $("#fio_error_message").html("Should be between 8-40 characters");
            $("#fio_error_message").show();
            error_fio = true;
        }
        if(!fio_english){
            $("#fio_error_message").html("Only A-Z a-z ");
            $("#fio_error_message").show();
            error_fio = true;
        }
        if(error_fio == false){
            $("#fio_error_message").hide();
        }
    }


    function check_scolarship() {
        var error_scolarship = false;

        if ($("#form_scolarship").val() < 1.0 || $("#form_scolarship").val() > 2.0) {
            $("#scolarship_error_message").html("Should be between 1.0 - 2.0");
            $("#scolarship_error_message").show();
            error_scolarship = true;
        }
        if(error_scolarship == false){
            $("#scolarship_error_message").hide();
        }
    }


});
