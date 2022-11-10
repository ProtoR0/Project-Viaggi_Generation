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
let sponsor = ["/Project-Viaggi_Generation/static/img/mare.jpg", "/Project-Viaggi_Generation/static/img/grecia.jpg", "/Project-Viaggi_Generation/static/img/woman.jpg","/Project-Viaggi_Generation/static/img/tropicalel.jpg"];
let casuale = Math.floor(Math.random()*3);
document.getElementById("banner").innerHTML = '<img src="' + sponsor[casuale] + '" style="width: 100%; height: 125px; border-radius: 10px;" />';
setTimeout("sponsor()", 500);
}