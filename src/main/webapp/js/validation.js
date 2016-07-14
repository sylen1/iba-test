$( function() {
    $( "#datepicker" ).datepicker({
        dateFormat: "d.mm.yy"
    });
    
    jQuery.validator.addMethod("notNumber", function(value, element, param) {
        var reg = /[0-9]/;
        return !reg.test(value);

    }, "Number is not permitted.");

    jQuery.validator.addMethod("past", function(value, element, param) {
        var now = new Date();
        var fields = value.split(".").map(function(x) { return parseInt(x, 10) });
        var date = new Date(fields[2], fields[1]-1, fields[0]);
        return date < now;

    }, "Date must be in the past.");



    $("#student-form").validate({
        onkeyup: false,
        onclick: false,
        onblur: false,
        rules: {
            firstName: {
                required: true,
                rangelength: [1, 60],
                notNumber: true
            },
            lastName: {
                required: true,
                rangelength: [1, 60],
                notNumber: true
            },
            dateOfBirth: {
                required: true,
                past: true
            },
            sex: {
                required: true
            }
        }
    });
} );