//https://maps.googleapis.com/maps/api/directions/json?origin=19.4301524,-99.211045&destination=20.5307051,-97.457894&key=AIzaSyBAvGj8Asdi5OVQpxZAsk5TBOPzBB54WiQ
//https://maps.googleapis.com/maps/api/directions/json?origin=20.603521,-103.424040&destination=20.646343, -103.413554&key=AIzaSyBAvGj8Asdi5OVQpxZAsk5TBOPzBB54WiQ

/*function reqListener () {
    console.log(this.responseText);
  }
  */

  var oReq = new XMLHttpRequest();
  oReq.onload=function(e){
      var response = oReq.response;
      //var routes = response.routes;
      var route = response.routes[0];
      console.log(route);
      var leg = route.legs[0];
      var steps = leg.steps;      

      var distancia = "La distancia es " +  leg.distance.text + "<BR />";
      var duracion  = "La duracion es " + leg.duration.text + "<BR />";

      document.body.appendChild(document.createTextNode(distancia));         // Create a text node
      document.body.appendChild(document.createTextNode(duracion));         // Create a text node
      //distancia 
      //duracion
      
    var instrucciones = "Intrucciones : <BR />";
      steps.forEach(element => {        
        var node = document.createElement("LI");                 // Create a <li> node
        var instruccion = element.html_instructions;
        console.log(instruccion);
        //var textnode = document.createTextNode(instruccion);         // Create a text node
        //var textnode = document.createElement(instruccion);         // Create a text node
        //node.appendChild(textnode);                              // Append the text to <li>          
        //document.body.appendChild(node);     // Append <li> to <ul> with id="myList"
        instrucciones += instruccion + "<BR />";
        
      });            

      document.body.innerHTML = distancia + duracion + instrucciones;
      //console.log(response);            
      
    };

  //oReq.addEventListener("load", reqListener);
  oReq.open("GET", "https://maps.googleapis.com/maps/api/directions/json?origin=19.4301524,-99.211045&destination=20.5307051,-97.457894&key=AIzaSyBAvGj8Asdi5OVQpxZAsk5TBOPzBB54WiQ");
  oReq.responseType = "json";
  oReq.send();
  