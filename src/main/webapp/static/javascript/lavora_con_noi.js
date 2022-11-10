$(document).ready(function(){
    $(".aside").mouseenter(function(){
        $(this).animate({
            right:"1px",
            width:"80%",
            height:"auto"
        });
    });
        $(".aside").mouseleave(function(){
            $(this).animate({
                left:"1px",
                width:"70%",
                height:"auto"
            });
    });

});

window.addEventListener("load", sponsor);
function sponsor (){
let sponsor = ["/Project-Viaggi_Generation/static/img/Tripadvisor.jpg", "/Project-Viaggi_Generation/static/img/viaggi.jpg", "/Project-Viaggi_Generation/static/img/tramonto.jpg"];
let casuale = Math.floor(Math.random()*3);
document.getElementById("banner").innerHTML = '<img src="' + sponsor[casuale] + '" style="width: 600px; height: 125px; border-radius: 5px;" />';
setTimeout("sponsor()", 500);
}