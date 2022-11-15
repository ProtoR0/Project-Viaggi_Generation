$(document).ready(function(){
    $(".aside").mouseenter(function(){
        $(this).animate({
            right:"1px",
            width:"80%",
            height:"auto"
        });
        $(this).css({
            "box-shadow":  "10px  10px 5px #a9a9a9, -10px -10px 5px #a9a9a9, 10px -10px 5px #a9a9a9, -10px  10px 5px #a9a9a9"
        });
    });
        $(".aside").mouseleave(function(){
            $(this).animate({
                left:"1px",
                width:"70%",
                height:"auto"
            });
            $(this).css({
                "box-shadow":  "0px  0px 0px #a9a9a9, 0px 0px 0px #a9a9a9, 0px -0px 0px #a9a9a9, -0px  0px 0px #a9a9a9"
            });
    });

});


function zero(numero) {
    if (numero<10) {
        numero = "0" + numero;
    }

    return numero;
}
window.addEventListener("load", data);
function data() {

    let data = new Date();

    let ora = zero(data.getHours());
    let minuti = zero(data.getMinutes());
    let secondi = zero(data.getSeconds());

document.getElementById("orologio").innerHTML = (ora + ":" + minuti + ":" + secondi);
setTimeout("data()", 1000);

}
