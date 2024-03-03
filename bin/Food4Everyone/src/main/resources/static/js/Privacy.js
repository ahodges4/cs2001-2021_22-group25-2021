
var formInput =
{
name:null,
email:null,
Feedback:null
}

function readForm() //points to the user input for the specifed parts of the form and stores them.
{
formInput.name = document.getElementById("name");
formInput.email = document.getElementById("email");
formInput.Feedback = document.getElementById("Feedback");
}



function createNewParagraph(content){  //wanted this section to see what was being sent to the backend.
    var text = document.createTextNode(content);
    var paragraph = document.createElement("p");
    paragraph.appendChild(text);

    var element = document.getElementById("hiddenSection");
    element.appendChild(paragraph);
}

function submitFormtoReqRes(){
    readForm();
        //Prepare data to submit 
        const data = {Feedback: formInput.Feedback.value, 
                      email: formInput.email.value,
                      name : formInput.name,value,
                      };

        //Call fetch to submit the data with POST
        //Note how the data is sent in the body, using stringify
        fetch('https://reqres.in/api/users',{
            method:'POST',
            headers: {
                'Content-Type':'application/json',
            },
            body:JSON.stringify(data)
        })
        //When the response comes, convert to JSON
        .then(response => response.json())
        //Take the JSON respnse, and log it to console
        //Also, display it as a new paragraph, filtering only username and userType
        .then(responseJSON => {
          console.log('Success',responseJSON);
          createNewParagraph(JSON.stringify(responseJSON, ['name','email','Feedback']));
        })
        //All errors are logged to console
      .catch(err => console.log(err));
  }



