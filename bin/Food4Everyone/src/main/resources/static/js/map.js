function initMap() {
    var myMapCenter = {lat: 54.235538, lng: -2.485605};
    
    // Create a map object and specify the DOM element for display.
    var map = new google.maps.Map(document.getElementById('map'), {
        center: myMapCenter,
        zoom: 5
    });
    
    infoWindow = new google.maps.InfoWindow();
    const locationButton = document.createElement("button");

    var opt = {minZoom: 5}; //Furthest that user can zoom out
    map.setOptions(opt);

    locationButton.textContent = "Pan to Current Location"; //Add pan to current location button to map
    locationButton.classList.add("custom-map-control-button");
    map.controls[google.maps.ControlPosition.TOP_CENTER].push(locationButton);

    locationButton.addEventListener("click", () => {
     // Try HTML5 geolocation.
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(
                (position) => {
                    const pos = {
                        lat: position.coords.latitude,
                        lng: position.coords.longitude,
                    };
                    map.setCenter(pos);
                    map.setZoom(14);
                },  
            );
        }
    });


    function markFoodBank(location){
        const pos = {
                        lat: location.lat,
                        lng: location.lng,
                    };
        // Create a marker and set its position.
        var marker = new google.maps.Marker({
           map: map,
        position: pos
    });

    // show store info when marker is clicked
    marker.addListener('click', function(){
        showFoodBankInfo(location);
    });
}

// show foodBank info in text box
function showFoodBankInfo(location){
    const pos2 = {
                        lat: location.lat,
                        lng: location.lng,
                    };
    infoWindow.setPosition(pos2);
    //$.get("http://localhost:8080/foodBanks/ID", {foodBankID : location.foodBankID}).done( function(foodBank){
    $.ajax({data: {foodBankID: location.foodBankID},async:false, type:"GET", url:"http://localhost:8080/foodBanks/ID"}).done(function(foodBank){
    
    if (foodBank.network == "IFAN"){ //Show the network only if the foodbank is apart of one
        var network = foodBank.network + ": "; 
        var image = "https://media.discordapp.net/attachments/382237638507233280/953660769722064946/IFAN-logo.png";
    }else if (foodBank.network == "Trussell Trust"){
        var network = foodBank.network + ": "; 
        var image = "https://media.discordapp.net/attachments/382237638507233280/953660770158264390/Trussell-Trust-logo.png";
    }else{
        var network = "";
        var image = "https://i.imgur.com/pyXYM6X_d.webp?maxwidth=1&fidelity=grand";
    }

    try{//Show Registered Charity Info
        var charity = '<b><br>Charity Registration:</b> ' + foodBank.charity.registration_id.link(foodBank.charity.register_url);
    }catch{
        var charity = '';
    }
    
    infoWindow.setContent(
        '<h1>Food Bank</h1>: <h3>'+ network + foodBank.name +  '</h3>' + "<img width='80' src='" + image + "' ALIGN='right'>"
        + '<b><br><br>Address:</b>' + foodBank.address.link("https://www.google.com/maps/dir//" + foodBank.lat_lng)
        + '<b><br>Email:</b> ' + foodBank.email.link("mailto:" + foodBank.email)
        + '<b><br>Phone:</b> ' + foodBank.phone.link("tel:" + foodBank.phone)
        + '<b><br>Donate:</b> ' + foodBank.url.shopping_list.link(foodBank.url.shopping_list)
        + charity);
    infoWindow.open(map);    	
    });
}


$.get("http://localhost:8080/foodBanks/locations").done(function (foodBankLocation) {
    foodBankLocation.forEach(function(location){
        markFoodBank(location);
});

});

}