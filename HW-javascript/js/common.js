function hitPostEndpoint(){
    var periodToRun = document.getElementById("durationInSec").value;
    var xhttp = new XMLHttpRequest();
    const json = {
        "action": "Start",
        "duration": periodToRun
    };
    xhttp.onreadystatechange = function() {
         if (this.readyState == 4 && this.status == 200) {
            //  alert(this.responseText);
         }
    };
    xhttp.open("POST", "http://localhost:8080/api/instrumentControl", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send(JSON.stringify(json));
}

function hitGETEndpoint(){
var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
         if (this.readyState == 4 && this.status == 200) {
            var resp = JSON.parse(this.responseText);
             document.getElementById("Instrument_status").innerHTML = resp.hardwareStatus;
         }
    };
    xhttp.open("GET", "http://localhost:8080/api/instrumentStats", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send();
}

function periodicRun() {
    var timer = setInterval(function() { 
        var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
         if (this.readyState == 4 && this.status == 200) {
            var resp = JSON.parse(this.responseText);
            document.getElementById("Instrument_status").innerHTML = resp.hardwareStatus;
         }
    };
    xhttp.open("GET", "http://localhost:8080/api/instrumentStats", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send();
    }, 1000);
}