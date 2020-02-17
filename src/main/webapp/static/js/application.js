$(function() {

    $('#editTab a').click(function (e) {
        e.preventDefault()
        $(this).tab('show')
    })

    $('#registration').click(function (e) {
        $('#regWindow').modal('show');
    })

    $('#signUpForm').submit(function (){

            var jsonSignUp = {
                 name: $('.signUp').find('#name').val(),
                 secondName: $('.signUp').find('#secondName').val(),
                 email: $('.signUp').find('#email').val(),
                 password: $('.signUp').find('#password').val(),
                 repeatPassword: $('.signUp').find('#repeatPassword').val(),
        };

        $.ajax({
            type: "POST",
            url: "/sign-up",
            cache: false,
            contentType : "text",
            // data: JSON.stringify(jsonSignUp),
            data:   JSON.stringify(jsonSignUp),
            // contentType: 'text; charset=UTF-8',
            // dataType: 'json',
            success : function(data){
                // alert(JSON.stringify(data));
                // alert(JSON.stringify(data));
                alert(data);
                $('#regWindow').modal('hide');
            },
            error:  function(xhr, str){

                $('#regWindow').modal('hide');
                alert("Ошибка")
                alert(JSON.stringify($('#signUpForm').serialize()));
                alert(JSON.stringify(jsonSignUp));


            }

        });
    return false;
    })
});