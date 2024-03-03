const Savechanges = document.querySelector("#Savechanges");


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

const saveLead = async () => {
    let adminpreviousemail= document.getElementById("Previous-Email").value
    let adminnewemail= document.getElementById("New-Email").value
    let adminpreviouspassword= document.getElementById("Previous-Password").value
    let adminnewpassword= document.getElementById("pass1").value
    let adminconfirmpassword= document.getElementById("pass2").value

    let response = await fetch("http://localhost:8080/lead/getLeads");
    

    let respone2= await fetch("http://localhost:8080/lead/save", {
        method: "POST" ,
        headers: {
            "Accept" : "application/json",
            "Content-Type" : "application/json"
        },
        body: JSON.stringify({
            previousemail: adminpreviousemail,
            newemail: adminnewemail,
            previouspassword: adminpreviouspassword,
            newpassword: adminnewpassword,
            confirmpassword: adminconfirmpassword

        })

    })
    console.log(respone2)
    console.log(response)
    
}
Savechanges.addEventListener("click", saveLead);

