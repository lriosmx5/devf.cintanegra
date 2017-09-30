/*function reqListener () {
    console.log(this.responseText);
  }
  */
var oReq = new XMLHttpRequest();
oReq.onload = function (e) {
    var response = oReq.response;
    var name = response.name;
    var repname = response[0].name;
    console.log(response);
    console.log(name);
    console.log(repname);
};
//oReq.addEventListener("load", reqListener);
oReq.open("GET", "https://api.github.com/users/lriosmx5/repos");
oReq.responseType = "json";
oReq.send();
