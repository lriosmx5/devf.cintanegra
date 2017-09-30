/*function reqListener () {
    console.log(this.responseText);
  }
  */
var oReq = new XMLHttpRequest();
oReq.onload = function (e) {
    var response = oReq.response;
    console.log(response);
    document.body.innerHTML = response;
};
//oReq.addEventListener("load", reqListener);
oReq.open("GET", "https://api.github.com/users/lriosmx5");
oReq.responseType = "json";
oReq.send();
