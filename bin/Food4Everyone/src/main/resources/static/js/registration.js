var pass = document.getElementById("pass1")
pass.addEventListener("keyup", function(){
    checkpassword(pass1.value)
})

function checkpassword(pass1){
    var strengthBar = document.getElementById("strength")
    var strength = 0;
    if (pass1.match(/[a-zA-z0-9][a-zA-z0-9]+/)) {
        strength += 1
    }
    if (pass1.match(/[~<>?]+/)) {
        strength += 1
    }
    if (pass1.match(/[!@£$%^&*()]+/)) {
        strength += 1
    }
    if (pass1.length > 8) {
        strength += 1
    }

    switch(strength){
        case 0:
            strengthBar.value = 20;
            message
            break
        case 1:
            strengthBar.value = 40;
            break
        case 2:
            strengthBar.value = 60;
            break
        case 3:
            strengthBar.value = 80;
            break
        case 4:
            strengthBar.value = 100;
            break

    }
    

}

function validate(){
    var pass = document.getElementById("pass1");
    var upper = document.getElementById("upper");
    var lower = document.getElementById("lower");
    var number = document.getElementById("number");
    var len = document.getElementById("length");
    var sp_char = document.getElementById("special_char");

    if(pass.value.match(/[0-9]/)){
        number.style.color = "green"
    }
    else{
        number.style.color = "red"
    }

    if(pass.value.match(/[A-Z]/)){
        upper.style.color = "green"
    }
    else{
        upper.style.color = "red"
    }

    if(pass.value.match(/[a-z]/)){
        lower.style.color = "green"
    }
    else{
        lower.style.color = "red"
    }

    if(pass.value.match(/[!\@\#\£\$\%\^\&\*\()\-\=\+\?\<\>\.\,]/)){
        sp_char.style.color = "green"
    }
    else{
        sp_char.style.color = "red"
    }

    if(pass.value.length > 8){
        len.style.color = "green"
    }
    else{
        len.style.color = "red"
    }

    function conform(){
        var pass1 = document.getElementById("pass1")
        var pass2 = document.getElementById("pass2")
        if(pass1.value == pass2.value){
            document.getElementById("number").style.display ="none";
            document.getElementById("length").style.display ="none";
            document.getElementById("special_char").style.display ="none";
            document.getElementById("upper").style.display ="none";
            document.getElementById("lower").style.display ="none";
        }
        else{
            document.getElementById("number").style.display ="block";
            document.getElementById("length").style.display ="block";
            document.getElementById("special_char").style.display ="block";
            document.getElementById("upper").style.display ="block";
            document.getElementById("lower").style.display ="block";

        }
    }

}



