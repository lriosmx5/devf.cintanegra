//var message = "Hello World";
//console.log(message);
//document.body.innerHTML = message;
//Generated by typescript 1.8.10
var Greeting = (function () {
    function Greeting() {
    }
    Greeting.prototype.greet = function () {
        var message = "Hello World";
       console.log(message);
       document.body.innerHTML = message;
    };
     return Greeting;
 }());
 
 var obj = new Greeting();
 obj.greet()