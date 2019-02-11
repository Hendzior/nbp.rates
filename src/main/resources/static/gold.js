$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/getgold"
    }).then(function(data) {
       $('.date').append(data[0].data);
       $('.rate').append(data[0].cena);
    });
});