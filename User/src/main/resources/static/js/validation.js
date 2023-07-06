$(document).ready(function() {
    var First_Name = false
    var Email = false
    var Password = false 

    $("#First_Name").blur(function(){
        if($(this).val() == ""){
            $("#First_Name_Warring").text("This field is required")
            First_Name = false
        }
        else{
            $("#First_Name_Warring").text("")
            First_Name = true
        }
        SubmitToggle()
    })
    
    $("#Email").blur(function(){
        var reg = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/
        if($(this).val() == ""){
            $("#Email_Warring").text("This field is required")
            Email = false
        }
        else if(!reg.test($(this).val())){
            $("#Email_Warring").text("this email worng")
            Email = false
        }
        else{
            $.get("http://localhost:8080/find-email/"+$(this).val(), function(data){
                if(data){
                    $('#Email_Warring').text("email already used")
                    Email = false
                }
                else{
                    $("#Email_Warring").text("")
                    Email = true
                }
            })
        }
        SubmitToggle()
    })

    $("#Password").blur(function(){
        if($(this).val() == ""){
            $("#Password_Warring").text("This field is required")
            Password = false
        }
        else{
            $("#Password_Warring").text("")

            if($(this).val() != $("#Confirm_Password").val() & $("#Confirm_Password").val() != ""){
                $("#Confirm_Password_Warring").text("Passwords do not match")
                Password = false
            }
            else if($(this).val() == $("#Confirm_Password").val()){
                $("#Confirm_Password_Warring").text("")
                Password = true
            }
            
        }
        SubmitToggle()
    })

    $("#Confirm_Password").blur(function(){
        if($(this).val() == ""){
            $("#Confirm_Password_Warring").text("This field is required")
            Password = false
        }
        else if($(this).val() != $("#Password").val()){
            $("#Confirm_Password_Warring").text("Passwords do not match")
            Password = false
        }
        else{
            $("#Confirm_Password_Warring").text("")
            Password = true
        }
        SubmitToggle()
    })

    $("#Submit").click(function(){
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/save-user",
            data: JSON.stringify({
              name: $("#First_Name").val(),
              email: $("#Email").val(),
              password: $("#Password").val()
            }),
            contentType: "application/json; charset=utf-8"
          });
    })
    
    function SubmitToggle(){
        console.log('firstname'+First_Name+" \nEmail"+Email+"\nPassword"+Password);
        if(First_Name & Email & Password){
            $("#Submit").prop("disabled",false)
        }
        else{
            $("#Submit").prop("disabled",true)
        }
    }


    

})// CODE END
